package com.example.cuteicons;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView animalName;
    private ImageView catIcon, dogIcon, lionIcon, monkeyIcon, pandaIcon, rabbitIcon, snakeIcon, tigerIcon, cowIcon, horseIcon;
    private MediaPlayer mediaPlayer;
    private Animation shakeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalName = findViewById(R.id.animalName);

        catIcon = findViewById(R.id.catIcon);
        dogIcon = findViewById(R.id.dogIcon);
        lionIcon = findViewById(R.id.lionIcon);
        monkeyIcon = findViewById(R.id.monkeyIcon);
        pandaIcon = findViewById(R.id.pandaIcon);
        rabbitIcon = findViewById(R.id.rabbitIcon);
        snakeIcon = findViewById(R.id.snakeIcon);
        tigerIcon = findViewById(R.id.tigerIcon);
        cowIcon = findViewById(R.id.cowIcon);
        horseIcon = findViewById(R.id.horseIcon);

        shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);

        setIconListener(catIcon, "Cat", R.raw.cat_sound);
        setIconListener(dogIcon, "Dog", R.raw.dog_sound);
        setIconListener(lionIcon, "Lion", R.raw.lion_sound);
        setIconListener(monkeyIcon, "Monkey", R.raw.monkey_sound);
        setIconListener(pandaIcon, "Panda", R.raw.panda_sound);
        setIconListener(rabbitIcon, "Rabbit", R.raw.rabbit_sound);
        setIconListener(snakeIcon, "Snake", R.raw.snake_sound);
        setIconListener(tigerIcon, "Tiger", R.raw.tiger_sound);
        setIconListener(cowIcon, "Cow", R.raw.cow_sound);
        setIconListener(horseIcon, "Horse", R.raw.horse_sound);
    }

    private void setIconListener(ImageView icon, String name, int soundRes) {
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animalName.setText(name);
                animalName.startAnimation(shakeAnimation);

                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }

                mediaPlayer = MediaPlayer.create(MainActivity.this, soundRes);
                mediaPlayer.start();
            }
        });
    }

    public void reset(View view) {
        animalName.setText("Select an animal");
        animalName.setTextColor(getResources().getColor(R.color.black));
    }
}

