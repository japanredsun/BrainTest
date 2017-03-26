package jrgroup.braintest;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler();
    MediaPlayer song;
    LinearLayout lnl;
    int load=1;
    ImageButton btnTraining, btnRecord, btnExit, btnDaily, btnmusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lnl = (LinearLayout)findViewById(R.id.myscreen);
        lnl.setBackgroundResource(R.drawable.bannermenu);
        btnDaily = (ImageButton)findViewById(R.id.btDailyTest);
        btnDaily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhDailyTest = new Intent(MainActivity.this, DailyTestActivity.class);
                mhDailyTest.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(mhDailyTest);

            }
        });
        btnTraining = (ImageButton) findViewById(R.id.btTraining);
        btnTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhTraining = new Intent(MainActivity.this, TrainingActivity.class);
                mhTraining.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(mhTraining);

            }
        });
        btnRecord = (ImageButton)findViewById(R.id.btRecord);
        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhRecord = new Intent(MainActivity.this, RecordActivity.class);
                mhRecord.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(mhRecord);

            }
        });
        btnExit = (ImageButton)findViewById(R.id.btExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
        btnmusic = (ImageButton) findViewById(R.id.musicimg);
        startService(new Intent(MainActivity.this,BackgroundSoundService.class));
        btnmusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Service.START_STICKY==1) {
                        btnmusic.setImageResource(R.drawable.banmusic);
                        stopService(new Intent(MainActivity.this,BackgroundSoundService.class));
                    }
                    if(Service.START_STICKY==0)
                    {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btnmusic.setImageResource(R.drawable.musicnote);
                                startService(new Intent(MainActivity.this,BackgroundSoundService.class));
                            }
                        });
                    }


                }
            });

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}



