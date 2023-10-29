package com.example.reproducaovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class TelaVideo extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_video);

        videoView = findViewById(R.id.videoView);

        //Escondendo a barra
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(decorView.SYSTEM_UI_FLAG_FULLSCREEN);

        //Configurar os controles do video

        videoView.setMediaController(new MediaController(this));

        //Passando o video para o método
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);

        //Inicia o video
        videoView.start();

    }
}