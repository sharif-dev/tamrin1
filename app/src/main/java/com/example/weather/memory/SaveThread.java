package com.example.weather.memory;

import android.content.Context;
import android.os.Handler;
import com.example.weather.R;
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
        this.handler = new Handler(message -> true);
    }
    public void run(){
        handler.post(() -> {

            File file = new File(context.getFilesDir(), String.valueOf(R.string.file_name));
            try {
                PrintWriter pw = new PrintWriter(file);
                pw.close();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(content);
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void setContent(String content) {
        this.content = content;
    }
}
