package jrgroup.braintest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class QuickMathActivity extends AppCompatActivity {

    int ProcessStatus = 0;
    ProgressBar pgbG4;
    Random rand = new Random();
    Handler handler = new Handler();
    Thread myThread = null;
    int breakwhile = 0;
    int diem;
    int Vitri;
    ProgressBar pgb;
    TextView txt, txtDiemG4;
    Button g4btup, g4btright, g4btleft, g4btdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_math);
        g4btup = (Button)findViewById(R.id.G4btUp);
        g4btright = (Button)findViewById(R.id.G4btRight);
        g4btleft = (Button)findViewById(R.id.G4btLeft);
        g4btdown = (Button)findViewById(R.id.G4btDown);
        txt = (TextView)findViewById(R.id.textView);
        txtDiemG4 = (TextView)findViewById(R.id.txtDiemG4);
        pgbG4 = (ProgressBar)findViewById(R.id.progressBarG4);

        diem = 0;
        thongbao3();
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

    public void Timer()
    {
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
                            pgbG4.setMax(1000);
                            pgbG4.setRotation(180);
                            pgbG4.setProgress(ProcessStatus);
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
                        thongbao();
                    }
                });
            }
        };
        myThread.start();
    }
    public void thongbao()
    {
        AlertDialog.Builder thongbao = new AlertDialog.Builder(this);
        thongbao.setTitle(R.string.thongbao1);
        thongbao.setMessage("Your score: " + diem);
        thongbao.setIcon(R.drawable.pauseicon);


        thongbao.setPositiveButton(R.string.thongbaotraloi1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent mhtraining = new Intent(QuickMathActivity.this, TrainingActivity.class);
                mhtraining.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(mhtraining);
                QuickMathActivity.this.finish();


            }
        });

        thongbao.setNegativeButton(R.string.thongbaotraloi2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent playagain = new Intent(QuickMathActivity.this, QuickMathActivity.class);
                playagain.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(playagain);
                QuickMathActivity.this.finish();


            }
        });

        thongbao.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {

                Intent playagain = new Intent(QuickMathActivity.this, QuickMathActivity.class);
                playagain.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(playagain);
                QuickMathActivity.this.finish();

            }
        });

        AlertDialog alertDialog = thongbao.create();
        // tạo dialog
        alertDialog.show();
    }
    public void thongbao3()
    {
        AlertDialog.Builder thongbao = new AlertDialog.Builder(this);

        thongbao.setMessage(R.string.begining1);

        thongbao.setPositiveButton(R.string.begin_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Timer();
            }
        });
        thongbao.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Timer();
            }
        });

        AlertDialog alertDialog = thongbao.create();
        // tạo dialog
        alertDialog.show();


    }
}
