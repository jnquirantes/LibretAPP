package com.app.programacion_multimedia.tema10;

import static com.app.programacion_multimedia.MainActivity.tema10;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.app.programacion_multimedia.MainActivity;
import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.adapter.ViewPageAdapter;
import com.app.programacion_multimedia.tema7.Tema7;
import com.google.android.material.tabs.TabLayout;

public class Tema10 extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ImageButton bDownload;

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
                if(tab.getPosition() == 0) {
                    viewPager2.setUserInputEnabled(false);
                }
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

        bDownload = findViewById(R.id.fabDownload);
        bDownload.setOnClickListener(v -> {

            PopupMenu popup = new PopupMenu(Tema10.this, v);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.descargar, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case (R.id.mGit):
                        if (tabLayout.getTabAt(0).isSelected()) {
                            Uri webpage = Uri.parse("https://acortar.link/Wo4AemP");
                            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                            startActivity(webIntent);

                        } else if (tabLayout.getTabAt(1).isSelected()) {
                            Uri webpage = Uri.parse("https://acortar.link/jHlGQR");
                            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                            startActivity(webIntent);

                        } else {
                            Toast.makeText(this, "No hay nada en esta área", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                return false;
            });
            popup.show();
        });
    }

    @Override
    public void onBackPressed() {
        int selectedItemId = tabLayout.getSelectedTabPosition();
        if (selectedItemId != 0) {
            tabLayout.selectTab(tabLayout.getTabAt(selectedItemId-1));

        } else {
           startActivity(new Intent(this, MainActivity.class));
            tema10 = false;
        }
    }

}