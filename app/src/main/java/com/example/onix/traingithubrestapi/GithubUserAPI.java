package com.example.onix.traingithubrestapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by onix on 26/07/16.
 */
public interface GithubUserAPI {
    String ENDPOINT = "https://api.github.com/";

    @GET("/users/{user}")
    Call<GithubUser> getUser(@Path("user") String user);
}
