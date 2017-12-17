package com.mvp.framework.http;

import com.mvp.framework.http.apimodel.Users;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface UsersApiService {

    @GET("users")
    Observable<Users> getUsers(@Query("page") Integer page);

}
