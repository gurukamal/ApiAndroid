package com.example.viewassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentListFragment studentListFragment=new StudentListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.user_list_frag,new StudentListFragment()).commit();

        StudentDetailsFragment studentDetailsFragment1=new StudentDetailsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.user_details_frag,new StudentDetailsFragment()).commit();

}
}
