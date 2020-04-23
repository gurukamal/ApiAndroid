package com.example.viewassignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.AdapterViewHolder> {

    int id;
    private Context context;
    List<StudentListModal> stud_list ;
    public StudentListAdapter(Context context,List<StudentListModal> stud_list){
        this.context=context;
        this.stud_list=stud_list;

    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.recycle_user_list_view,parent,false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterViewHolder holder, final int position) {
        holder.txt_user_name.setText(stud_list.get(position).getUsername());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String detail_user_name=stud_list.get(position).getUsername();
                String detail_email=stud_list.get(position).getEmail();
                final Fragment obj=new StudentDetailsFragment();

                Bundle bundle=new Bundle();
                bundle.putString("username",detail_user_name);
                bundle.putString("email",detail_email);
                obj.setArguments(bundle);

                MainActivity  mainActivity=(MainActivity)context;
                FragmentManager fragmentManager=mainActivity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.user_details_frag,obj).commit();
                //context.startActivity(details_intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return stud_list.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        TextView txt_user_name;
        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txt_user_name= itemView.findViewById(R.id.user_username);

        }
    }
}
