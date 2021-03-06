package jrgroup.braintest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class ReflexionGameActivity extends AppGeneral {
    ProgressBar pgb;
    int ProcessStatus = 0;
    Handler handler = new Handler();

    ImageButton btPauseG1, btTrueG1, btWrongG1;
    TextView txtHienThi, txtTest, txtDiem, txtHS;
    RelativeLayout rltG1;
    
    int diem;
    Random rand = new Random();
    Thread myThread = null;
    int breakwhile = 0;
    int top1 = 0, kt = 0;
    MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflexion_game);

        song = MediaPlayer.create(getApplicationContext(),R.raw.trueorfalse);
        song.setLooping(true);
        btPauseG1 = (ImageButton)findViewById(R.id.btPauseG1);
        btTrueG1 = (ImageButton)findViewById(R.id.btTrueG1);
        btWrongG1 = (ImageButton)findViewById(R.id.btWrongG1);
        rltG1 = (RelativeLayout)findViewById(R.id.rltLG1);
        rltG1.setBackgroundResource(R.drawable.background);
        txtTest = (TextView)findViewById(R.id.textView7);
        txtHS = (TextView)findViewById(R.id.textView15);
        txtHienThi = (TextView)findViewById(R.id.txtHienThiG1);
        txtDiem = (TextView)findViewById(R.id.txtDiemG1);
        pgb = (ProgressBar) findViewById(R.id.progressBarG3);


        ReadSave();
        txtHS.setText(String.valueOf(top1));
        diem = 0;
        txtTest.setText(String.valueOf(HienThi()));
        thongbao3(R.string.begining1);
        btTrueG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtTest.getText() == "true") {
                    diem++;
                    txtDiem.setText(String.valueOf(diem));
                    Timer();
                    txtTest.setText(String.valueOf(HienThi()));
                }
                else {
                        breakwhile=1;
                }
            }
        });
        btWrongG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtTest.getText() == "false") {
                    diem++;
                    txtDiem.setText(String.valueOf(diem));
                    Timer();
                    txtTest.setText(String.valueOf(HienThi()));
                }
                else {
                    breakwhile=1;
                }
            }
        });
        btPauseG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPause();
            }
        });

    }

    protected void ReadSave()
    {
        SharedPreferences myPrefs = getSharedPreferences("top_reflex",
                Activity. MODE_PRIVATE);
        int stop1 = myPrefs.getInt("top1",0);
        top1 = stop1;
    }

    public boolean HienThi()
    {
        String[] pheptinh = {"+", "-", "x", ":"};
        int s1, s2, dau, kq, kqhienthi;
        dau = rand.nextInt(4);
        if ((dau == 0) || (dau == 1))
        {
            s1 = rand.nextInt(50);
            s2 = rand.nextInt(50);
            if (dau == 0)
                kq = s1 + s2;
            else
                kq = s1 - s2;
        }
        else
        {
            int tams1 = rand.nextInt(10)+1;
            int tams2 = rand.nextInt(10)+1;
            if (dau == 2)
            {
                s1 = tams1;
                s2 = tams2;
                kq = s1 * s2;
            }
            else
            {
                int tamkq = tams1 * tams2;
                kq = tams1;
                s1 = tamkq;
                s2 = tams2;
            }
        }
        int xacsuat = rand.nextInt(2);
        if (xacsuat % 2 == 0) {
            kqhienthi = kq;
        }
        else {
            kqhienthi = rand.nextInt(9)+kq-1;
        }
        String hienthi = "";
        hienthi = String.valueOf(s1) + " " + pheptinh[dau].toString() + " " + String.valueOf(s2) + " = " + String.valueOf(kqhienthi);
        txtHienThi.setText(hienthi);
        return kq == kqhienthi;
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
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {

                        if(diem > top1)
                        {
                            thongbaothang(ReflexionGameActivity.this,diem,1);
                        }
                        else
                        {
                            thongbao(ReflexionGameActivity.class,diem);
                        }
                    }
                });

            }
        };
        myThread.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        song.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(diem > top1)
        {
            SharedPreferences myPrefs = getSharedPreferences("top_reflex",
                Activity. MODE_PRIVATE);
            SharedPreferences.Editor editor = myPrefs.edit();
            editor.putInt("top1",diem);
            editor.commit();
        }

        song.pause();
    }

}

