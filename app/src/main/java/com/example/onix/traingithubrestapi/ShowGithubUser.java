package com.example.onix.traingithubrestapi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;

public class ShowGithubUser extends Activity {

    private TextView  userAvatar, userId, userLogin, userName, userPrivateRepos;
    ImageView userAvatarImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_github_user);

        userAvatar = (TextView) findViewById(R.id.avatar_url_get);
        userId = (TextView) findViewById(R.id.id_get);
        userLogin = (TextView) findViewById(R.id.login_get);
        userName = (TextView) findViewById(R.id.name_get);
        userPrivateRepos = (TextView) findViewById(R.id.public_repos_get);

        userAvatarImg = (ImageView) findViewById(R.id.avatar_url_image);

        Intent intent = getIntent();
        String avatar_url = intent.getStringExtra(MainActivity.USER_AVATAR_URL);
        String id = intent.getStringExtra(MainActivity.USER_ID);
        String login = intent.getStringExtra(MainActivity.USER_LOGIN).toUpperCase();
        String name = intent.getStringExtra(MainActivity.USER_NAME);
        String public_repos = intent.getStringExtra(MainActivity.USER_PUBLIC_REPOS);

        userAvatar.setText(avatar_url);
        userId.setText(id);
        userLogin.setText(login);
        userName.setText(name);
        userPrivateRepos.setText(public_repos);

        Picasso.with(this).load(avatar_url).into(userAvatarImg);
    }
}
