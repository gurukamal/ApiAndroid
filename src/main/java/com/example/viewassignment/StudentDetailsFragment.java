package com.example.viewassignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.nio.channels.Channel;

public class StudentDetailsFragment extends Fragment {
    TextView detail_username,detail_email;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.student_details,container,false);

        detail_username=view.findViewById(R.id.tv_details_user_name);
        detail_email=view.findViewById(R.id.tv_detail_email);
        //detail_id=view.findViewById(R.id.tv_detail_id);
        String Email=getArguments().getString("email");
         detail_email.setText(Email);
        String UserName=getArguments().getString("username");
       detail_email.setText(UserName);
        return view;
    }
}

