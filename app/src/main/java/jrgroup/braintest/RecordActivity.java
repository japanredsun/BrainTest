package jrgroup.braintest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class RecordActivity extends AppCompatActivity {

    TextView txtHSR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        Intent myCallerIntentRef = getIntent();
        Bundle bundleR = myCallerIntentRef.getExtras();
        String name = bundleR.getString("name");
        Integer diem = bundleR.getInt("score");
        Integer game = bundleR.getInt("game");
        switch (game)
        {
            case 1:
            {
                Intent mhB = new Intent(RecordActivity.this, ReflexionGameActivity.class);
                Bundle bundleB = new Bundle();
                bundleB.putString("name",name);
                bundleB.putInt("score", diem);
                mhB.putExtras(bundleB);
                startActivityForResult(mhB, 1);
                mhB.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mhB);
                break;
            }
            case 2:
            {
                Intent mhB = new Intent(RecordActivity.this, MemoryGameActivity.class);
                Bundle bundleB = new Bundle();
                bundleB.putString("name",name);
                bundleB.putInt("score", diem);
                mhB.putExtras(bundleB);
                startActivityForResult(mhB, 2);
                mhB.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mhB);
                break;
            }
            case 3:
            {
                Intent mhB = new Intent(RecordActivity.this, VisionActivity.class);
                Bundle bundleB = new Bundle();
                bundleB.putString("name",name);
                bundleB.putInt("score", diem);
                mhB.putExtras(bundleB);
                startActivityForResult(mhB, 3);
                mhB.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mhB);
                break;
            }
            case 4:
            {
                Intent mhB = new Intent(RecordActivity.this, QuickMathActivity.class);
                Bundle bundleB = new Bundle();
                bundleB.putString("name",name);
                bundleB.putInt("score", diem);
                mhB.putExtras(bundleB);
                startActivityForResult(mhB, 4);
                mhB.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mhB);
                break;
            }
        }

    }
}
