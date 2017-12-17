package com.mvp.framework.root;


import com.mvp.framework.http.ApiModule;
import com.mvp.framework.users.ui.UsersListActivity;
import com.mvp.framework.users.di.UsersListModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {ApplicationModule.class, UsersListModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(UsersListActivity target);
}