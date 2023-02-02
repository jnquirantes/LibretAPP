package com.app.programacion_multimedia.tema9;

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

public class Tema9 extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temas);

        viewPager2 = findViewById(R.id.viewpager);

        tabLayout = findViewById(R.id.tabLayout);
        ViewPageAdapter tabAdapter = new ViewPageAdapter(this);
        viewPager2.setAdapter(tabAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        ImageButton bDownload = findViewById(R.id.fabDownload);
        bDownload.setOnClickListener(v -> {

            PopupMenu popup = new PopupMenu(Tema9.this, v);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.descargar, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.mGit) {
                    if (tabLayout.getTabAt(0).isSelected()) {
                        Uri webpage = Uri.parse("https://github.com/jnquirantes/Programacion_Multimedia_2DAM/blob/main/app/src/main/java/com/app/programacion_multimedia/tema8/Frag_t8_caso.java");
                        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                        startActivity(webIntent);
                    }
                }
                return false;
            });
            popup.show();
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        MainActivity.tema9 = false;
        return super.onKeyDown(keyCode, event);
    }
}