package com.example.valentine;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.github.dreierf.materialintroscreen.MaterialIntroActivity;
import io.github.dreierf.materialintroscreen.SlideFragmentBuilder;

public class IntroActivity  extends MaterialIntroActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(new SlideFragmentBuilder()
                .title("Where there is great love, there are always wishes")
                .image(R.drawable.first)
                .buttonsColor(R.color.red2)
                .backgroundColor(R.color.red1)
                .build());

        addSlide(new SlideFragmentBuilder()
                .title("If you have only one smile in you give it to the people you love")
                .image(R.drawable.second)
                .buttonsColor(R.color.red2)
                .backgroundColor(R.color.red1)
                .build());

        addSlide(new SlideFragmentBuilder()
                .title("The find that we call Loving is too strong for human minds")
                .image(R.drawable.third)
                .buttonsColor(R.color.red2)
                .backgroundColor(R.color.red1)
                .build());
    }


}
