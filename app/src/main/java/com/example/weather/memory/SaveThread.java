package com.example.weather.memory;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveThread extends Thread{
    private Handler handler;
    private String content;
    private Context context;
    public SaveThread(Context context){
        this.context = context;
        this.handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                return true;
            }
        });
    }
    public void run(){
        handler.post(new Runnable() {
            @Override
            public void run() {

                File file = new File(context.getFilesDir(), "weather_data");
                try {
                    PrintWriter pw = new PrintWriter(file);
                    pw.close();
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(content);
                    fileWriter.flush();
                    System.out.println("saved!!!!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setContent(String content) {
        this.content = content;
    }
}
