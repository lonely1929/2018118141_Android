package com.example.servicebestpractice;

public interface DownloadListenner {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPause();

    void onCanceled();
}
