package com.example.sinni.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Structure_home_page extends AppCompatActivity {
    ImageView Single_structure,Fully_enclosed_structure,LR_structures,UL_structures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure_home_page);
        findView();
    }
    public void findView() {
        Single_structure = (ImageView) findViewById(R.id.Single_structure);
        Fully_enclosed_structure = (ImageView) findViewById(R.id.Fully_enclosed_structure);
        LR_structures = (ImageView) findViewById(R.id.LR_structures);
        UL_structures = (ImageView) findViewById(R.id.UL_structures);
    }
}
