package com.bridgelabz.facebookwhatsupsharing;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Packages extends AppCompatActivity {
    ArrayList<Packagelist> packagelist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        PackageManager pm = getPackageManager();

        List<ApplicationInfo> apps = pm.getInstalledApplications(0);
        List<ApplicationInfo> installedApps = new ArrayList<ApplicationInfo>();

        for (ApplicationInfo app : apps) {
            //checks for flags; if flagged, check if updated system app
            if ((app.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
                installedApps.add(app);
                //it's a system app, not interested
            } else if ((app.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                //Discard this one
                //in this case, it should be a user-installed app
            } else {
                installedApps.add(app);
            }
        }
        for (int i = 0; i < installedApps.size(); i++) {

            String label = (String) pm.getApplicationLabel(installedApps.get(i));
            Drawable icon = pm.getApplicationIcon(installedApps.get(i));
             String[] labels = {"WhatsApp", "Facebook","Gmail","Twitter","LinkedIn"};

            for(int j=0;j<labels.length;j++) {
                if (label.equals(labels[j])) {
                    packagelist.add(new Packagelist(label, icon));
                }
            }
        }
        GridAdapter adapter = new GridAdapter(packagelist, getBaseContext());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             //   new Utilityies(). shareTwitter(Packages.this,"hiii to twitter","null","Nakka Lakshman25@gmail.com","#");
                openList(packagelist.get(i).getAppname(),Packages.this);
            }
        });
    }

    public void openList(String data, Context context){
        switch (data) {
            case "WhatsApp":new Utilityies().sendMessae(context);
                break;
            case "Facebook":
                new Utilityies().facebookShare(context);
                break;
            case "Gmail":
                new Utilityies().eMailShare(context);
                break;
            case "Twitter":
                new Utilityies().shareTwitter(Packages.this,"hiii to twitter","null","Nakka Lakshman25@gmail.com","#");
                break;
        }
    }
}
