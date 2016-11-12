package com.bridgelabz.facebookwhatsupsharing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

import static android.R.id.message;

public class Whatsup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsup);
        try {
            sendMessae();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void sendMessae() throws FileNotFoundException {


        //You can read the image from external drove too
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
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
        startActivity(intent);

    }
}
