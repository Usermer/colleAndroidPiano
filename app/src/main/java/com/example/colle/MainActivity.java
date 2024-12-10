package com.example.colle;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButton(R.id.btnC, R.raw.note_c);
        setupButton(R.id.btnC1, R.raw.note_c);
        setupButton(R.id.btnD, R.raw.note_d);
        setupButton(R.id.btnD1, R.raw.note_d);
        setupButton(R.id.btnE, R.raw.note_e);
        setupButton(R.id.btnE1, R.raw.note_e);
        setupButton(R.id.btnF, R.raw.note_f);
        setupButton(R.id.btnF1, R.raw.note_f);
        setupButton(R.id.btnG, R.raw.note_g);
        setupButton(R.id.btnG1, R.raw.note_g);
        setupButton(R.id.btnA, R.raw.note_a);
        setupButton(R.id.btnA1, R.raw.note_a);
        setupButton(R.id.btnB, R.raw.note_b);
        setupButton(R.id.btnB1, R.raw.note_b);
    }

    private void setupButton(int buttonId, int soundId) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> playSound(soundId));
    }

    private void playSound(int soundId) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, soundId);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}