package com.example.viewassignment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentListFragment extends Fragment {

    RecyclerView stud_recycle_view;
    RecyclerView.Adapter stud_adapter;
    RecyclerView.LayoutManager stud_layoutManager;
    ApiInterface stud_api;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.student_list,container,false);
        stud_recycle_view=view.findViewById(R.id.student_list_recycle_view);
        stud_layoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        stud_recycle_view.setLayoutManager(stud_layoutManager);
        getData();
        return view;
    }

    public void getData(){
        stud_api = StudentListApiClient.getData().create(ApiInterface.class);
        Call<List<StudentListModal>> studCall;
        studCall = stud_api.getStudent();

        studCall.enqueue(new Callback<List<StudentListModal>>() {
            @Override
            public void onResponse(Call<List<StudentListModal>> call, Response<List<StudentListModal>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getContext(),"Fail",Toast.LENGTH_LONG).show();
                    return;
                }
                if(response.body()!=null){
                    Log.i("Successful",""+response.body());
                    stud_adapter=new StudentListAdapter(getActivity().getApplicationContext(),response.body());
                    stud_recycle_view.setAdapter(stud_adapter);
                    Toast.makeText(getContext(),"Success",Toast.LENGTH_LONG).show();



                }
            }

            @Override
            public void onFailure(Call<List<StudentListModal>> call, Throwable t) {
                Log.i("On fail","no response");
                Toast.makeText(getContext(),"cant get api",Toast.LENGTH_LONG).show();
            }
        });


    }

}
