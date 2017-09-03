package com.example.uberv.learningdagger2.di.components;

import android.app.Activity;
import android.content.Context;

import com.example.uberv.learningdagger2.MainActivity;
import com.example.uberv.learningdagger2.di.modules.ActivityModule;
import com.example.uberv.learningdagger2.di.qualifier.ActivityContext;
import com.example.uberv.learningdagger2.di.scope.PerActivity;

import dagger.Component;

@PerActivity // tie to an activity scope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    Activity getActivity();

    @ActivityContext
    Context getContext();
}
