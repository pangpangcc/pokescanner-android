package com.pokescannerapp.android;

import android.app.Application;

import com.pokescannerapp.android.core.components.AppComponent;
import com.pokescannerapp.android.core.components.DaggerAppComponent;
import com.pokescannerapp.android.core.modules.ApiModule;
import com.pokescannerapp.android.core.modules.AppModule;
import com.pokescannerapp.android.core.modules.NetModule;
import com.pokescannerapp.android.core.modules.UtilitiesModule;

public class MainApplication extends Application {

    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this))
                .netModule(new NetModule(getString(R.string.server_url)))
                .apiModule(new ApiModule())
                .utilitiesModule(new UtilitiesModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
