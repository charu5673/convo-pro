package com.example.convert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView convo,pro;
    Button[] categoriesButtons=new Button[14];
    DisplayMetrics displaymetrics;
    View convoL,proL,s1;
    LinearLayout ls1;
    int i;

    LinkedList<String> categories=new LinkedList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convo=findViewById(R.id.convo);
        pro=findViewById(R.id.pro);
        convoL=findViewById(R.id.convoL);
        proL=findViewById(R.id.proL);
        categories.add("Length");
        categories.add("Weight");
        categories.add("Volume");
        categories.add("Area");
        categories.add("Time");
        categories.add("Temperature");
        categories.add("Speed");
        categories.add("Energy");
        categories.add("Power");
        categories.add("Pressure");
        categories.add("Frequency");
        categories.add("Density");
        categories.add("Data");
        categories.add("Angles");
        for(int i=0;i<14;i++)
            assignbId(categoriesButtons[i],getId(categories.get(i).toLowerCase()));
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        displaymetrics = new DisplayMetrics();
        float f = getResources().getDisplayMetrics().density;
        float h=convoL.getHeight();
        h=h/f;
        convo.setTextSize(h);
        pro.setTextSize(h/2);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button)v;
        String text = button.getText().toString();
        if(categories.contains(text))
        {
            Intent i=new Intent(getApplicationContext(),ConvertArea.class);
            i.putExtra("category",text);
            startActivity(i);
            setContentView(R.layout.area_convert);
        }
    }
    void assignbId(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    int getId(String str)
    {
        str="R.id."+str;
        return(getResources().getIdentifier(str.replace("R.id.", ""), "id", getPackageName()));
    }
}