package com.ar4i.gifer.presentation.base.presenter;

import com.ar4i.gifer.presentation.base.view.IBaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IBaseView> implements IPresenter<V> {

    //==========================================start Fields========================================
    private V view;
    private CompositeDisposable compositeDisposable;
    //-------------------------------------------end Fields-----------------------------------------

    //==========================================start implements IPresenter<V>======================
    @Override
    public void attachView(V view) {
        this.view = view;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void detachView() {
        this.view = null;
        if (this.compositeDisposable != null) {
            this.compositeDisposable.dispose();
            this.compositeDisposable = null;
        }

    }
    //-------------------------------------------end implements IPresenter<V>-----------------------


    //==========================================start public methods================================
    protected V getView() {
        return this.view;
    }

    protected void track(Disposable disposable) {
        if (this.compositeDisposable != null) {
            this.compositeDisposable.add(disposable);
        }
    }
    //-------------------------------------------end public methods---------------------------------

}
