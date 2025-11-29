package com.example.cute_icons_app;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView iconS;
    private Button buttonD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout file
        setContentView(R.layout.activity_main);

        // Initialize the views
        iconS = findViewById(R.id.IconStrings);
        buttonD = findViewById(R.id.ButtonDefault);

        // Set up the listeners for the animal icons
        iconUI();

        // Set up the listener for the Clear Text button
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReturnToDefault();
            }
        });
    }

    private void iconUI() {
        // Pass the icon ID, text ID, color ID, and sound ID to each listener
        setIconListener(R.id.catID, R.string.catS, R.color.catC, R.raw.cat);
        setIconListener(R.id.dogID, R.string.dogS, R.color.dogC, R.raw.dog);
        setIconListener(R.id.birdID, R.string.birdS, R.color.birdC, R.raw.birds);
        setIconListener(R.id.elephantID, R.string.elephantS, R.color.elephantC, R.raw.elephant);
        setIconListener(R.id.cowID, R.string.cowS, R.color.cowC, R.raw.cow);
        setIconListener(R.id.horseID, R.string.horseS, R.color.horseC, R.raw.horse);
        setIconListener(R.id.duckID, R.string.duckS, R.color.duckC, R.raw.duck);
        setIconListener(R.id.lambID, R.string.lambS, R.color.lambC, R.raw.lamb);
        setIconListener(R.id.goatID, R.string.goatS, R.color.goatC, R.raw.goat);
        setIconListener(R.id.monkeyID, R.string.monkeyS, R.color.monkeyC, R.raw.monkey);
    }

    private void setIconListener(int cuteIcon, int stringText, int colour, int soundNoise) {
        ImageView icon;
        icon = findViewById(cuteIcon);

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Making the animation of shake when user clicks on the icon
                Animation smallShake = AnimationUtils.loadAnimation(MainActivity.this,
                        R.anim.shake);
                icon.startAnimation(smallShake);

                // Change the text and colour on the top when new icon clicked
                ChangeUI(stringText, colour);

                // Play sound of animals when user clicks on the icon
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, soundNoise);
                mediaPlayer.start();

                // Release resources once sound completes
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.release();
                    }
                });
            }
        });
    }

    private void ChangeUI(int stringResId, int colorResId) {
        // Change the text and its color
        iconS.setText(stringResId);
        iconS.setTextColor(getResources().getColor(colorResId));

        // Change the button's background color and make it visible
        buttonD.setBackgroundTintList(getResources().getColorStateList(colorResId));
        buttonD.setVisibility(View.VISIBLE);
    }

    private void ReturnToDefault() {
        // Reset the text and color
        iconS.setText(R.string.defaultS);
        iconS.setTextColor(Color.BLACK);

        // Reset the button to its default state and hide it
        buttonD.setVisibility(View.GONE);
        buttonD.setBackgroundTintList(getResources().getColorStateList(R.color.white));
    }
}
