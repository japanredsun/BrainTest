package jrgroup.braintest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class RecordActivity extends AppCompatActivity {

    TextView txtHSR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        txtHSR = (TextView)findViewById(R.id.txtHSR);

    }
}
