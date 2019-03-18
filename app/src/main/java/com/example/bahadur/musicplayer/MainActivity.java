package com.example.bahadur.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    int currentposition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=(Button)findViewById(R.id.btnplay);
        stop=(Button)findViewById(R.id.btnstop);
        pause=(Button)findViewById(R.id.btnpause);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnplay:
                if(mediaPlayer==null){
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music);
                mediaPlayer.start();
                }
                else if(!mediaPlayer.isPlaying())
                {
                    mediaPlayer.seekTo(currentposition);
                    mediaPlayer.start();
                }
                break;
            case R.id.btnpause:
            {
                if(mediaPlayer!=null)
                    mediaPlayer.pause();
                currentposition=mediaPlayer.getCurrentPosition();
            }
                break;
            case R.id.btnstop:
                if(mediaPlayer!=null)
                {
                    mediaPlayer.stop();
                    mediaPlayer=null;
                }
                break;

        }

    }
}
