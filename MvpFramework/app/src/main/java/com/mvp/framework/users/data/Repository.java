package com.mvp.framework.users.data;

import com.mvp.framework.http.apimodel.Result;

import rx.Observable;


public interface Repository {

    Observable<Result> getResultsFromMemory();

    Observable<Result> getResultsFromNetwork();

    Observable<Result> getResultData();
}
