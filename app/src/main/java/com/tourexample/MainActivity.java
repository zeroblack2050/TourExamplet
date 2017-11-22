package com.tourexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.Toast;

import tourguide.tourguide.ChainTourGuide;
import tourguide.tourguide.Overlay;
import tourguide.tourguide.Pointer;
import tourguide.tourguide.Sequence;
import tourguide.tourguide.ToolTip;
import tourguide.tourguide.TourGuide;

public class MainActivity extends AppCompatActivity {

    private Button one, two, three;

    //Library's web site: https://github.com/worker8/TourGuide
    private AlphaAnimation enterAnimation, exitAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadButtons();
        initAnimationTour();

        runAnimationTour();

    }

    private void runAnimationTour() {
        ChainTourGuide tourGuideButtonOne = ChainTourGuide.init(this)
                .setToolTip(new ToolTip()
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                executeButtonOne();
                            }
                        })
                        .setTitle("Bienvenido.")
                        .setDescription("Este boton llama a un Toast.")
                        .setGravity(Gravity.BOTTOM)

                )
                .playLater(one)
                ;


        ChainTourGuide tourGuideButtonTwo = ChainTourGuide.init(this)
                .setToolTip(new ToolTip()
                        .setTitle("Bienvenido.")
                        .setDescription("Este boton llama a un Toast.")
                        .setGravity(Gravity.BOTTOM|Gravity.LEFT)
                )
                .playLater(two)
                ;

        ChainTourGuide tourGuideButtonThree = ChainTourGuide.init(this)
                .setToolTip(new ToolTip()
                        .setTitle("Bienvenido.")
                        .setDescription("Este boton llama a un Toast.")
                        .setGravity(Gravity.TOP)

                )
                .playLater(three);

        Sequence sequence = new Sequence.SequenceBuilder()
                .add(tourGuideButtonOne,tourGuideButtonTwo,tourGuideButtonThree)
                .setDefaultOverlay(new Overlay()
                        .setEnterAnimation(enterAnimation)
                        .setExitAnimation(exitAnimation)

                ).setDefaultPointer(null)
                .setContinueMethod(Sequence.ContinueMethod.Overlay)
                .build();
        ChainTourGuide.init(this).playInSequence(sequence);
    }

    private void loadButtons() {
        one = findViewById(R.id.one);
        two =  findViewById(R.id.two);
        three = findViewById(R.id.three);
    }

    private void executeButtonOne(){
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Justo", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void executeButtonTwo(){
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Jasmany", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void executeButtonThree(){
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Jaramillo", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initAnimationTour() {
        enterAnimation = new AlphaAnimation(0f, 1f);
        enterAnimation.setDuration(600);
        enterAnimation.setFillAfter(true);
        enterAnimation.setInterpolator(new BounceInterpolator());

        exitAnimation = new AlphaAnimation(0f, 1f);
        exitAnimation.setDuration(600);
        exitAnimation.setFillAfter(true);
    }
}
