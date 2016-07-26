package com.example.onix.traingithubrestapi;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowGithubUser extends Activity {

    private TextView userId, userName, userPrivateRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_github_user);

        userId = (TextView) findViewById(R.id.id_get);
        userName = (TextView) findViewById(R.id.name_get);
        userPrivateRepos = (TextView) findViewById(R.id.public_repos_get);

        Intent intent = getIntent();
        String id = intent.getStringExtra(MainActivity.USER_ID);
        String name = intent.getStringExtra(MainActivity.USER_NAME);
        String public_repos = intent.getStringExtra(MainActivity.USER_PUBLIC_REPOS);

        userId.setText(id);
        userName.setText(name);
        userPrivateRepos.setText(public_repos);
    }

}
