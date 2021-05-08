package com.example.secondhw.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.secondhw.R;

public class DetailsActivity extends AppCompatActivity {

    private TextView txtDesc,txtDirector,txtProducer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        txtDesc=findViewById(R.id.txtDesc);
        txtDirector=findViewById(R.id.directorName);
        txtProducer=findViewById(R.id.producerName);
        Bundle extras=getIntent().getExtras();
        txtDesc.setText(extras.getString("Description"));
        txtDirector.setText(extras.getString("Director"));
        txtProducer.setText(extras.getString("Producer"));
    }
}