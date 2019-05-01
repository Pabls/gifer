package com.ar4i.gifer.presentation.main.view;

import com.ar4i.gifer.R;
import com.ar4i.gifer.presentation.base.presenter.IPresenter;
import com.ar4i.gifer.presentation.base.view.BaseFragment;
import com.ar4i.gifer.presentation.main.presenter.MainPresenter;

import javax.inject.Inject;

public class MainFragment extends BaseFragment implements IMainView {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    //==========================================start fields========================================

    @Inject
    MainPresenter mainPresenter;

    //-------------------------------------------end fields-----------------------------------------


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

}
