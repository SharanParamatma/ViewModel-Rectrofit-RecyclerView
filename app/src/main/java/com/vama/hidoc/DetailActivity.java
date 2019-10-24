package com.vama.hidoc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    Resultarray resultarray;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView text=findViewById(R.id.text);
        Intent i = getIntent();
        resultarray = (Resultarray) i.getSerializableExtra("Model");
        if (resultarray != null) {
            text.setText(resultarray.getId()
                    +"\n"+resultarray.getTitle()
                    +"\n"+resultarray.getDate()
                    +"\n"+resultarray.getSummary()+"\n"+Html.fromHtml(resultarray.getDescription()));
          /*  code here for more data*/
        }
    }
}
