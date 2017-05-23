package jrgroup.braintest;

import android.support.v7.app.AppCompatActivity;

public class HSMemoryActivity extends AppCompatActivity {

    /*TextView txtname, txtscore;
    Button btnBTT, btnPA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hsmemory);

        txtname = (TextView) findViewById(R.id.txtname1);
        txtscore = (TextView) findViewById(R.id.txtscore1);
        btnBTT = (Button) findViewById(R.id.btnBTT);
        btnPA = (Button) findViewById(R.id.btnPA);

        Intent myCallerIntentRef = getIntent();
        Bundle bundleB = myCallerIntentRef.getExtras();
        String name = bundleB.getString("name");
        Integer diem = bundleB.getInt("score");

        txtname.setText(name);
        txtscore.setText(diem.toString());

        btnPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhG2 = new Intent(HSMemoryActivity.this, MemoryGameActivity.class);
                mhG2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                HSMemoryActivity.this.finish();
                startActivity(mhG2);
            }
        });

        btnBTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhG2 = new Intent(HSMemoryActivity.this, MainActivity.class);
                mhG2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                HSMemoryActivity.this.finish();
                startActivity(mhG2);
            }
        });
    }*/
}
