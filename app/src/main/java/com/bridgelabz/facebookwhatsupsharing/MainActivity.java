package com.bridgelabz.facebookwhatsupsharing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.ShareApi;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button mFb, mWhatsup,mEmail,mLinkedin,mTwitter,mPackages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFb = (Button) findViewById(R.id.fblogin);
        mWhatsup = (Button) findViewById(R.id.whatsup);
        mEmail =(Button)findViewById(R.id.email);
        mTwitter=(Button)findViewById(R.id.linkedin);
        mLinkedin = (Button) findViewById(R.id.twitter);
       mPackages =(Button)findViewById(R.id.showpackges);

        mFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fbshare = new Intent(MainActivity.this, FaceBook.class);
                startActivity(fbshare);
            }
        });
        mWhatsup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wshare = new Intent(MainActivity.this,Whatsup.class);
                startActivity(wshare);
            }
        });
        mEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(MainActivity.this,EmailShare.class);
                startActivity(email);
            }
        });

        mTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent twitter = new Intent(MainActivity.this,Twitter.class);
                startActivity(twitter);
            }
        });

        mLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent linkedin = new Intent(MainActivity.this,LinkedinShare.class);
                startActivity(linkedin);
            }
        });

        mPackages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent packeges = new Intent(MainActivity.this,Packages.class);
                startActivity(packeges);
            }
        });

    }
}



