package jrgroup.braintest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class VisionActivity extends AppCompatActivity {
    ImageView img1,img2,img3,img4,img5;
    Button btn;
    AnimationSet rootset = new AnimationSet(true);
    Random rand = new Random();
    TextView txtv;
    int duration2,duration,duration3,duration4,duration5;
    TranslateAnimation transX1= new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-1200);
    TranslateAnimation transX2= new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-1200);
    TranslateAnimation transX3= new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-1200);
    TranslateAnimation transX4= new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-1200);
    TranslateAnimation transX5= new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-1200);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vision);
        img1 = (ImageView) findViewById(R.id.imgso1);
        img2 = (ImageView) findViewById(R.id.imgso2);
        img3 = (ImageView) findViewById(R.id.imgso3);
        img4 = (ImageView) findViewById(R.id.imgso4);
        img5 = (ImageView) findViewById(R.id.imgso5);
        btn = (Button) findViewById(R.id.button);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtv.setText(String.valueOf(hienthi()));
            }
        });

        txtv =(TextView) findViewById(R.id.textView2);




    }

    public void setanimation(TranslateAnimation name,int start,int duration,boolean fillafter)
    {
        //name = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-1000);
        name.setStartOffset(start);
        name.setDuration(duration);
        name.setFillAfter(fillafter);
        rootset.addAnimation(name);
    }
    public int hienthi()
    {
        duration =  500+rand.nextInt(10)*30;
        do{
            duration2 = 500+rand.nextInt(10)*30;
        }while(duration2==duration);
        do{
            duration3= 500+rand.nextInt(10)*30;
        }while((duration3==duration2)||(duration3==duration));
        do {
            duration4 = 500+rand.nextInt(10)*30;
        }while((duration4==duration2)||(duration4==duration)||(duration4==duration3));
        do {
            duration5 = 500+rand.nextInt(10)*30;
        }while((duration5==duration2)||(duration5==duration)||(duration5==duration3)||(duration5==duration4));


        setanimation(transX1,0,duration,true);
        setanimation(transX2,0,duration2,true);
        setanimation(transX3,0,duration3,true);
        setanimation(transX4,0,duration4,true);
        setanimation(transX5,0,duration5,true);

        img1.startAnimation(transX1);
        img2.startAnimation(transX2);
        img3.startAnimation(transX3);
        img4.startAnimation(transX4);
        img5.startAnimation(transX5);

        int vitri=1, max;
        max = duration;
        if(duration2<max) {max = duration2; vitri =2; }
        if(duration3<max) {max = duration3; vitri =3; }
        if(duration4<max) {max = duration4; vitri =4; }
        if(duration5<max) { vitri =5; }
        return vitri;
    }


}