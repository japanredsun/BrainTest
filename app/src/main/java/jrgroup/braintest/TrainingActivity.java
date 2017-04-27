package jrgroup.braintest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class TrainingActivity extends AppCompatActivity {
    RelativeLayout rlt;
    ImageButton ibtG1,ibtBack, ibtG4, ibtG3,ibtG2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        rlt = (RelativeLayout)findViewById(R.id.activity_training);
        rlt.setBackgroundResource(R.drawable.background);
        ibtG1 = (ImageButton)findViewById(R.id.btnG1);
        ibtG4 = (ImageButton)findViewById(R.id.btnG4);
        ibtG3 = (ImageButton)findViewById(R.id.btnG3);
        ibtG2 = (ImageButton) findViewById(R.id.btnG2) ;

        ibtG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhG1 = new Intent(TrainingActivity.this, ReflexionGameActivity.class);
                mhG1.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                TrainingActivity.this.finish();
                startActivity(mhG1);
                stopService(new Intent(TrainingActivity.this,BackgroundSoundService.class));
            }
        });

        ibtG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhG4 = new Intent(TrainingActivity.this, QuickMathActivity.class);
                mhG4.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                TrainingActivity.this.finish();
                startActivity(mhG4);
                stopService(new Intent(TrainingActivity.this,BackgroundSoundService.class));
            }
        });
        ibtBack = (ImageButton) findViewById(R.id.btnBackTraining);
        ibtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhmain = new Intent(TrainingActivity.this, MainActivity.class);
                mhmain.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                TrainingActivity.this.finish();
                startActivity(mhmain);
                stopService(new Intent(TrainingActivity.this,BackgroundSoundService.class));
            }
        });
        ibtG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhG3 = new Intent(TrainingActivity.this, VisionActivity.class);
                mhG3.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                TrainingActivity.this.finish();
                startActivity(mhG3);
                stopService(new Intent(TrainingActivity.this,BackgroundSoundService.class));
            }
        });

        ibtG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhG2 = new Intent(TrainingActivity.this, MemoryGameActivity.class);
                mhG2.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                TrainingActivity.this.finish();
                startActivity(mhG2);
                stopService(new Intent(TrainingActivity.this,BackgroundSoundService.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
