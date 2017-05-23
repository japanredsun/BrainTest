package jrgroup.braintest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class VisionActivity extends AppGeneral {
    ImageView img1,img2,img3,img4,img5;
    ImageButton btR, G3btMB1, G3btMB2, G3btMB3, G3btMB4, G3btMB5;
    AnimationSet rootset = new AnimationSet(true);
    Random rand = new Random();
    TextView txtv,txtdiem,txtHS;
    ProgressBar pgb;
    int duration2,duration,duration3,duration4,duration5;
    Thread myThread = null;
    int breakwhile = 0;
    int ProcessStatus = 0;
    int diem;
    Handler handler = new Handler();
    MediaPlayer song,sound1;
    int top1 = 0, kt = 0;

    TranslateAnimation transX1= new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-1200);
    TranslateAnimation transX2= new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-1200);
    TranslateAnimation transX3= new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-1200);
    TranslateAnimation transX4= new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-1200);
    TranslateAnimation transX5= new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-1200);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vision);
        song=MediaPlayer.create(getApplicationContext(),R.raw.speedoflink);
        song.setLooping(true);
        song.start();

        img1 = (ImageView) findViewById(R.id.imgso1);
        img2 = (ImageView) findViewById(R.id.imgso2);
        img3 = (ImageView) findViewById(R.id.imgso3);
        img4 = (ImageView) findViewById(R.id.imgso4);
        img5 = (ImageView) findViewById(R.id.imgso5);
        btR = (ImageButton) findViewById(R.id.button);
        G3btMB1 = (ImageButton) findViewById(R.id.G3imgMB1);
        G3btMB2 = (ImageButton) findViewById(R.id.G3imgMB2);
        G3btMB3 = (ImageButton) findViewById(R.id.G3imgMB3);
        G3btMB4 = (ImageButton) findViewById(R.id.G3imgMB4);
        G3btMB5 = (ImageButton) findViewById(R.id.G3imgMB5);
        pgb = (ProgressBar) findViewById(R.id.progressBarG3);
        txtv =(TextView) findViewById(R.id.textView2);
        txtHS =(TextView) findViewById(R.id.textView5);
        txtdiem =(TextView) findViewById(R.id.textView3);

        ReadSave();
        txtHS.setText(String.valueOf(top1));
        diem = 0;
        thongbao3(R.string.begining3);
        txtdiem.setText(String.valueOf(diem));
        btR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtv.setText(String.valueOf(hienthi()));
            }
        });
        G3btMB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtv.getText().toString() == "1")
                {
                    txtv.setText(String.valueOf(hienthi()));
                    diem++;
                    txtdiem.setText(String.valueOf(diem));
                }
                else
                    breakwhile = 1;
            }
        });
        G3btMB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtv.getText().toString() == "2")
                {
                    txtv.setText(String.valueOf(hienthi()));
                    diem++;
                    txtdiem.setText(String.valueOf(diem));
                }
                else
                    breakwhile = 1;
            }
        });
        G3btMB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (txtv.getText().toString() == "3")
                {
                    txtv.setText(String.valueOf(hienthi()));
                     diem++;
                    txtdiem.setText(String.valueOf(diem));
                }
                else
                    breakwhile = 1;
            }
        });
        G3btMB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtv.getText().toString() == "4")
                {
                    txtv.setText(String.valueOf(hienthi()));
                    diem++;
                    txtdiem.setText(String.valueOf(diem));
                }
                else
                    breakwhile = 1;
            }
        });
        G3btMB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtv.getText().toString() == "5")
                {
                    txtv.setText(String.valueOf(hienthi()));
                    diem++;txtdiem.setText(String.valueOf(diem));
                }
                else
                    breakwhile = 1;
            }
        });

    }

    public void setanimation(TranslateAnimation name,int start,int duration,boolean fillafter)
    {
        name.setStartOffset(start);
        name.setDuration(duration);
        name.setFillAfter(fillafter);
        rootset.addAnimation(name);
    }
    protected void ReadSave()
    {
        SharedPreferences myPrefs = getSharedPreferences("top910",
                Activity. MODE_PRIVATE);
        int stop1 = myPrefs.getInt("top1",0);
        top1 = stop1;
    }

    public int hienthi()
    {
        duration =  400+rand.nextInt(10)*60;
        do{
            duration2 = 400+rand.nextInt(10)*60;
        }while(duration2==duration);
        do{
            duration3= 400+rand.nextInt(10)*60;
        }while((duration3==duration2)||(duration3==duration));
        do {
            duration4 = 400+rand.nextInt(10)*60;
        }while((duration4==duration2)||(duration4==duration)||(duration4==duration3));
        do {
            duration5 = 400+rand.nextInt(10)*60;
        }while((duration5==duration2)||(duration5==duration)||(duration5==duration3)||(duration5==duration4));


        setanimation(transX1,0,duration,true);
        setanimation(transX2,0,duration2,true);
        setanimation(transX3,0,duration3,true);
        setanimation(transX4,0,duration4,true);
        setanimation(transX5,0,duration5,true);

        img1.startAnimation(transX1);
        img2.startAnimation(transX2);
        img3.startAnimation(transX3);
        img4.startAnimation(transX4);
        img5.startAnimation(transX5);

        int vitri=1, max;
        max = duration;
        if(duration2<max) {max = duration2; vitri =2; }
        if(duration3<max) {max = duration3; vitri =3; }
        if(duration4<max) {max = duration4; vitri =4; }
        if(duration5<max) { vitri =5; }
        return vitri;
    }

    @Override
    public void TimerAfter() {
        txtv.setText(String.valueOf(hienthi()));
    }

    @Override
    public void Timer() {
        ProcessStatus = 0;

        myThread = new Thread() {
            @Override
            public void run() {
                while(ProcessStatus<999)
                {
                    if(breakwhile==1) {
                        break;
                    }
                    ProcessStatus +=1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pgb.setMax(1000);
                            pgb.setRotation(180);
                            pgb.setProgress(ProcessStatus);
                        }

                    });
                    try{
                        Thread.sleep(50);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(diem > top1)
                        {
                            thongbaothang(VisionActivity.this,diem,3);
                        }
                        else
                        {
                            thongbao(VisionActivity.class,diem);
                        }
                    }
                });
            }
        };
        myThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(diem > top1)
        {
            SharedPreferences myPrefs = getSharedPreferences("top910",
                    Activity. MODE_PRIVATE);
            SharedPreferences.Editor editor = myPrefs.edit();
            editor.putInt("top1",diem);
            editor.commit();
        }
        song.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        song.start();
    }
}