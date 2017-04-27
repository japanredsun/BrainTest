package jrgroup.braintest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import jrgroup.braintest.DAO.ReflexionDAO;

public class HSReflexionActivity extends AppCompatActivity {

    TextView txtname, txtscore;
    Button btnBTT, btnPA;

    ReflexionDAO refDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hsreflexion);

        txtname = (TextView) findViewById(R.id.txtname);
        txtscore = (TextView) findViewById(R.id.txtscore);
        btnBTT = (Button) findViewById(R.id.btnBTT);
        btnPA = (Button) findViewById(R.id.btnPA);

        refDAO = new ReflexionDAO(this);

        Intent myCallerIntentRef = getIntent();
        Bundle bundleR = myCallerIntentRef.getExtras();
        String name = bundleR.getString("name");
        Integer score = bundleR.getInt("score");

        txtname.setText(name);
        txtscore.setText(score.toString());

        btnPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhG2 = new Intent(HSReflexionActivity.this, ReflexionGameActivity.class);
                mhG2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                HSReflexionActivity.this.finish();
                startActivity(mhG2);
            }
        });

        btnBTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhG2 = new Intent(HSReflexionActivity.this, MainActivity.class);
                mhG2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                HSReflexionActivity.this.finish();
                startActivity(mhG2);
            }
        });

        //Reflextion ref = new Reflextion(name, score);
        //refDAO.Them(ref);

    }


}
