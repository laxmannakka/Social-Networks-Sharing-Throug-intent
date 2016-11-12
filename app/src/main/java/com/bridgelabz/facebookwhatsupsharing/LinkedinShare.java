package com.bridgelabz.facebookwhatsupsharing;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.linkedin.platform.APIHelper;
import com.linkedin.platform.errors.LIApiError;
import com.linkedin.platform.listeners.ApiListener;
import com.linkedin.platform.listeners.ApiResponse;

import java.util.List;

import static android.R.attr.host;

public class LinkedinShare extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkedin_share);

        String text1= "hi  to linked in";
        Intent linkedinIntent = new Intent(Intent.ACTION_SEND);
        linkedinIntent.setType("text/plain");
        linkedinIntent.putExtra(Intent.EXTRA_TEXT, text1);

        boolean linkedinAppFound = false;
        List<ResolveInfo> matches2 = getPackageManager()
                .queryIntentActivities(linkedinIntent, 0);

        for (ResolveInfo info : matches2) {
            if (info.activityInfo.packageName.toLowerCase().startsWith(
                    "com.linkedin")) {
                linkedinIntent.setPackage(info.activityInfo.packageName);
                linkedinAppFound = true;
                break;
            }
        }

        if (linkedinAppFound) {
            startActivity(linkedinIntent);
        } else {
            Toast.makeText(LinkedinShare.this, "LinkedIn app not Insatlled in your mobile", Toast.LENGTH_SHORT).show();
        }
    }
}