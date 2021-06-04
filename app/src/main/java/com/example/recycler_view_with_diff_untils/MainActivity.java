package com.example.recycler_view_with_diff_untils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recycler_view_with_diff_untils.until.MyAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    Button btnUpdate;
    RecyclerView recyclerView;

    List<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        initData();
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            dataList.add(UUID.randomUUID().toString());
        }
    }

    private void initComponent() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter(dataList);
        recyclerView.setAdapter(adapter);

        btnInsert = findViewById(R.id.btnInsert);
        btnUpdate = findViewById(R.id.btnUpdate);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> insertList = new ArrayList<>(); // Assign old data
                for (int i = 0; i < 3; i++) {
                    insertList.add(UUID.randomUUID().toString()); // Add new data
                    adapter.insertData(insertList);
                    recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1); // auto scroll to last item
                }
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> updateList = new ArrayList<>(); // Assign old data
                for (int i = 0; i < 3; i++) {
                    updateList.add(UUID.randomUUID().toString()); // Add new data
                    adapter.updateData(updateList);
                }
            }
        });
    }
}