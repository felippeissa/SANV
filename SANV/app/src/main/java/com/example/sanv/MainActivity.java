package com.example.sanv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        final int welcomeScreenDisplay = 1500;
        Thread welcomeThread = new Thread(){
            int wait = 0;
            @Override
            public void run(){
                try{
                    super.run();
                    while(wait < welcomeScreenDisplay){
                        sleep(100);
                        wait += 100;
                    }
                }
                catch(Exception e) {
                System.out.println("Exc=" + e);
                }
                finally {
                    startActivity(new Intent(MainActivity.this, MainActivity2.class));
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}