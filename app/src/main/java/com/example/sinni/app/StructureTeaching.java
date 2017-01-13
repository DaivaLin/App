package com.example.sinni.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StructureTeaching extends AppCompatActivity {
    //結構式選擇畫面
    ImageView leftAndRightCombination
            ,upperAndLowerCombinations
            ,underTheThreePacks
            ,onTheThreeBags
            ,leftLowerPack
            ,topLeftPackage
            ,rightUpperPackage
            ,leftThreePacks
            ,allSurrounded
            ,onTheLowerStructure
            ,leftRightStructure
            ,onTheNextTwoStructures
            ,onTheNextOneStructures
            ,leftAndRightTwoStructures
            ,leftTwoStructures;
    Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure_teaching);
        //第一級
        //a=(ImageView)findViewById(R.id.a);
//第二級
        leftAndRightCombination=(ImageView)findViewById(R.id.leftandrightcombination);
        upperAndLowerCombinations=(ImageView)findViewById(R.id.upperandlowercombinations);
//第三級
        allSurrounded=(ImageView)findViewById(R.id.allsurrounded);
        underTheThreePacks=(ImageView)findViewById(R.id.underthethreepacks);
        onTheThreeBags=(ImageView)findViewById(R.id.onthethreebags);
        leftLowerPack=(ImageView)findViewById(R.id.leftlowerpack);
        topLeftPackage=(ImageView)findViewById(R.id.topleftpackage);
        rightUpperPackage=(ImageView)findViewById(R.id.rightupperpackage);
        leftThreePacks=(ImageView)findViewById(R.id.leftthreepacks);
//第四級
        onTheLowerStructure=(ImageView)findViewById(R.id.onthelowerstructure);
        onTheNextTwoStructures=(ImageView)findViewById(R.id.onthenexttwostructures);
        onTheNextOneStructures=(ImageView)findViewById(R.id.onthenextonestructures);
        leftAndRightTwoStructures=(ImageView)findViewById(R.id.leftandrighttwostructures);
        leftTwoStructures=(ImageView)findViewById(R.id.lefttwostructures);
        leftRightStructure=(ImageView)findViewById(R.id.leftrightstructure);
//上下組合
        upperAndLowerCombinations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 it=new Intent();
                it.setClass(StructureTeaching.this,UpperAndLowerCombinations.class);
               startActivity(it);
                finish();
            }
        });
//左右組合
        leftAndRightCombination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent it=new Intent();it.setClass(StructureTeaching.this,LeftAndRightCombination.class);
                //startActivity(it);
            }
        });

//左三包
        leftThreePacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
               // it.setClass(StructureTeaching.this,LeftThreePacks.class);
                startActivity(it);
            }
        });
//下三包
        underTheThreePacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
               // it.setClass(StructureTeaching.this,UnderTheThreePacks.class);
                startActivity(it);
            }
        });
//上三包
        onTheThreeBags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
              //  it.setClass(StructureTeaching.this,OnTheThreeBags.class);
                startActivity(it);
            }
        });
//向右上包字判斷
        leftLowerPack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
              //  it.setClass(StructureTeaching.this,LeftLowerPack.class);
                startActivity(it);
            }
        });
//向右下包字判斷
        topLeftPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
              //  it.setClass(StructureTeaching.this,TopLeftPackage.class);
                startActivity(it);
            }
        });
//向左下包字判斷
        rightUpperPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
              //  it.setClass(StructureTeaching.this,RightUpperPackage.class);
                startActivity(it);
            }
        });
//全包圍
        allSurrounded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
             //   it.setClass(StructureTeaching.this,AllSurrounded.class);
                startActivity(it);
            }
        });
//上中下結構
        onTheLowerStructure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
              //  it.setClass(StructureTeaching.this,OnTheLowerStructure.class);
                startActivity(it);
            }
        });
//左中右結構
        leftRightStructure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
              //  it.setClass(StructureTeaching.this,LeftRightStructure.class);
                startActivity(it);
            }
        });
//上一下二結構
        onTheNextTwoStructures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
               // it.setClass(StructureTeaching.this,OnTheNextTwoStructures.class);
                startActivity(it);
            }
        });
//上二下一結構
        onTheNextOneStructures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
              //  it.setClass(StructureTeaching.this,OnTheNextOneStructures.class);
                startActivity(it);
            }
        });
//左一右二結構
        leftAndRightTwoStructures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
              //  it.setClass(StructureTeaching.this,LeftAndRightTwoStructures.class);
                startActivity(it);
            }
        });
//左二右一結構
        leftTwoStructures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
             //   it.setClass(StructureTeaching.this,LeftTwoStructures.class);
                startActivity(it);
            }
        });}
}
