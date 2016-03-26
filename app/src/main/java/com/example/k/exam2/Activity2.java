package com.example.k.exam2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by 4K on 23.03.2016.
 */
public class Activity2 extends Activity {

    static public long elapsedMillis = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        setNumbers();
        timerStart();
    }
    public void timerStart()
    {
        Chronometer timer = (Chronometer) findViewById(R.id.timer);
        timer.start();
    }
    public void timerStop()
    {
        Chronometer timer = (Chronometer) findViewById(R.id.timer);
        elapsedMillis = SystemClock.elapsedRealtime() - timer.getBase();
        timer.stop();
    }
    public void timer1(View view)
    {
        Chronometer timer = (Chronometer) findViewById(R.id.timer);
        TextView answ = (TextView) findViewById(R.id.answer);
        answ.setTextColor(Color.BLUE);
        elapsedMillis = SystemClock.elapsedRealtime() - timer.getBase();
        answ.setText(Integer.toString((int)elapsedMillis));

    }
    public void drawer(View view)
    {
        TextView answ = (TextView) findViewById(R.id.answer);
        answ.setTextColor(Color.BLUE);
    }
    public void setNumbers()
    {
        Random random = new Random();

        //------block1-----
        TextView firstNum1 = (TextView) findViewById(R.id.text1_1);
        TextView secondNum1 = (TextView) findViewById(R.id.text1_3);
        int fNum1 = random.nextInt(10-1) + 1;
        int sNum1 = random.nextInt(10-1) + 1;
        firstNum1.setText(String.valueOf(fNum1));
        secondNum1.setText(String.valueOf(sNum1));
        //------block2-----
        TextView firstNum2 = (TextView) findViewById(R.id.text2_1);
        TextView secondNum2 = (TextView) findViewById(R.id.text2_3);
        int sNum2 = random.nextInt(10-1) + 1;
        int fNum2 = sNum2 * (random.nextInt(10-1) + 1);
        firstNum2.setText(String.valueOf(fNum2));
        secondNum2.setText(String.valueOf(sNum2));
        //------block3-----
        TextView firstNum3 = (TextView) findViewById(R.id.text3_1);
        TextView secondNum3 = (TextView) findViewById(R.id.text3_3);
        int fNum3 = (random.nextInt(49)+1);
        int sNum3 = (random.nextInt(49)+1);
        firstNum3.setText(String.valueOf(fNum3));
        secondNum3.setText(String.valueOf(sNum3));
        //------block4-----
        TextView firstNum4 = (TextView) findViewById(R.id.text4_1);
        TextView secondNum4 = (TextView) findViewById(R.id.text4_3);
        int sNum4 = (random.nextInt(49)+1);
        int fNum4 = sNum4 + (random.nextInt(49)+1);
        firstNum4.setText(String.valueOf(fNum4));
        secondNum4.setText(String.valueOf(sNum4));
    }

    public boolean mult(View view)
    {
        final Random random = new Random();
        EditText answer = (EditText) findViewById(R.id.text1_5);
        TextView firstNum = (TextView) findViewById(R.id.text1_1);
        TextView secondNum = (TextView) findViewById(R.id.text1_3);

        int answ = Integer.parseInt(answer.getText().toString());
        int fNum = Integer.parseInt(firstNum.getText().toString());
        int sNum = Integer.parseInt(secondNum.getText().toString());
        //firstNum.setText(String.valueOf(random.nextInt(fNum)));
        //secondNum.setText(String.valueOf(random.nextInt(sNum)));
        if (fNum*sNum == answ)
        {
            return true;
        } else {
            return false;
        }

    }

    public boolean div(View view)
    {
        EditText answer = (EditText) findViewById(R.id.text2_5);
        TextView firstNum = (TextView) findViewById(R.id.text2_1);
        TextView secondNum = (TextView) findViewById(R.id.text2_3);
        int answ = Integer.parseInt(answer.getText().toString());
        int fNum = Integer.parseInt(firstNum.getText().toString());
        int sNum = Integer.parseInt(secondNum.getText().toString());
        if (fNum/sNum == answ)
        {
            return true;
        } else {
            return false;
        }

    }

    public boolean summ(View view)
    {
        EditText answer = (EditText) findViewById(R.id.text3_5);
        TextView firstNum = (TextView) findViewById(R.id.text3_1);
        TextView secondNum = (TextView) findViewById(R.id.text3_3);
        int answ = Integer.parseInt(answer.getText().toString());
        int fNum = Integer.parseInt(firstNum.getText().toString());
        int sNum = Integer.parseInt(secondNum.getText().toString());
        if (fNum+sNum == answ)
        {
            return true;
        } else {
            return false;
        }

    }

    public boolean sub(View view)
    {
        EditText answer = (EditText) findViewById(R.id.text4_5);
        TextView firstNum = (TextView) findViewById(R.id.text4_1);
        TextView secondNum = (TextView) findViewById(R.id.text4_3);
        int answ = Integer.parseInt(answer.getText().toString());
        int fNum = Integer.parseInt(firstNum.getText().toString());
        int sNum = Integer.parseInt(secondNum.getText().toString());
        if (fNum-sNum == answ)
        {
            return true;
        } else {
            return false;
        }

    }
    public void checkAnsw(View view)
    {
        if (mult(view) && summ(view) && div(view) && sub(view))
        {
            TextView answ = (TextView) findViewById(R.id.answer);
            Intent intent = new Intent(this,FinalActivity.class);
            timerStop();
            intent.putExtra("time", Long.toString(elapsedMillis/1000));
            startActivity(intent);
            finish();

        } else {
            TextView answ = (TextView) findViewById(R.id.answer);
            answ.setTextColor(Color.RED);
            answ.setText("Не правильно!");
        }
    }
}