package com.example.uberv.learningdagger2.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.uberv.learningdagger2.di.qualifier.ApplicationContext;
import com.example.uberv.learningdagger2.di.qualifier.DatabaseInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

//    @Singleton
    @Provides
    @ApplicationContext
    Context provideContext() {
        Timber.d("provideContext()");
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        Timber.d("provideApplication()");
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        Timber.d("provideDatabaseName()");
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        Timber.d("provideDatabaseVersion()");
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        Timber.d("provideSharedPrefs()");
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }
}
