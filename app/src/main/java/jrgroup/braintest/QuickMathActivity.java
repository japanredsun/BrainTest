package jrgroup.braintest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class QuickMathActivity extends AppGeneral {

    int ProcessStatus = 0;
    Random rand = new Random();
    Handler handler = new Handler();
    Thread myThread = null;
    int breakwhile = 0;
    int diem;
    int Vitri;
    ProgressBar pgb;
    TextView txt, txtDiemG4;
    Button g4btup, g4btright, g4btleft, g4btdown;
    MediaPlayer song,sound1;
    int top9 = 0,top10 = 0,num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_math);
        song=MediaPlayer.create(getApplicationContext(),R.raw.trueorfalse);
        song.setLooping(true);
        g4btup = (Button)findViewById(R.id.G4btUp);
        g4btright = (Button)findViewById(R.id.G4btRight);
        g4btleft = (Button)findViewById(R.id.G4btLeft);
        g4btdown = (Button)findViewById(R.id.G4btDown);
        txt = (TextView)findViewById(R.id.textView);
        txtDiemG4 = (TextView)findViewById(R.id.txtDiemG4);
        pgb = (ProgressBar)findViewById(R.id.progressBarG4);

        ReadSave();
        diem = 0;
        thongbao3(R.string.begining2);
        Vitri= Hienthi();
        g4btup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Vitri == 1) {
                    diem++;
                    Timer();
                    txtDiemG4.setText(String.valueOf(diem));
                    Vitri = Hienthi();
                }
                else {
                    breakwhile=1;}
            }
        });
        g4btright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Vitri == 2) {
                    diem++;
                    Timer();
                    txtDiemG4.setText(String.valueOf(diem));
                    Vitri = Hienthi();
                }
                else {
                    breakwhile=1;}
            }
        });
        g4btleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Vitri == 3) {
                    diem++;
                    Timer();
                    txtDiemG4.setText(String.valueOf(diem));
                    Vitri = Hienthi();
                }
                else {
                    breakwhile=1;}
            }
        });
        g4btdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Vitri == 4){
                    diem++;
                    Timer();
                    txtDiemG4.setText(String.valueOf(diem));
                    Vitri = Hienthi();
                }
                else {
                    breakwhile=1;}
            }
        });

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

    public int Hienthi()
    {
        String hienthi = "";
        int s1, s2, dau;
        int kqUp, kqRight, kqLeft, kqDown;
        String[] pheptinh = {"+", "-"};

        s1 = rand.nextInt(30);
        s2 = rand.nextInt(15);
        dau = rand.nextInt(2);
        kqUp = SinhPhepTinh(s1,s2,dau);
        hienthi = String.valueOf(s1) + " " + pheptinh[dau].toString() + " " + String.valueOf(s2);
        g4btup.setText(hienthi);

        do {
            s1 = rand.nextInt(30);
            s2 = rand.nextInt(15);
            dau = rand.nextInt(2);
            kqRight = SinhPhepTinh(s1,s2,dau);
        }while (kqRight == kqUp);
        hienthi = String.valueOf(s1) + " " + pheptinh[dau].toString() + " " + String.valueOf(s2);
        g4btright.setText(hienthi);

        do {
            s1 = rand.nextInt(30);
            s2 = rand.nextInt(15);
            dau = rand.nextInt(2);
            kqLeft = SinhPhepTinh(s1,s2,dau);
        }while ((kqLeft == kqUp)||(kqLeft == kqRight));
        hienthi = String.valueOf(s1) + " " + pheptinh[dau].toString() + " " + String.valueOf(s2);
        g4btleft.setText(hienthi);

        do {
            s1 = rand.nextInt(30);
            s2 = rand.nextInt(15);
            dau = rand.nextInt(2);
            kqDown = SinhPhepTinh(s1,s2,dau);
        }while ((kqDown == kqUp)||(kqDown == kqRight)||(kqDown == kqLeft));
        hienthi = String.valueOf(s1) + " " + pheptinh[dau].toString() + " " + String.valueOf(s2);
        g4btdown.setText(hienthi);

        int ln = 0;
        int vitri=0;
        if(kqUp>ln) {ln = kqUp; vitri = 1;}
        if(kqRight>ln) {ln = kqRight; vitri = 2;}
        if(kqLeft>ln) {ln = kqLeft; vitri = 3;}
        if(kqDown>ln) {ln = kqRight; vitri = 4;}

        return vitri;
    }

    public int SinhPhepTinh(int s1, int s2,int dau)
    {
        String[] pheptinh = {"+", "-"};
        int kq;
        if (dau == 0)
            kq = s1 + s2;
        else
            kq = s1 - s2;
        return kq;
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
                            thongbaothang(QuickMathActivity.this,diem,4);
                        }
                        else
                        {
                            thongbao(QuickMathActivity.class,diem);
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

    @Override
    protected void onResume() {
        super.onResume();
        song.start();
    }
}
