package jrgroup.braintest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class ReflexionGameActivity extends AppCompatActivity {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflexion_game);

        btPauseG1 = (ImageButton)findViewById(R.id.btPauseG1);
        btTrueG1 = (ImageButton)findViewById(R.id.btTrueG1);
        btWrongG1 = (ImageButton)findViewById(R.id.btWrongG1);
        txtHienThi = (TextView)findViewById(R.id.txtHienThiG1);
        rltG1 = (RelativeLayout)findViewById(R.id.rltLG1);
        rltG1.setBackgroundResource(R.drawable.background);
        txtTest = (TextView)findViewById(R.id.textView7);
        txtDiem = (TextView)findViewById(R.id.txtDiemG1);
        pgb = (ProgressBar) findViewById(R.id.progressBar);


        diem = 0;
        txtTest.setText(String.valueOf(HienThi()));
        thongbao3();
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

    @Override
    protected void onPause() {
        super.onPause();

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

    public void thongbao()
    {
        AlertDialog.Builder thongbao = new AlertDialog.Builder(this);
        thongbao.setTitle(R.string.thongbao1);
        thongbao.setMessage("Your score: " + diem);
        thongbao.setIcon(R.drawable.pauseicon);


        thongbao.setPositiveButton(R.string.thongbaotraloi1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent mhtraining = new Intent(ReflexionGameActivity.this, TrainingActivity.class);
                mhtraining.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(mhtraining);
                ReflexionGameActivity.this.finish();


            }
        });

        thongbao.setNegativeButton(R.string.thongbaotraloi2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent playagain = new Intent(ReflexionGameActivity.this, ReflexionGameActivity.class);
                playagain.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(playagain);
                ReflexionGameActivity.this.finish();


            }
        });

        thongbao.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {

                Intent playagain = new Intent(ReflexionGameActivity.this, ReflexionGameActivity.class);
                playagain.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(playagain);
                ReflexionGameActivity.this.finish();

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
                        thongbao();
                    }
                });
            }
        };
        myThread.start();
    }



}

