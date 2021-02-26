package com.helcode.catalogo_sinevol.config;

import com.orm.SugarApp;
import com.orm.SugarContext;

public class sugar extends SugarApp {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
