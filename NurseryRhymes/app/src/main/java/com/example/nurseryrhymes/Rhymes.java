package com.example.nurseryrhymes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Rhymes extends AppCompatActivity {

    private VideoView profile;
    private TextView name, details, details2;
    private AudioManager audioManager;
    private SeekBar volumeSeekBar;
    private Button pauseButton, resumeButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rhymes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        profile = findViewById(R.id.profile);
        name = findViewById(R.id.name);
//        details = findViewById(R.id.details);
        details2 = findViewById(R.id.details2);
        volumeSeekBar = findViewById(R.id.volumeSeekBar);
        pauseButton = findViewById(R.id.pauseButton);
        resumeButton = findViewById(R.id.resumeButton);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        setupVolumeControl();

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String title = bundle.getString("rhyme");

        assert title != null;

        if(title.equals("old")){
            profile.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.old));
            name.setText("Old MacDonald");
            details2.setText(R.string.old);
        }
        else if (title.equals("humpty")){
            profile.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.humpty));
            name.setText("Humpty Dumpty");
            details2.setText(R.string.humpty);
        }
        else if (title.equals("twinkle")){
            profile.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.twinkle));
            name.setText("Twinkle Twinkle");
            details2.setText(R.string.twinkle);
        }
        else if (title.equals("blacksheep")){
            profile.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.blacksheep));
            name.setText("Baa, Baa, Black Sheep");
            details2.setText(R.string.blacksheep);
        }
        else if (title.equals("londonbridge")){
            profile.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.londonbridge));
            name.setText("London Bridge");
            details2.setText(R.string.londonbridge);
        }
        else if (title.equals("hickory")){
            profile.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hickory));
            name.setText("Hickory Dickory Dock");
            details2.setText(R.string.hickory);
        }
        else if (title.equals("ducks")){
            profile.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ducks));
            name.setText("Five Little Ducks");
            details2.setText(R.string.ducks);
        }
        else if (title.equals("jackjill")){
            profile.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jackjill));
            name.setText("Jack and Jill");
            details2.setText(R.string.jackjill);
        }
        else if (title.equals("rain")){
            profile.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.rain));
            name.setText("Rain Rain Go Away");
            details2.setText(R.string.rain);
        }
        else if (title.equals("wheels")){
            profile.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.wheels));
            name.setText("Wheels on the Bus");
            details2.setText(R.string.wheels);
        }

        profile.setOnPreparedListener(mp -> profile.start());

        pauseButton.setOnClickListener(v -> {
            if (profile.isPlaying()) {
                profile.pause();
            }
        });

        resumeButton.setOnClickListener(v -> {
            if (!profile.isPlaying()) {
                profile.start();
            }
        });

    }

    private void setupVolumeControl() {
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        volumeSeekBar.setMax(maxVolume);
        volumeSeekBar.setProgress(currentVolume);

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

}