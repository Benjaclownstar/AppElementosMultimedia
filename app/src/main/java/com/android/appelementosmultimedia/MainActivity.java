package com.android.appelementosmultimedia;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        checkPermissions();
    }

    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != packageManager.PERMISSION_GRANTED) {
            activityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(This, "Permission denied", Toast.LENGHT_SHORT).show();
            }
        }
    }

    Button playAudioButton = findViewById(R.id.playAudioButton);
    playAudioButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity,this,
                    R.raw.WiiShopChannel.mp3);
            mediaPlayer.start();
        }
    });

    videoView videoView = findViewById(R.id.myVideoView);
    Button playVideoButton = findViewById(R.id.playVideoButton);
    playVideoButton.setOnClickListener(new View.OnClickListener()) {
        @Override
        public void onClick(View v) {
            uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/"
            + R.raw./* video file name*/);
            videoView.setVideoURI(videoUri);
            videoView.start();
        }
    });

    Button animateButton = findViewById(R.id.animateButton);
    final ImageView imageView = findViewById(R.id./*animation image view id*/);
    animateButton.setOnClickListener(new View.OnClickListener() {
        @Override
                public void onClick(View v) {
            Animation fadeInAnimation =
                    AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
            ImageView.startAnimation(fadeInAnimation);
        }
    }):
}