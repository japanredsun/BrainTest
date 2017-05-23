package jrgroup.braintest;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by JR on 4/8/2017.
 */

public class AppGeneral extends AppCompatActivity {
    ProgressBar pgb;
    int ProcessStatus = 0;
    Handler handler = new Handler();
    Thread myThread = null;
    int breakwhile = 0;

    public  void thongbaothang(final Context context, final int diem, final int game)
    {
        final Dialog addDialog = new Dialog(context);
        addDialog.setTitle("Congratulation!!");
        addDialog.setContentView(R.layout.layout_highscore);
        TextView txtYourScoreView = (TextView)addDialog.findViewById(R.id.txtYourScore);
        final EditText edtYourName = (EditText)addDialog.findViewById(R.id.edtYourName);
        Button btnOk = (Button)addDialog.findViewById(R.id.btSave);

        String diemV = "Your score: " + diem;
        txtYourScoreView.setText(diemV);
        addDialog.show();
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (game)
                {
                    case 1:
                    {
                        Intent mhR = new Intent(context, TrainingActivity.class);
                        Bundle bundleR = new Bundle();
                        bundleR.putString("name", edtYourName.getText().toString());
                        bundleR.putInt("score", diem);
                        mhR.putExtras(bundleR);
                        startActivityForResult(mhR, 1);
                        mhR.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(mhR);
                        break;
                    }
                    case 2:
                    {
                        Intent mhM = new Intent(context, TrainingActivity.class);
                        Bundle bundleM = new Bundle();
                        bundleM.putString("name", edtYourName.getText().toString());
                        bundleM.putInt("score", diem);
                        mhM.putExtras(bundleM);
                        startActivityForResult(mhM, 2);
                        mhM.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(mhM);
                        break;
                    }
                    case 3:
                    {
                        Intent mhV = new Intent(context, TrainingActivity.class);
                        Bundle bundleV = new Bundle();
                        bundleV.putString("name", edtYourName.getText().toString());
                        bundleV.putInt("score", diem);
                        mhV.putExtras(bundleV);
                        startActivityForResult(mhV, 3);
                        mhV.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(mhV);
                        break;
                    }
                    case 4:
                    {
                        Intent mhQM = new Intent(context, TrainingActivity.class);
                        Bundle bundleQM = new Bundle();
                        bundleQM.putString("name", edtYourName.getText().toString());
                        bundleQM.putInt("score", diem);
                        mhQM.putExtras(bundleQM);
                        startActivityForResult(mhQM, 4);
                        mhQM.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(mhQM);
                        break;
                    }
                }
            }
        });

    }
    public void thongbao(final Class defclass, int diem)
    {
        AlertDialog.Builder thongbao = new AlertDialog.Builder(this);
        thongbao.setTitle(R.string.thongbao1);
        thongbao.setMessage("Your score: " + diem);
        thongbao.setIcon(R.drawable.pauseicon);


        thongbao.setPositiveButton(R.string.thongbaotraloi1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent mhtraining = new Intent(getApplicationContext(),TrainingActivity.class);
                mhtraining.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(mhtraining);
                finish();



            }
        });

        thongbao.setNegativeButton(R.string.thongbaotraloi2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent playagain = new Intent(getApplicationContext(), defclass);
                playagain.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(playagain);
                finish();


            }
        });

        thongbao.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {

                Intent playagain = new Intent(getApplicationContext(), defclass);
                playagain.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(playagain);
                finish();

            }
        });

        AlertDialog alertDialog = thongbao.create();

        // tạo dialog
        alertDialog.show();
    }

    public void thongbao3(int txt)
    {
        AlertDialog.Builder thongbao = new AlertDialog.Builder(this);

        thongbao.setMessage(txt);

        thongbao.setPositiveButton(R.string.begin_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Timer();
                TimerAfter();
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
                TimerAfter();
            }
        };
        myThread.start();
    }

    public void TimerAfter()
    {
        //to do
    }



}
