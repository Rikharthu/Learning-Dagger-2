package com.example.uberv.learningdagger2;

import android.app.Application;
import android.content.Context;

import com.example.uberv.learningdagger2.data.DataManager;
import com.example.uberv.learningdagger2.di.components.ApplicationComponent;
import com.example.uberv.learningdagger2.di.components.DaggerApplicationComponent;
import com.example.uberv.learningdagger2.di.modules.ApplicationModule;

import javax.inject.Inject;

import timber.log.Timber;

public class App extends Application {

    protected ApplicationComponent mApplicationComponent;

    @Inject
    DataManager mDataManager;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this); // Inject member variables since constructor injection is not possible

    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

}
