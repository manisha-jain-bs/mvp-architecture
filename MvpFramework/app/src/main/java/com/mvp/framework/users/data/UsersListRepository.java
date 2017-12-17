package com.mvp.framework.users.data;


import com.mvp.framework.http.UsersApiService;
import com.mvp.framework.http.apimodel.Result;
import com.mvp.framework.http.apimodel.Users;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class UsersListRepository implements Repository {

    private UsersApiService usersApiService;
    private List<Result> results;
    private long timestamp;

    private static final long STALE_MS = 20 * 1000; // Data is stale after 20 seconds

    public UsersListRepository(UsersApiService usersApiService) {
        this.usersApiService = usersApiService;
        this.timestamp = System.currentTimeMillis();
        results = new ArrayList<>();

    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }

    @Override
    public Observable<Result> getResultsFromMemory() {

        if (isUpToDate()) {
            return Observable.from(results);
        } else {
            timestamp = System.currentTimeMillis();
            results.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Result> getResultsFromNetwork() {

        Observable<Users> usersObservable = usersApiService.getUsers(1).concatWith(usersApiService.getUsers(2)).concatWith(usersApiService.getUsers(3)).concatWith(usersApiService.getUsers(4));

        return usersObservable.concatMap(new Func1<Users, Observable<Result>>() {
            @Override
            public Observable<Result> call(Users users) {
                return Observable.from(users.getData());
            }
        }).doOnNext(new Action1<Result>() {
            @Override
            public void call(Result result) {
                results.add(result);
            }
        });
    }

    @Override
    public Observable<Result> getResultData() {
        return getResultsFromMemory().switchIfEmpty(getResultsFromNetwork());
    }
}
