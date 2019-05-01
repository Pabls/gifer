package com.ar4i.gifer.presentation.base.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ar4i.gifer.app.App;
import com.ar4i.gifer.app.di.ApplicationComponent;
import com.ar4i.gifer.presentation.base.presenter.IPresenter;

public abstract class BaseFragment extends Fragment implements IBaseView {

    //==========================================start lifecycle=====================================
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getPresenter() != null)
            getPresenter().attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getPresenter().detachView();
    }

    //-------------------------------------------end lifecycle--------------------------------------

    //==========================================start implements IBaseView==========================
    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoader() {

    }

    @Override
    public void hideLoader() {

    }
    //-------------------------------------------end implements IBaseView---------------------------


    //==========================================start protected methods=============================

    protected ApplicationComponent getApplicationComponent() {
        return App.getApplicationComponent();
    }

    //-------------------------------------------end protected methods------------------------------

    //==========================================start abstract methods==============================
    protected abstract int getLayoutId();

    protected abstract IPresenter<IBaseView> getPresenter();

    protected abstract void inject();
    //-------------------------------------------end abstract methods-------------------------------
}
