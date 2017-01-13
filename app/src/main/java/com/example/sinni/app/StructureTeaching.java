package com.example.sinni.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

public class StructureTeaching extends AppCompatActivity {
    //結構式選擇畫面
    ImageView leftAndRightCombination
            ,upperAndLowerCombinations;
    Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure_teaching);
        //浮動button
        floatingButton();
        //第一級
        //a=(ImageView)findViewById(R.id.a);
//第二級
        leftAndRightCombination=(ImageView)findViewById(R.id.leftandrightcombination);
        upperAndLowerCombinations=(ImageView)findViewById(R.id.upperandlowercombinations);
////第三級
//        allSurrounded=(ImageView)findViewById(R.id.allsurrounded);
//        underTheThreePacks=(ImageView)findViewById(R.id.underthethreepacks);
//        onTheThreeBags=(ImageView)findViewById(R.id.onthethreebags);
//        leftLowerPack=(ImageView)findViewById(R.id.leftlowerpack);
//        topLeftPackage=(ImageView)findViewById(R.id.topleftpackage);
//        rightUpperPackage=(ImageView)findViewById(R.id.rightupperpackage);
//        leftThreePacks=(ImageView)findViewById(R.id.leftthreepacks);
////第四級
//        onTheLowerStructure=(ImageView)findViewById(R.id.onthelowerstructure);
//        onTheNextTwoStructures=(ImageView)findViewById(R.id.onthenexttwostructures);
//        onTheNextOneStructures=(ImageView)findViewById(R.id.onthenextonestructures);
//        leftAndRightTwoStructures=(ImageView)findViewById(R.id.leftandrighttwostructures);
//        leftTwoStructures=(ImageView)findViewById(R.id.lefttwostructures);
//        leftRightStructure=(ImageView)findViewById(R.id.leftrightstructure);
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

////左三包
//        leftThreePacks.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 it=new Intent();
//               // it.setClass(StructureTeaching.this,LeftThreePacks.class);
//                startActivity(it);
//            }
//        });
////下三包
//        underTheThreePacks.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 it=new Intent();
//               // it.setClass(StructureTeaching.this,UnderTheThreePacks.class);
//                startActivity(it);
//            }
//        });
////上三包
//        onTheThreeBags.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 it=new Intent();
//              //  it.setClass(StructureTeaching.this,OnTheThreeBags.class);
//                startActivity(it);
//            }
//        });
////向右上包字判斷
//        leftLowerPack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 it=new Intent();
//              //  it.setClass(StructureTeaching.this,LeftLowerPack.class);
//                startActivity(it);
//            }
//        });
////向右下包字判斷
//        topLeftPackage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 it=new Intent();
//              //  it.setClass(StructureTeaching.this,TopLeftPackage.class);
//                startActivity(it);
//            }
//        });
////向左下包字判斷
//        rightUpperPackage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 it=new Intent();
//              //  it.setClass(StructureTeaching.this,RightUpperPackage.class);
//                startActivity(it);
//            }
//        });
////全包圍
//        allSurrounded.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 it=new Intent();
//             //   it.setClass(StructureTeaching.this,AllSurrounded.class);
//                startActivity(it);
//            }
//        });
////上中下結構
//        onTheLowerStructure.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 it=new Intent();
//              //  it.setClass(StructureTeaching.this,OnTheLowerStructure.class);
//                startActivity(it);
//            }
//        });
////左中右結構
//        leftRightStructure.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 it=new Intent();
//              //  it.setClass(StructureTeaching.this,LeftRightStructure.class);
//                startActivity(it);
//            }
//        });
////上一下二結構
//        onTheNextTwoStructures.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 it=new Intent();
//               // it.setClass(StructureTeaching.this,OnTheNextTwoStructures.class);
//                startActivity(it);
//            }
//        });
////上二下一結構
//        onTheNextOneStructures.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 it=new Intent();
//              //  it.setClass(StructureTeaching.this,OnTheNextOneStructures.class);
//                startActivity(it);
//            }
//        });
////左一右二結構
//        leftAndRightTwoStructures.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 it=new Intent();
//              //  it.setClass(StructureTeaching.this,LeftAndRightTwoStructures.class);
//                startActivity(it);
//            }
//        });
////左二右一結構
//        leftTwoStructures.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 it=new Intent();
//             //   it.setClass(StructureTeaching.this,LeftTwoStructures.class);
//                startActivity(it);
//            }
//        });

    }

    //浮動button-function
    public void floatingButton(){
        FloatingActionButton second = new FloatingActionButton(getBaseContext());
        FloatingActionButton third = new FloatingActionButton(getBaseContext());
        //    FloatingActionButton fourth = new FloatingActionButton(getBaseContext());

        //浮動button-第二級
        second.setTitle("第二級");
        second.setColorNormalResId(R.color.other_button_color);
        second.setColorDisabled(R.color.white_pressed);
        second.setColorPressedResId(R.color.black_20);
        second.setIcon(R.drawable.number_two);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"結構",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StructureTeaching.this, Structures_level2.class);
                startActivity(intent);
            }
        });

        //浮動button-第三級
        third.setTitle("第三級");
        third.setColorNormalResId(R.color.other_button_color);
        third.setColorDisabled(R.color.white_pressed);
        third.setColorPressedResId(R.color.black_20);
        third.setIcon(R.drawable.number_three);
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"結構",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StructureTeaching.this, Structures_level3.class);
                startActivity(intent);
            }
        });

        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        menuMultipleActions.addButton(second);
        menuMultipleActions.addButton(third);

        //浮動button-第四級
//        fourth.setTitle("");
//        fourth.setColorNormalResId(R.color.other_button_color);
//        fourth.setColorDisabled(R.color.white_pressed);
//        fourth.setColorPressedResId(R.color.black_20);
//        fourth.setIcon(R.drawable.number_three);
//        fourth.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Toast.makeText(getApplicationContext(),"結構",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Structures_level2.this, Structure_home_page.class);
//                startActivity(intent);
//            }
//        });
//        menuMultipleActions.addButton(fourth);

    }

}
