package com.ways.apppengasap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class monitorasap extends AppCompatActivity {
    Button setop;
    TextView temp, jenis, status;
    String valueTemp,statuspengasapan,convjenis,jenisikan;
    DatabaseReference dref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitorasap);
        setop = (Button) findViewById(R.id.tombolstop);
        temp = (TextView) findViewById(R.id.temp);
        jenis = (TextView) findViewById(R.id.jenisikan);
        status = (TextView) findViewById(R.id.statuspengasapan);
        dref = FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                jenisikan= dataSnapshot.child("DATA/jenisreporter").getValue().toString();
                int iwak = Integer.parseInt(jenisikan);
                if (iwak==1){
                    convjenis="Lele";
                }
                else if (iwak==2){
                    convjenis="Patin";
                }
                else if (iwak==3){
                    convjenis="Nila";
                }
                else{
                    convjenis="Unknown";
                }
                jenis.setText(convjenis);
                valueTemp = dataSnapshot.child("DATA/temp").getValue().toString();
                temp.setText(valueTemp);
                statuspengasapan = dataSnapshot.child("DATA/status").getValue().toString();
                status.setText(statuspengasapan);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        setop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dref.child("DATA/ikan").setValue(0);
                dref.child("DATA/stop").setValue(1);
                dref.child("DATA/status").setValue("Dibatalkan!");
                startActivity(new Intent(monitorasap.this,MainActivity.class));
                finish();
            }
        });


    }
}