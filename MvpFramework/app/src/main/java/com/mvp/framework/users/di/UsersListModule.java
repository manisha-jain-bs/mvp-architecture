package com.mvp.framework.users.di;

import com.mvp.framework.http.UsersApiService;
import com.mvp.framework.users.data.Repository;
import com.mvp.framework.users.data.UsersListModel;
import com.mvp.framework.users.data.UsersListRepository;
import com.mvp.framework.users.ui.UsersListActivityMVP;
import com.mvp.framework.users.ui.UsersListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UsersListModule {

    @Provides
    public UsersListActivityMVP.Presenter provideUsersListActivityPresenter(UsersListActivityMVP.Model topMoviesModel) {
        return new UsersListPresenter(topMoviesModel);
    }

    @Provides
    public UsersListActivityMVP.Model provideUsersListActivityModel(Repository repository) {
        return new UsersListModel(repository);
    }

    @Singleton
    @Provides
    public Repository provideRepo(UsersApiService usersApiService) {
        return new UsersListRepository(usersApiService);
    }

}
