package com.example.weather.memory;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Handler;

import com.example.weather.activities.FirstActivity;
import com.example.weather.api.Weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;


public class MemoryReading extends Thread{
    private Handler handler;
    private Context context;
    public MemoryReading(Context context){
        this.context = context;
        this.handler = new android.os.Handler(new android.os.Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                if(message.what == 1){
                    ArrayList<Weather> weathers = (ArrayList<Weather>) message.obj;
                    FirstActivity.enterSecondPage(weathers, FirstActivity.secondPage.getSecPageActivity());
                }
                return true;
            }
        });
    }
    public void run(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                File file = new File(context.getFilesDir(), "weather_data");

                System.out.println(file.exists());


                StringBuilder result = new StringBuilder();
                try {
                    FileReader fileReader = new FileReader(file);
                    int i;
                    while((i = fileReader.read()) != -1){
                        result.append((char) i);
                    }
                    Weather.processWeatherRes(result.toString(), handler);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
