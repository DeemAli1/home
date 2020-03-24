package com.example.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class retrieve extends AppCompatActivity {
    EditText phone ;
    Button btn;
    DatabaseReference reff ;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);
        phone =(EditText) findViewById(R.id.phone);
        btn=(Button) findViewById(R.id.button);

     btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
          GetPhone();
         }
     });
    }
public void GetPhone (){
   String ph = phone.getText().toString().trim();
    reff = FirebaseDatabase.getInstance().getReference().child("Customer");
    Query query = reff.orderByChild("phone").equalTo(ph);

    query.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists()){
            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                Intent i = new Intent(retrieve.this , RDU.class);
                startActivity(i);
                finish();
            } }

           else
            {Toast.makeText(retrieve.this,"Phone number are not Exist..:(" ,Toast.LENGTH_LONG).show(); }




    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});
}






}
