package com.ar4i.gifer.presentation.main.presenter;

import com.ar4i.gifer.R;
import com.ar4i.gifer.domain.IGifInteractor;
import com.ar4i.gifer.presentation.base.presenter.BasePresenter;
import com.ar4i.gifer.presentation.main.view.IMainView;

import java.net.UnknownHostException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<IMainView> {

    public MainPresenter(IGifInteractor gifInteractor) {
        this.gifInteractor = gifInteractor;
    }

    //==========================================start fields========================================
    private IGifInteractor gifInteractor;
    //-------------------------------------------end fields-----------------------------------------


    //==========================================start extends BasePresenter<IMainView>==============
    @Override
    public void attachView(IMainView view) {
        super.attachView(view);

        track(getView().onEnterKeyPressed()
                .subscribe(isEnterPressed -> {
                    if (isEnterPressed) {
                        String searchQuery = getView().getSearchQuery();
                        if (searchQuery != null && !searchQuery.isEmpty()) {
                            getView().hideKeyboard();
                            getView().clearSearchView();
                            getGifs(searchQuery.toLowerCase());
                        }
                    }
                }));
    }
    //-------------------------------------------end extends BasePresenter<IMainView>---------------


    //==========================================start private methods===============================
    private void getGifs(String searchQuery) {
        track(gifInteractor.getGifUrls(searchQuery, 30)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getView().showLoader())
                .doOnEvent((strings, throwable) -> getView().hideLoader())
                .subscribe(gifs -> {
                            if (gifs != null) {
                                getView().showNotFoundMessage(gifs.isEmpty());
                                getView().setUrls(gifs);
                            }
                        }, error -> {
                            if (error instanceof UnknownHostException) {
                                getView().showMessage(getView().getStringResourseById(R.string.сheck_network_connectivity));
                            } else {
                                getView().showMessage(error.getMessage());
                            }
                        }
                ));
    }
    //-------------------------------------------end private methods--------------------------------
}
