package com.example.uberv.learningdagger2.di.components;

import android.app.Application;
import android.content.Context;

import com.example.uberv.learningdagger2.App;
import com.example.uberv.learningdagger2.data.DataManager;
import com.example.uberv.learningdagger2.data.DbHelper;
import com.example.uberv.learningdagger2.data.SharedPrefsHelper;
import com.example.uberv.learningdagger2.di.modules.ApplicationModule;
import com.example.uberv.learningdagger2.di.qualifier.ApplicationContext;
import com.example.uberv.learningdagger2.di.qualifier.DatabaseInfo;

import javax.inject.Singleton;

import dagger.Component;

/**
 * An interface that will be implemented by Dagger 2 and will use methods described in mentioned module(s)
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    // When dependencies are provided through field injection (@inject on member variables)
    // we have to tell Dagger to scan this class through the implementation of this interface
    void inject(App app);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();
}
