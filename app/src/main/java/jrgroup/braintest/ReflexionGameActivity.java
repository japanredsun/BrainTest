package jrgroup.braintest;

import android.app.Activity;
import android.content.Intent;
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
    TextView txtHienThi, txtTest, txtDiem;
    RelativeLayout rltG1;
    int diem;
    Random rand = new Random();
    Thread myThread = null;
    int breakwhile = 0;
    MediaPlayer song;
    int top9 = 0,top10 = 0,num = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflexion_game);
        song=MediaPlayer.create(getApplicationContext(),R.raw.trueorfalse);
        song.setLooping(true);
        btPauseG1 = (ImageButton)findViewById(R.id.btPauseG1);
        btTrueG1 = (ImageButton)findViewById(R.id.btTrueG1);
        btWrongG1 = (ImageButton)findViewById(R.id.btWrongG1);
        txtHienThi = (TextView)findViewById(R.id.txtHienThiG1);
        rltG1 = (RelativeLayout)findViewById(R.id.rltLG1);
        rltG1.setBackgroundResource(R.drawable.background);
        txtTest = (TextView)findViewById(R.id.textView7);
        txtDiem = (TextView)findViewById(R.id.txtDiemG1);
        pgb = (ProgressBar) findViewById(R.id.progressBarG3);

        ReadSave();
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
        double sodiem = Double.parseDouble(txtDiem.getText().toString());
        Intent myintent = new Intent(ReflexionGameActivity.this, RecordActivity.class);
        Bundle bd = new Bundle();
        bd.putDouble("Sodiem", sodiem);
        myintent.putExtras(bd);
        //startActivityForResult(myintent, 1312);
    }

    protected void ReadSave()
    {
        SharedPreferences myPrefs = getSharedPreferences("top910",
                Activity. MODE_PRIVATE);
        int myTop9 = myPrefs.getInt("top9",0);
        int myTop10 = myPrefs.getInt("top10",0);
        top9 = myTop9;
        top10 = myTop10;
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
                runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                        if(diem > top10)
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
        SharedPreferences myPrefs = getSharedPreferences("top910",
                Activity. MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefs.edit();
        if(num < 10)
            num++;
        else
        {
            if (diem > top10) {
                if (diem > top9)
                {
                    top10 = top9;
                    top9 = diem;
                }
                else
                {
                    top10 = diem;
                }
            }
        }
        editor.putInt("top9", top9);
        editor.putInt("top10",top10);
        editor.commit();
        song.pause();
    }

}

