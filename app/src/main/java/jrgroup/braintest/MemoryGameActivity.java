package jrgroup.braintest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MemoryGameActivity extends AppGeneral {

    ArrayList<Integer> g2de = new ArrayList<Integer>();
    ArrayList<Integer> g2doan = new ArrayList<Integer>();
    ArrayList<Integer> mangHinhLon = new ArrayList<Integer>();
    ImageView imv1,imv2,imv3,imv4,imv5,imv6;
    ImageButton ibt1,ibt2,ibt3,ibt4,ibt5,ibt6,ibtok,ibtdel;
    TextView txtHs,txtS,txtHsDiem;
    ProgressBar pgb;
    Random rand = new Random();
    Handler handler = new Handler();
    Thread myThread = null;
    int breakwhile = 0;
    int ProcessStatus = 0;
    int diem = 0;
    int g2rand;
    int vitri = 0;
    MediaPlayer song;
    int top1 = 0, kt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);
        song = MediaPlayer.create(getApplicationContext(),R.raw.music5);
        song.setLooping(true);
        song.start();
        imv1 = (ImageView) findViewById(R.id.G2Imv1);
        imv2 = (ImageView) findViewById(R.id.G2Imv2);
        imv3 = (ImageView) findViewById(R.id.G2Imv3);
        imv4 = (ImageView) findViewById(R.id.G2Imv4);
        imv5 = (ImageView) findViewById(R.id.G2Imv5);
        imv6 = (ImageView) findViewById(R.id.G2Imv6);

        ibt1 = (ImageButton) findViewById(R.id.G2ImBt1);
        ibt2 = (ImageButton) findViewById(R.id.G2ImBt2);
        ibt3 = (ImageButton) findViewById(R.id.G2ImBt3);
        ibt4 = (ImageButton) findViewById(R.id.G2ImBt4);
        ibt5 = (ImageButton) findViewById(R.id.G2ImBt5);
        ibt6 = (ImageButton) findViewById(R.id.G2ImBt6);
        ibtok = (ImageButton) findViewById(R.id.G2ImBtOK);
        ibtdel = (ImageButton) findViewById(R.id.G2ImBtDel);

        txtS = (TextView) findViewById(R.id.G2txtS);
        txtHsDiem = (TextView) findViewById(R.id.G2txtHSDiem);

        pgb = (ProgressBar) findViewById(R.id.progressBar);

        ReadSave();

        txtHsDiem.setText(String.valueOf(top1));

        thongbao3(R.string.begining4);

        mangHinhLon.add(R.drawable.dice1);
        mangHinhLon.add(R.drawable.dice2);
        mangHinhLon.add(R.drawable.dice3);
        mangHinhLon.add(R.drawable.dice4);
        mangHinhLon.add(R.drawable.dice5);
        mangHinhLon.add(R.drawable.dice6);
        HienThi();

        ibt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kt == 1)
                {
                    if (vitri == 0)
                    {
                        imv1.setImageResource(R.drawable.dice1);
                    }
                    if (vitri == 1)
                    {
                        imv2.setImageResource(R.drawable.dice1);
                    }
                    if (vitri == 2)
                    {
                        imv3.setImageResource(R.drawable.dice1);
                    }
                    if (vitri == 3)
                    {
                        imv4.setImageResource(R.drawable.dice1);
                    }
                    if (vitri == 4)
                    {
                        imv5.setImageResource(R.drawable.dice1);
                    }
                    if (vitri == 5)
                    {
                        imv6.setImageResource(R.drawable.dice1);
                    }
                    g2doan.add(0);
                    vitri++;
                }

            }
        });

        ibt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kt == 1)
                {
                    if (vitri == 0)
                    {
                        imv1.setImageResource(R.drawable.dice2);
                    }
                    if (vitri == 1)
                    {
                        imv2.setImageResource(R.drawable.dice2);
                    }
                    if (vitri == 2)
                    {
                        imv3.setImageResource(R.drawable.dice2);
                    }
                    if (vitri == 3)
                    {
                        imv4.setImageResource(R.drawable.dice2);
                    }
                    if (vitri == 4)
                    {
                        imv5.setImageResource(R.drawable.dice2);
                    }
                    if (vitri == 5)
                    {
                        imv6.setImageResource(R.drawable.dice2);
                    }
                    vitri++;
                    g2doan.add(1);
                }

            }
        });

        ibt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kt == 1)
                {
                    if (vitri == 0)
                    {
                        imv1.setImageResource(R.drawable.dice3);
                    }
                    if (vitri == 1)
                    {
                        imv2.setImageResource(R.drawable.dice3);
                    }
                    if (vitri == 2)
                    {
                        imv3.setImageResource(R.drawable.dice3);
                    }
                    if (vitri == 3)
                    {
                        imv4.setImageResource(R.drawable.dice3);
                    }
                    if (vitri == 4)
                    {
                        imv5.setImageResource(R.drawable.dice3);
                    }
                    if (vitri == 5)
                    {
                        imv6.setImageResource(R.drawable.dice3);
                    }
                    g2doan.add(2);
                    vitri++;
                }

            }
        });

        ibt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kt == 1)
                {
                    if (vitri == 0)
                    {
                        imv1.setImageResource(R.drawable.dice4);
                    }
                    if (vitri == 1)
                    {
                        imv2.setImageResource(R.drawable.dice4);
                    }
                    if (vitri == 2)
                    {
                        imv3.setImageResource(R.drawable.dice4);

                    }
                    if (vitri == 3)
                    {
                        imv4.setImageResource(R.drawable.dice4);
                    }
                    if (vitri == 4)
                    {
                        imv5.setImageResource(R.drawable.dice4);
                    }
                    if (vitri == 5)
                    {
                        imv6.setImageResource(R.drawable.dice4);
                    }
                    g2doan.add(3);
                    vitri++;
                }

            }
        });

        ibt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kt == 1)
                {
                    if (vitri == 0)
                    {
                        imv1.setImageResource(R.drawable.dice5);
                    }
                    if (vitri == 1)
                    {
                        imv2.setImageResource(R.drawable.dice5);
                    }
                    if (vitri == 2)
                    {
                        imv3.setImageResource(R.drawable.dice5);
                    }
                    if (vitri == 3)
                    {
                        imv4.setImageResource(R.drawable.dice5);
                    }
                    if (vitri == 4)
                    {
                        imv5.setImageResource(R.drawable.dice5);
                    }
                    if (vitri == 5)
                    {
                        imv6.setImageResource(R.drawable.dice5);
                    }
                    g2doan.add(4);
                    vitri++;
                }

            }
        });

        ibt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kt == 1)
                {
                    if (vitri == 0)
                    {
                        imv1.setImageResource(R.drawable.dice6);

                    }
                    if (vitri == 1)
                    {
                        imv2.setImageResource(R.drawable.dice6);

                    }
                    if (vitri == 2)
                    {
                        imv3.setImageResource(R.drawable.dice6);

                    }
                    if (vitri == 3)
                    {
                        imv4.setImageResource(R.drawable.dice6);

                    }
                    if (vitri == 4)
                    {
                        imv5.setImageResource(R.drawable.dice6);

                    }
                    if (vitri == 5)
                    {
                        imv6.setImageResource(R.drawable.dice6);

                    }
                    g2doan.add(5);
                    vitri++;
                }

            }
        });

        ibtok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vitri == 6) {
                    if (g2de.equals(g2doan)) {
                        diem++;
                        txtS.setText(String.valueOf(diem));
                        Timer();
                        g2doan.clear();
                        g2de.clear();
                        HienThi();
                        vitri = 0;
                    } else{
                        if(diem > top1)
                        {
                            thongbaothang(MemoryGameActivity.this,diem,2);
                        }
                        else
                        {
                            thongbao(MemoryGameActivity.class,diem);
                        }
                    }
                }
                else{
                    Toast.makeText(MemoryGameActivity.this, "Ban da bam "+ vitri+" ki tu.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ibtdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vitri == 1)
                {
                    imv1.setImageResource(R.drawable.dice0);
                    g2doan.remove(0);
                    vitri--;
                }
                else
                if(vitri == 2)
                {
                    imv2.setImageResource(R.drawable.dice0);
                    g2doan.remove(1);
                    vitri--;
                }
                else
                if(vitri == 3)
                {
                    imv3.setImageResource(R.drawable.dice0);
                    g2doan.remove(2);
                    vitri--;
                }
                else
                if(vitri == 4)
                {
                    imv4.setImageResource(R.drawable.dice0);
                    g2doan.remove(3);
                    vitri--;
                }
                else
                if(vitri == 5)
                {
                    imv5.setImageResource(R.drawable.dice0);
                    g2doan.remove(4);
                    vitri--;
                }
                else
                if(vitri == 6)
                {
                    imv6.setImageResource(R.drawable.dice0);
                    g2doan.remove(5);
                    vitri--;
                }
                else
                {
                    g2doan.remove(vitri-1);
                    vitri--;
                }
            }
        });
    }
    public void HienThi()
    {
        int position0 = rand.nextInt(mangHinhLon.size());
        imv1.setImageResource(mangHinhLon.get(position0));
        int position1 = rand.nextInt(mangHinhLon.size());
        imv2.setImageResource(mangHinhLon.get(position1));
        int position2 = rand.nextInt(mangHinhLon.size());
        imv3.setImageResource(mangHinhLon.get(position2));
        int position3 = rand.nextInt(mangHinhLon.size());
        imv4.setImageResource(mangHinhLon.get(position3));
        int position4 = rand.nextInt(mangHinhLon.size());
        imv5.setImageResource(mangHinhLon.get(position4));
        int position5 = rand.nextInt(mangHinhLon.size());
        imv6.setImageResource(mangHinhLon.get(position5));

        g2de.add(position0);
        g2de.add(position1);
        g2de.add(position2);
        g2de.add(position3);
        g2de.add(position4);
        g2de.add(position5);

    }

    @Override
    public void Timer() {
        ProcessStatus = 0;

        myThread = new Thread() {
            @Override
            public void run() {
                while(ProcessStatus<999)
                {
                    if(breakwhile==1) {
                        break;
                    }
                    ProcessStatus +=1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pgb.setMax(1000);
                            pgb.setRotation(180);
                            pgb.setProgress(ProcessStatus);
                        }

                    });
                    try{
                        Thread.sleep(1);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        setimgto0();
                        kt = 1;
                    }
                });

            }
        };
        myThread.start();
    }
    public void setimgto0()
    {
        imv1.setImageResource(R.drawable.dice0);
        imv2.setImageResource(R.drawable.dice0);
        imv3.setImageResource(R.drawable.dice0);
        imv4.setImageResource(R.drawable.dice0);
        imv5.setImageResource(R.drawable.dice0);
        imv6.setImageResource(R.drawable.dice0);
    }
    @Override
    protected void onPause() {
        super.onPause();
        if(diem > top1)
        {
            SharedPreferences myPrefs = getSharedPreferences("top_memory",
                    Activity. MODE_PRIVATE);
            SharedPreferences.Editor editor = myPrefs.edit();
            editor.putInt("top1",diem);
            editor.commit();
        }
        song.pause();
    }

    protected void ReadSave()
    {
        SharedPreferences myPrefs = getSharedPreferences("top_memory",
                Activity. MODE_PRIVATE);
        int stop1 = myPrefs.getInt("top1",0);
        top1 = stop1;
    }

    @Override
    protected void onResume() {
        super.onResume();
        song.start();
    }
}
