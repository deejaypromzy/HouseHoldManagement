package com.projectwork.householdmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeVideo extends YouTubeBaseActivity {
    private YouTubePlayer mPlayer;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_video);

        final String key = getIntent().getStringExtra("key");



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        youTubePlayerView.initialize("", onInitializedListener);

            }
        });

        youTubePlayerView =  findViewById(R.id.youtube_view);



        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                mPlayer = player;
                mPlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                mPlayer.setFullscreen(true);
                switch (key){
                    case "Feed Babies":
                        mPlayer.loadVideo("z3jE7ZoTp-I");
                        mPlayer.play();
                        break;
                    case "Bath Babies":
                        mPlayer.loadVideo("-RnxD-KRkw8");
                        mPlayer.play();
                        break;
                    case "Change Babies Diaper":
                        mPlayer.loadVideo("hJVSzPQix-E");
                        mPlayer.play();
                        break;
                    case "Make Baby Sleep":
                        mPlayer.loadVideo("Wm15rvkifPc");
                        mPlayer.play();
                        break;
                    case "Waakye":
                        mPlayer.loadVideo("qoPjrPz3ceA");
                        mPlayer.play();
                        break;
                    case "Apapransa":
                        mPlayer.loadVideo("8FZcec4cFiE");
                        mPlayer.play();
                        break;
                    case "Eto":
                        mPlayer.loadVideo("CfvByIsnJgc");
                        mPlayer.play();
                        break;
                    case "Kelewele":
                        mPlayer.loadVideo("onkoseNQXuA");
                        mPlayer.play();
                        break;
                }

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {

         String Error =error.toString();
            Toast.makeText(getApplicationContext(),Error,Toast.LENGTH_LONG).show();
            }
        };
    }
}
