package jrgroup.braintest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class HSReflexionActivity extends AppCompatActivity {

    TextView txtname1, txtscore1, txtstt1,
            txtname2, txtscore2, txtstt2,
            txtname3, txtscore3, txtstt3,
            txtname4, txtscore4, txtstt4,
            txtname5, txtscore5, txtstt5,
            txtname6, txtscore6, txtstt6,
            txtname7, txtscore7, txtstt7,
            txtname8, txtscore8, txtstt8,
            txtname9, txtscore9, txtstt9,
            txtname10, txtscore10, txtstt10;
    Button btnBTT, btnPA;
    ArrayList<HighScore> Top10 = new ArrayList<HighScore>();
    HighScore top1;
    HighScore top2;
    HighScore top3;
    HighScore top4;
    HighScore top5;
    HighScore top6;
    HighScore top7;
    HighScore top8;
    HighScore top9;
    HighScore top10;
    Integer num = 0,diemtop10 = 0,Num = 0;
    static Integer kt = 0;

    //ReflexionDAO refDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hsreflexion);

        txtstt1 = (TextView) findViewById(R.id.txtstt1);
        txtname1 = (TextView) findViewById(R.id.txtname1);
        txtscore1 = (TextView) findViewById(R.id.txtscore1);

        txtstt2 = (TextView) findViewById(R.id.txtstt2);
        txtname2 = (TextView) findViewById(R.id.txtname2);
        txtscore2 = (TextView) findViewById(R.id.txtscore2);

        txtstt3 = (TextView) findViewById(R.id.txtstt3);
        txtname3 = (TextView) findViewById(R.id.txtname3);
        txtscore3 = (TextView) findViewById(R.id.txtscore3);

        txtstt4 = (TextView) findViewById(R.id.txtstt4);
        txtname4 = (TextView) findViewById(R.id.txtname4);
        txtscore4 = (TextView) findViewById(R.id.txtscore4);

        txtstt5 = (TextView) findViewById(R.id.txtstt5);
        txtname5 = (TextView) findViewById(R.id.txtname5);
        txtscore5 = (TextView) findViewById(R.id.txtscore5);

        txtstt6 = (TextView) findViewById(R.id.txtstt6);
        txtname6 = (TextView) findViewById(R.id.txtname6);
        txtscore6 = (TextView) findViewById(R.id.txtscore6);

        txtstt7 = (TextView) findViewById(R.id.txtstt7);
        txtname7 = (TextView) findViewById(R.id.txtname7);
        txtscore7 = (TextView) findViewById(R.id.txtscore7);

        txtstt8 = (TextView) findViewById(R.id.txtstt8);
        txtname8 = (TextView) findViewById(R.id.txtname8);
        txtscore8 = (TextView) findViewById(R.id.txtscore8);

        txtstt9 = (TextView) findViewById(R.id.txtstt9);
        txtname9 = (TextView) findViewById(R.id.txtname9);
        txtscore9 = (TextView) findViewById(R.id.txtscore9);

        txtstt10 = (TextView) findViewById(R.id.txtstt10);
        txtname10 = (TextView) findViewById(R.id.txtname10);
        txtscore10 = (TextView) findViewById(R.id.txtscore10);

        btnBTT = (Button) findViewById(R.id.btnBTT);
        btnPA = (Button) findViewById(R.id.btnPA);

        //refDAO = new ReflexionDAO(this);
        //ReadSave();

        /*if(kt == 0) {
            top1 = new HighScore(1, "top1", 1);
            top2 = new HighScore(2, "top2", 1);
            top3 = new HighScore(3, "top3", 1);
            top4 = new HighScore(4, "top4", 1);
            top5 = new HighScore(5, "top5", 1);
            top6 = new HighScore(6, "top6", 1);
            top7 = new HighScore(7, "top7", 1);
            top8 = new HighScore(8, "top8", 1);
            top9 = new HighScore(9, "top9", 1);
            top10 = new HighScore(10, "top10", 1);
            Top10.add(top1);
            Top10.add(top2);
            Top10.add(top3);
            Top10.add(top4);
            Top10.add(top5);
            Top10.add(top6);
            Top10.add(top7);
            Top10.add(top8);
            Top10.add(top9);
            Top10.add(top10);
            kt = 1;
        }
        Intent myCallerIntentRef = getIntent();
        Bundle bundleR = myCallerIntentRef.getExtras();
        String name = bundleR.getString("name");
        Integer score = bundleR.getInt("score");


        for(HighScore top : Top10)
        {
            if(top.Score <= score)
            {
                num = top.Num;
                break;
            }
        }


        //tu tu tinh
        if(num != 0 )
        {
            HighScore tmp = new HighScore(num,name,score);
            Top10.add(num-1,tmp);
            for(HighScore top : Top10)
            {
                Num++;
                top.Num = Num;
            }
            Top10.remove(10);
        }

        diemtop10 = Top10.get(9).Score;

        txtstt1.setText(Top10.get(0).Num.toString());
        txtname1.setText(Top10.get(0).Name);
        txtscore1.setText(Top10.get(0).Score.toString());

        txtstt2.setText(Top10.get(1).Num.toString());
        txtname2.setText(Top10.get(1).Name);
        txtscore2.setText(Top10.get(1).Score.toString());

        txtstt3.setText(Top10.get(2).Num.toString());
        txtname3.setText(Top10.get(2).Name);
        txtscore3.setText(Top10.get(2).Score.toString());

        txtstt4.setText(Top10.get(3).Num.toString());
        txtname4.setText(Top10.get(3).Name);
        txtscore4.setText(Top10.get(3).Score.toString());

        txtstt5.setText(Top10.get(4).Num.toString());
        txtname5.setText(Top10.get(4).Name);
        txtscore5.setText(Top10.get(4).Score.toString());

        txtstt6.setText(Top10.get(5).Num.toString());
        txtname6.setText(Top10.get(5).Name);
        txtscore6.setText(Top10.get(5).Score.toString());

        txtstt7.setText(Top10.get(6).Num.toString());
        txtname7.setText(Top10.get(6).Name);
        txtscore7.setText(Top10.get(6).Score.toString());

        txtstt8.setText(Top10.get(7).Num.toString());
        txtname8.setText(Top10.get(7).Name);
        txtscore8.setText(Top10.get(7).Score.toString());

        txtstt9.setText(Top10.get(8).Num.toString());
        txtname9.setText(Top10.get(8).Name);
        txtscore9.setText(Top10.get(8).Score.toString());

        txtstt10.setText(Top10.get(9).Num.toString());
        txtname10.setText(Top10.get(9).Name);
        txtscore10.setText(Top10.get(9).Score.toString());

        /*Intent myintent = new Intent(HSReflexionActivity.this, ReflexionGameActivity.class);
        Bundle bdr = new Bundle();
        bdr.putInt("diemtop10", 1);
        myintent.putExtras(bdr);
        startActivityForResult(myintent,123);*
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
        });*/

        //Reflextion ref = new Reflextion(name, score);
        //refDAO.Them(ref);

    }

    /*protected void ReadSave()
    {
        SharedPreferences myPrefs = getSharedPreferences("KiemTra",
                Activity. MODE_PRIVATE);
        int mykt = myPrefs.getInt("KT",0);
        kt = mykt;
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences myPrefs = getSharedPreferences("KiemTra",
                Activity. MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefs.edit();

        editor.putInt("KT",kt);
        editor.apply();
    }*/
}
