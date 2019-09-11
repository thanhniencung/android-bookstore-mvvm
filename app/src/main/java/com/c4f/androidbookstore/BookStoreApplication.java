package com.c4f.androidbookstore;

import android.app.Application;

public class BookStoreApplication extends Application {
    static BookStoreApplication app;
    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
    }

    public static BookStoreApplication getApp() {
        return app;
    }
}
