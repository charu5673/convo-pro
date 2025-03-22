package com.example.convert;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConvertArea extends AppCompatActivity implements View.OnClickListener{
    ImageButton swap;
    Spinner from;
    Spinner to;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.area_convert);
        TextView t=findViewById(R.id.title_textview);
        String title=getIntent().getStringExtra("category")+" Units";
        t.setText(title);
        assignbId(swap,R.id.swap_button);
        from = (Spinner) findViewById(R.id.from_drop);
        to = (Spinner) findViewById(R.id.to_drop);
        adapter = ArrayAdapter.createFromResource(
                this,
                getId((getIntent().getStringExtra("category").toLowerCase())+"_units"),
                R.layout.spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from.setAdapter(adapter);
        to.setAdapter(adapter);
        EditText input=findViewById(R.id.input_field);
        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                convert(input.getText().toString(),getIntent().getStringExtra("category"),from.getSelectedItem().toString(),to.getSelectedItem().toString());
            }@Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                convert(input.getText().toString(),getIntent().getStringExtra("category"),from.getSelectedItem().toString(),to.getSelectedItem().toString());
            }@Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        input.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){
                convert(String.valueOf(s),getIntent().getStringExtra("category"),from.getSelectedItem().toString(),to.getSelectedItem().toString());
            }
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        float f = getResources().getDisplayMetrics().density;
        EditText inp=findViewById(R.id.input_field);
        TextView out=findViewById(R.id.output_field);
        float h=inp.getTextSize();
        h=h/f;
        out.setTextSize(h);
    }


    void convert(String inp, String name,String from,String to)
    {
        double input=0d;
        try {
             input= Double.parseDouble(inp);
        }
        catch(Exception e)
        {
            input=0d;
        }
        double ans=0d;
        switch(name)
        {
            case "Length": ans=Length.convert(input, from, to); break;
            case "Area": ans=Area.convert(input, from, to); break;
            case "Volume": ans=Volume.convert(input, from, to); break;
            case "Weight": ans=Weight.convert(input, from, to); break;
            case "Temperature": ans=Temperature.convert(input, from, to); break;
            case "Speed": ans=Speed.convert(input, from, to); break;
            case "Energy": ans=Energy.convert(input, from, to); break;
            case "Power": ans=Power.convert(input, from, to); break;
            case "Pressure": ans=Pressure.convert(input, from, to); break;
            case "Frequency": ans=Frequency.convert(input, from, to); break;
            case "Density": ans=Density.convert(input, from, to); break;
            case "Data": ans=Data.convert(input, from, to); break;
            case "Time": ans=Time.convert(input, from, to); break;
            case "Angles": ans=Angles.convert(input, from, to); break;
            default: break;
        }
        TextView output=findViewById(R.id.output_field);
        String formattedAns = String.format("%.5f", ans).replaceAll("0+$", "").replaceAll("\\.$", "");
        output.setText(formattedAns);
    }

    @Override
    public void onClick(View v) {
        ImageButton button = (ImageButton)v;
        int id = button.getId();
        if(id==R.id.swap_button)
        {
            String pos=from.getSelectedItem().toString();
            from.setSelection(adapter.getPosition(to.getSelectedItem().toString()));
            to.setSelection(adapter.getPosition(pos));
        }
    }
    void assignbId(ImageButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    int getId(String str)
    {
        str="R.array."+str;
        return(getResources().getIdentifier(str.replace("R.array.", ""), "array", getPackageName()));
    }
}