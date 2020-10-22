package com.example.sanv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);
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
                    startActivity(new Intent(MainActivity2.this, MainActivity3.class));
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}