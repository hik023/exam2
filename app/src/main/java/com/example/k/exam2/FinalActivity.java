package com.example.k.exam2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 4K on 24.03.2016.
 */
public class FinalActivity extends AppCompatActivity{

    public static String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Intent intent = getIntent();
        time = intent.getStringExtra("time");
        TextView timeText = (TextView) findViewById(R.id.timeText);
        timeText.setText(time + " сек");
    }

    public void sendMail(View view)
    {
        Intent mailIntent = new Intent(Intent.ACTION_SENDTO);
        mailIntent.setType("text/html");
        mailIntent.setData(Uri.parse("mailto:"));
        mailIntent.putExtra(Intent.EXTRA_SUBJECT,"Мой новый рекорд!!");
        mailIntent.putExtra(Intent.EXTRA_TEXT, time + " СЕК!!! Спорим, ты не сможешь быстрее? :)");
        if (mailIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(mailIntent);
        }
    }
    public void restart(View view)
    {
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
        finish();
    }
}
