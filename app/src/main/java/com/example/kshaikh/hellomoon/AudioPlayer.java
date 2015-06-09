package com.example.kshaikh.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by kshaikh on 15-06-09.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;

    public void stop() {
        if(mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c, int resid) {
        stop();

        mPlayer = MediaPlayer.create(c, resid);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stop();
            }
        });
        mPlayer.start();
    }
}
