package com.ar4i.gifer.presentation.base.view;

public interface IBaseView {
    String getStringResourseById(int id);
    void showMessage(String message);
    void showLoader();
    void hideLoader();
}
