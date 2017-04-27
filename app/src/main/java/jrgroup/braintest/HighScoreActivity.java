package jrgroup.braintest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class HighScoreActivity extends AppCompatActivity {

    ImageButton btRef, btMem, btVis, btQM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        btRef = (ImageButton) findViewById(R.id.btnhsRef);
        btMem = (ImageButton) findViewById(R.id.btnhsMem);
        btVis = (ImageButton) findViewById(R.id.btnhsVis);
        btQM = (ImageButton) findViewById(R.id.btnhsQMath);

        btRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhHSRef = new Intent(HighScoreActivity.this,HSReflexionActivity.class);
                startActivity(mhHSRef);
            }
        });
        btMem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhHSMem = new Intent(HighScoreActivity.this, HSMemoryActivity.class);
                startActivity(mhHSMem);
            }
        });
        btVis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhHSVis = new Intent(HighScoreActivity.this, HSVisionActivity.class);
                startActivity(mhHSVis);
            }
        });
        btQM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhMHQM = new Intent(HighScoreActivity.this, HSQuickMathActivity.class);
                startActivity(mhMHQM);
            }
        });
    }
}
