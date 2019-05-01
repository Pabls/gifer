package com.ar4i.gifer.presentation.main.view;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.ar4i.gifer.R;
import com.ar4i.gifer.presentation.base.presenter.IPresenter;
import com.ar4i.gifer.presentation.base.view.BaseFragment;
import com.ar4i.gifer.presentation.main.presenter.MainPresenter;
import com.jakewharton.rxbinding2.support.v7.widget.RxSearchView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


public class MainFragment extends BaseFragment implements IMainView {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    //==========================================start ui============================================
    RecyclerView rvGifs;
    SearchView searchViewEditText;
    //-------------------------------------------end ui---------------------------------------------


    //==========================================start fields========================================
    @Inject
    MainPresenter mainPresenter;
    GifsAdapter gifsAdapter;
    TextView tvNotFound;
    ProgressBar pbProgress;
    //-------------------------------------------end fields-----------------------------------------


    //==========================================start lifecycle=====================================
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
        super.onViewCreated(view, savedInstanceState);
    }


    //-------------------------------------------end lifecycle--------------------------------------


    //==========================================start extends Fragment==============================
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.options_menu, menu);
        MenuItem actionSearch = menu.findItem(R.id.menu_search);
        searchViewEditText = (SearchView) actionSearch.getActionView();
        if (getPresenter() != null)
            getPresenter().attachView(this);
    }
    //-------------------------------------------end extends Fragment-------------------------------


    //==========================================start extends BaseFragment==========================
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected IPresenter getPresenter() {
        return mainPresenter;
    }

    @Override
    protected void inject() {
        getApplicationComponent().inject(this);
    }
    //-------------------------------------------end extends BaseFragment---------------------------


    //==========================================start implements IMainView==========================
    @Override
    public Observable<Boolean> onEnterKeyPressed() {
        return RxSearchView.queryTextChangeEvents(searchViewEditText)
                .map(searchViewQueryTextEvent -> searchViewQueryTextEvent.isSubmitted());
    }

    @Override
    public String getSearchQuery() {
        return searchViewEditText.getQuery().toString();
    }

    @Override
    public void setUrls(List<String> urls) {
        gifsAdapter.addAllAndNotify(urls);
    }

    @Override
    public void hideKeyboard() {
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

    @Override
    public void clearSearchView() {
        searchViewEditText.setQuery(getString(R.string.empty), false);
        searchViewEditText.setIconified(true);
    }

    @Override
    public void showNotFoundMessage(boolean show) {
        tvNotFound.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showLoader() {
        pbProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        pbProgress.setVisibility(View.GONE);
    }
    //-------------------------------------------end implements IMainView --------------------------


    //==========================================start private methods===============================
    private void initView() {
        rvGifs = getActivity().findViewById(R.id.rv_gifs);
        tvNotFound = getActivity().findViewById(R.id.tv_message);
        pbProgress = getActivity().findViewById(R.id.pb_progress);
        gifsAdapter = new GifsAdapter();
        rvGifs.setAdapter(gifsAdapter);
    }
    //-------------------------------------------end private methods--------------------------------
}
