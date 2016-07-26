package com.pokescannerapp.android.core.modules;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilitiesModule {

    @Provides
    @Singleton
    public LocationManager providesLocationManager(Application application) {
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }

}
