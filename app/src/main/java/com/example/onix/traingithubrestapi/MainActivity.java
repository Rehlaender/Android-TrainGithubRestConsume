package com.example.onix.traingithubrestapi;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity implements Callback<GithubUser> {

    public final static String USER_NAME = "com.example.onix.com.example.onix.traingithubrestapi.USERNAME";
    public final static String USER_ID = "com.example.onix.com.example.onix.traingithubrestapi.USERID";
    public final static String USER_PUBLIC_REPOS = "com.example.onix.com.example.onix.traingithubrestapi.USERPUBLICREPOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goGithub(View view) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GithubUserAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GithubUserAPI githubUserAPI = retrofit.create(GithubUserAPI.class);

        Call<GithubUser> call = githubUserAPI.getUser("rehlaender");

        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
        int code = response.code();
        if (code == 200) {
            GithubUser user = response.body();
            Intent intent = new Intent(this, ShowGithubUser.class);
            String userName = user.name;
            String userId = user.id;
            String userPublicRepos = user.public_repos;
            intent.putExtra(USER_ID, userId);
            intent.putExtra(USER_NAME, userName);
            intent.putExtra(USER_PUBLIC_REPOS, userPublicRepos);
            startActivity(intent);
            /*Toast.makeText(this, user.name + ", usuario con el id: " + user.id + " tiene " + user.public_repos + " repositorios publicos"
                    , Toast.LENGTH_LONG).show();*/
        } else {
            Toast.makeText(this, "Wea didnt work", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<GithubUser> call, Throwable t) {
        Toast.makeText(this, "Nope", Toast.LENGTH_LONG).show();
    }

}
