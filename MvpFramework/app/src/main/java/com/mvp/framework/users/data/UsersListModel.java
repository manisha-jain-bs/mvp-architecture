package com.mvp.framework.users.data;

import com.mvp.framework.http.apimodel.Result;
import com.mvp.framework.users.ui.UsersListActivityMVP;

import rx.Observable;
import rx.functions.Func1;

public class UsersListModel implements UsersListActivityMVP.Model {

    private Repository repository;

    public UsersListModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> result() {

        return repository.getResultData().flatMap(new Func1<Result, Observable<ViewModel>>() {
            @Override
            public Observable<ViewModel> call(Result result) {
                return Observable.just(new ViewModel(result.getFirstName(), result.getLastName(), result.getAvatar()));
            }
        });
    }
}
