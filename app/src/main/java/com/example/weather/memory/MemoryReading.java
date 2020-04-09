package com.example.weather.memory;
import android.content.Context;
import android.os.Handler;
import com.example.weather.R;
import com.example.weather.activities.FirstActivity;
import com.example.weather.api.Weather;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class MemoryReading extends Thread{
    private Handler handler;
    private Context context;
    public MemoryReading(Context context){
        this.context = context;
        this.handler = new android.os.Handler(message -> {
            if(message.what == 1){
                ArrayList<Weather> weathers = (ArrayList<Weather>) message.obj;
                FirstActivity.enterSecondPage(weathers, FirstActivity.secondPage.getSecPageActivity());
            }
            return true;
        });
    }
    public void run(){
        handler.post(() -> {
            File file = new File(context.getFilesDir(), String.valueOf(R.string.file_name));

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

        });
    }
}
