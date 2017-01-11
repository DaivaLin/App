package com.example.sinni.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;
import java.util.Locale;

public class Learn_word extends AppCompatActivity implements TextToSpeech.OnInitListener{

    String Situation,Word_or_Voc,Learn_or_Test;
    int[] imgIds;
    int p=0;
    ImageView back,last,next,showGIF,sound;
    MediaController mc;
    GifAnimationDrawable gif;
    private TextToSpeech tts;
    ListView mList;
    ListAdapter mAdapter;
    Learn_word.Struct[] mItems;
    VideoView videoView;
    TextView spel;
    String[] word = {"明","件","冰"};
    String[] part = {"日","月","人","牛","冫","水"};
    String[] spell = {"míng","jiàn","bīng"};
    String[] mean;
    int w = 0;
    int[] video = {R.raw.easyfoodvideo_sun,R.raw.easyfoodvideo_moon,R.raw.easyfoodvideo_people,R.raw.easyfoodvideo_cow,R.raw.easyfoodvideo_ice2,R.raw.easyfoodvideo_water};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_word);
        setTitle("Word");
        findView();
       // Toast.makeText(getApplicationContext(), "你選擇" +Word_or_Voc+Situation+Learn_or_Test, Toast.LENGTH_SHORT).show();
       imgIds = new int[]{R.raw.easy_food_gif1,R.raw.easy_food_gif2,R.raw.easy_food_gif3};
        tts = new TextToSpeech(this, this);

        mItems = buildData(2);


        mc = new MediaController(this);
        mList = (ListView) findViewById(R.id.listView);
        mAdapter = new ArrayAdapter<Struct>(this,android.R.layout.simple_list_item_2,android.R.id.text1,mItems) {
            @Override
            public View getView(int pos, View convert, ViewGroup group) {
                View v = super.getView(pos, convert, group);
                TextView t1 = (TextView) v.findViewById(android.R.id.text1);
                t1.setText(getItem(pos).iName);
                return v;
            }
        };
        videoView.setVisibility(View.INVISIBLE);
        setvalue(w);
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(w<=0){
                    Toast.makeText(Learn_word.this, "已是第一張" , Toast.LENGTH_SHORT).show();
                }else{
                    w = w -1;
                    setvalue(w);
                    videoView.setVisibility(View.INVISIBLE);
                    videoView.setMediaController(mc);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(w>=word.length-1){
                    Toast.makeText(Learn_word.this, "已是最後一張" , Toast.LENGTH_SHORT).show();
                }else{
                    w = w +1;
                    setvalue(w);
                    videoView.setVisibility(View.INVISIBLE);
                    videoView.setMediaController(mc);
                }
            }
        });
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.speak(word[w], TextToSpeech.QUEUE_FLUSH, null);     //發音
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Learn_word.this,Home_page .class);
                startActivity(intent);

            }
        });
        mList.setAdapter(mAdapter);
        mList.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), "你選擇" + part[position], Toast.LENGTH_SHORT).show();
               // videoView.notify();
                picture(R.raw.not_thing_video);
                spel.setText("");


                videoView.setMediaController(mc);
                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + video[position]));
                videoView.requestFocus();
                videoView.start();
            }
        });

    }
    public void setvalue(int i) {
        tts.speak(word[i], TextToSpeech.QUEUE_FLUSH, null);     //發音
        spel.setText(spell[i]);
       // mean.setText(mean[i]);
       picture(i);

    }
    public void findView() {
        showGIF = (android.widget.ImageView) findViewById(R.id.imageView);

        spel = (TextView) findViewById(R.id.spell);
        last = (ImageView) findViewById(R.id.last);
        next = (ImageView) findViewById(R.id.next);
        back = (ImageView) findViewById(R.id.back);
        sound = (ImageView) findViewById(R.id.sound);
        videoView = (VideoView) findViewById(R.id.videoView);
        Bundle bundle = this.getIntent().getExtras();
        Situation = bundle.getString("Situation");
        Word_or_Voc = bundle.getString("Word_or_Voc");
        Learn_or_Test = bundle.getString("Learn_or_Test");

    }
    class Struct {
        public String iName;

        Struct(String name) {
            iName = name;
        }

    }

    private Learn_word.Struct[] buildData(int length) {
        Learn_word.Struct[] array = new Learn_word.Struct[length];
        for (int i = 0; i < 6; i++) {
            array[i] = new Struct(part[i].toString() );
        }
        return array;
    }

    public void picture(int i) {

        showGIF.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // 點擊一下, 再開始播放一次
                // 以下寫法, 等同 gif2.setVisible(true, true);
                (showGIF.getDrawable()).setVisible(true, true);

            }
        });

        try
        {   // 取得 Gif 動畫檔
            gif = new GifAnimationDrawable( getResources().openRawResource(imgIds[i]) );

            // Gif Drawable 設定給 ImageView
            showGIF.setImageDrawable(gif);

            // 只播放一次
            gif.setOneShot(true);
        }
        catch( IOException ioe ){}

    }

    @Override
    public void onInit(int status) {
        // TODO Auto-generated method stub
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.TAIWAN);    //設定語言
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                tts.setPitch((float) 1);    //語調(1為正常語調；0.5比正常語調低一倍；2比正常語調高一倍)
                tts.setSpeechRate((float) 0.5);    //速度(1為正常速度；0.5比正常速度慢一倍；2比正常速度快一倍)
            }
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }



    @Override
    public void onDestroy() {
        // shutdown tts
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }
}



