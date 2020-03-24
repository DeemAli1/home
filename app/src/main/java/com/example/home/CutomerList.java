package com.example.home;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CutomerList extends RecyclerView.Adapter<CutomerList.MyViewHolder> {
    public Context context;
    public ArrayList<Customer> customerList ;


    public CutomerList (Context c , ArrayList customerList){
        this.context = c ;
        this.customerList = customerList ;

    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        Customer customerList = this.customerList.get(position);
        holder.txtname.setText(customerList.getName());
       holder.txtPhone.setText(customerList.getPhone());
        holder.txtCatog.setText(customerList.getCatogres());
        holder.txtTruck.setText(customerList.getTrack());
        holder.txtTime.setText(customerList.getTime());
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtname , txtPhone , txtTruck , txtTime , txtCatog ;

        public MyViewHolder (@NonNull View itemView) {
            super(itemView);
         txtname = (TextView) itemView.findViewById(R.id.iname);
             txtPhone = (TextView) itemView.findViewById(R.id.iPhone);
             txtTruck = (TextView) itemView.findViewById(R.id.iTrack);
             txtTime = (TextView) itemView.findViewById(R.id.itime);
             txtCatog = (TextView) itemView.findViewById(R.id.iCatogres );
        }
    }
}




