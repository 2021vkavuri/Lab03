package com.kavurivinay.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Context context;
    Toast toast;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    HashMap idToColor;
    SeekBar seekBar;
    TextView myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences= getSharedPreferences("clickValues", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        context = getApplicationContext();
        idToColor = new HashMap<Integer, String>();
        idToColor.put(2131165280, "RED");
        idToColor.put(2131165217, "BLUE");
        idToColor.put(2131165334, "YELLOW");
        idToColor.put(2131165247, "GREEN");
        seekBar = findViewById(R.id.seekBar);
        myText = findViewById(R.id.TEXT);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                myText.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void onClick(View v)
    {
        TextView t = (TextView) v;
        int count = sharedPreferences.getInt("" + t.getText(), 0);
        count++;
        editor.putInt("" + t.getText(), count);
        editor.apply();
        toast = Toast.makeText(context, t.getText() + ": " + count, Toast.LENGTH_SHORT);
        toast.show();
        Log.i("myApp", t.getText() + " " + count);
    }
}
