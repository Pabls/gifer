package com.ar4i.gifer.presentation.main.view;

import com.ar4i.gifer.presentation.base.view.IBaseView;

import java.util.List;

import io.reactivex.Observable;

public interface IMainView extends IBaseView {
    Observable<Boolean> onEnterKeyPressed();

    String getSearchQuery();

    void setUrls(List<String> urls);

    void hideKeyboard();

    void clearSearchView();

    void showNotFoundMessage(boolean show);
}
