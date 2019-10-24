package com.vama.hidoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private AdapterData adapter;
    private List<Resultarray> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        DataViewModel model = ViewModelProviders.of(this).get(DataViewModel.class);
        model.getText().observe(this, new Observer<Example>() {
            @Override
            public void onChanged(Example example) {
                adapter = new AdapterData(MainActivity.this, example.getResultarray());
                recyclerView.setAdapter(adapter);
                list=example.getResultarray();
            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerViewClick.RecyclerItemClickListener(this, recyclerView, new RecyclerViewClick.RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                    if (list!=null){
                        Resultarray listData=list.get(position);
                        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                        intent.putExtra("Model", listData);
                        startActivity(intent);
                    }
            }
            @Override
            public void onItemLongClick(View view, int position) {
            }
        }));



    }


}
