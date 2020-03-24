package com.example.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RDU extends AppCompatActivity {
    public RecyclerView recyclerView;
    public ArrayList<Customer> customerList ;
 public CutomerList customerAdapter;

    DatabaseReference reff ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_d_u);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customerList = new ArrayList<Customer>();

       reff = FirebaseDatabase.getInstance().getReference().child("Customer");
       // Query query = reff.orderByChild("phone").equalTo(ph);
       reff.addListenerForSingleValueEvent(valueEventListener);
        }

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                     Customer customer = snapshot.getValue(Customer.class);
                     customerList.add(customer);
                    } }

                   customerAdapter = new CutomerList(RDU.this,customerList);
                 recyclerView.setAdapter(customerAdapter);

                }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

     }


