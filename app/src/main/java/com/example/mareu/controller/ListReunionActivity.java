package com.example.mareu.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.mareu.R;
import com.example.mareu.model.Reunion;
import com.example.mareu.service.ReunionApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import butterknife.ButterKnife;

public class ListReunionActivity extends AppCompatActivity {

    private ReunionApiService mApiService;
    private List<Reunion> mNeighbours;
    private RecyclerView mRecyclerView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_reunion_list);
        ButterKnife.bind(this);

        FloatingActionButton addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(view -> {
            Intent intent = new Intent(ListReunionActivity.this, AddReunionActivity.class);
            startActivity(intent);
        });

    }

    private void initList() {

        mReunion = mApiService.getReunion();
        mRecyclerView.setAdapter(new ReunionRecyclerViewAdapter(mReunion));

    }
}
