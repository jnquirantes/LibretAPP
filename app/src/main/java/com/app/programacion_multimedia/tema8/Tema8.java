package com.app.programacion_multimedia.tema8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.app.programacion_multimedia.MainActivity;
import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.adapter.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tema8 extends AppCompatActivity {

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

            PopupMenu popup = new PopupMenu(Tema8.this, v);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.descargar, popup.getMenu());
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case(R.id.mGit):
                            if (tabLayout.getTabAt(0).isSelected()) {
                                Uri webpage = Uri.parse("https://github.com/jnquirantes/Programacion_Multimedia_2DAM/blob/main/app/src/main/java/com/app/programacion_multimedia/tema8/Frag_t8_caso.java");
                                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                                startActivity(webIntent);
                            }
                            break;

                        case(R.id.mDescarga):
                            String texto = "";
                            try {
                                BufferedReader br = new BufferedReader(new FileReader("tema4/T4_Actividad1.java"));
                                br.read();

                                while(br.read()!=-1){
                                    texto += (char)br.read();
                                }
                                br.close();

                                BufferedWriter bw = new BufferedWriter(new FileWriter("/data/data/com.app.programacion_multimedia/Code_T4Actividad1.java"));
                                bw.write(texto);
                                bw.close();

                                Toast.makeText(Tema8.this, "Fichero descargado", Toast.LENGTH_SHORT).show();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                    return false;
                }
            });
            popup.show();
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        MainActivity.tema8 = false;
        return super.onKeyDown(keyCode, event);
    }
}