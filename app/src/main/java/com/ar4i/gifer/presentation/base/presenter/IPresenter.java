package com.ar4i.gifer.presentation.base.presenter;

import com.ar4i.gifer.presentation.base.view.IBaseView;

public interface IPresenter<V extends IBaseView> {
    void attachView(V view);

    void detachView();
}
