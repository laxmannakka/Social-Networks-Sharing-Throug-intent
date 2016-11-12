package com.bridgelabz.facebookwhatsupsharing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by bridgeit007 on 11/11/16.
 */

public class Utilityies {

    public void sendMessae(Context mContext){


        //You can read the image from external drove too
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.image);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "hello sharing through my app");
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_STREAM,"laxman");
        // intent.setType("image/jpeg");
        intent.setPackage("com.whatsapp");
       mContext.startActivity(intent);

    }
    public  void eMailShare(Context mContext){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"laxmannakka143@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
        try {
           mContext. startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
        }
    }

    public  void shareTwitter(Activity activity, String text, String url, String via, String hashtags) {
        StringBuilder tweetUrl = new StringBuilder("https://twitter.com/intent/tweet?text=");
        tweetUrl.append(TextUtils.isEmpty(text) ? urlEncode(" ") : urlEncode(text));
        if (!TextUtils.isEmpty(url)) {
            tweetUrl.append("&url=");
            tweetUrl.append(urlEncode(url));
        }
        if (!TextUtils.isEmpty(via)) {
            tweetUrl.append("&via=");
            tweetUrl.append(urlEncode(via));
        }
        if (!TextUtils.isEmpty(hashtags)) {
            tweetUrl.append("&hastags=");
            tweetUrl.append(urlEncode(hashtags));
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl.toString()));
        List<ResolveInfo> matches = activity.getPackageManager().queryIntentActivities(intent, 0);
        for (ResolveInfo info : matches) {
            if (info.activityInfo.packageName.toLowerCase().startsWith("com.twitter")) {
                intent.setPackage(info.activityInfo.packageName);
            }
        }
        activity.startActivity(intent);
    }
    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.wtf("wtf", "UTF-8 should always be supported", e);
            throw new RuntimeException("URLEncoder.encode() failed for " + s);
        }
    }

    public void facebookShare(Context mContext){

        String uri = "facebook://facebook.com/inbox";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
       mContext .startActivity(intent);

    }

}
