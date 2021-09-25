package com.ways.apppengasap;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.annotation.NonNull;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button lele, patin, nila, batal;
        DatabaseReference dbref;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lele=(Button) findViewById(R.id.lele);
        patin=(Button) findViewById(R.id.patin);
        nila=(Button) findViewById(R.id.nila);
        batal=(Button) findViewById(R.id.tombolbatal);
        dbref = FirebaseDatabase.getInstance().getReference();
        dbref.child("DATA/ikan").setValue("0");
        lele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbref.child("DATA/ikan").setValue(1);
                dbref.child("DATA/jenisreporter").setValue(1);
                startActivity(new Intent(MainActivity.this,monitorasap.class));
                finish();
            }
        });

        patin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbref.child("DATA/ikan").setValue(2);
                dbref.child("DATA/jenisreporter").setValue(2);
                startActivity(new Intent(MainActivity.this,monitorasap.class));
                finish();
            }
        });

        nila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbref.child("DATA/ikan").setValue(3);
                dbref.child("DATA/jenisreporter").setValue(3);
                startActivity(new Intent(MainActivity.this,monitorasap.class));
                finish();
            }
        });

        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}