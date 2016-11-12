package com.bridgelabz.facebookwhatsupsharing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class EmailShare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_share);

        Intent i = new Intent(Intent.ACTION_SEND);
     //   i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"laxmannakka143@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(EmailShare.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
