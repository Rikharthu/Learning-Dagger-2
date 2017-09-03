package com.example.uberv.learningdagger2.di.modules;

import android.app.Activity;
import android.content.Context;

import com.example.uberv.learningdagger2.di.qualifier.ActivityContext;
import com.example.uberv.learningdagger2.di.scope.PerActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

/**
 * This class defines methods that provide the dependencies
 */
@Module
public class ActivityModule {
    // Dependency-provider method is identified by a @Provides annotation

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

//    @PerActivity
    @Provides
    @ActivityContext
    Context provideContext() {
        Timber.d("provideContext()");
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        Timber.d("provideActivity()");
        return mActivity;
    }
}
