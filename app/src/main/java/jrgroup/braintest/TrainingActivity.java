package jrgroup.braintest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class TrainingActivity extends AppCompatActivity {
    RelativeLayout rlt;
    ImageButton ibtG1,ibtBack, ibtG4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        rlt = (RelativeLayout)findViewById(R.id.activity_training);
        rlt.setBackgroundResource(R.drawable.background);
        ibtG1 = (ImageButton)findViewById(R.id.btnG1);
        ibtG4 = (ImageButton)findViewById(R.id.btnG4);

        ibtG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhG1 = new Intent(TrainingActivity.this, ReflexionGameActivity.class);
                mhG1.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(mhG1);
            }
        });

        ibtG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhG4 = new Intent(TrainingActivity.this, QuickMathActivity.class);
                mhG4.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(mhG4);
            }
        });
        ibtBack = (ImageButton) findViewById(R.id.btnBackTraining);
        ibtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhmain = new Intent(TrainingActivity.this, MainActivity.class);
                mhmain.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(mhmain);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
