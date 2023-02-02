package com.app.programacion_multimedia.tema10;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.app.programacion_multimedia.MainActivity;
import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.adapter.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;

public class Tema10 extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ImageButton fabDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temas);

        viewPager2 = findViewById(R.id.viewpager);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        viewPager2.setUserInputEnabled(false);

        fabDownload = findViewById(R.id.fabDownload);
        fabDownload.setImageResource(R.drawable.ic_add_location);
        fabDownload.setOnClickListener(v -> {


        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        MainActivity.tema10 = false;
        return super.onKeyDown(keyCode, event);
    }
}