package com.app.programacion_multimedia.tema7;

import android.os.Bundle;
import android.view.Menu;

import com.app.programacion_multimedia.R;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.app.programacion_multimedia.databinding.T7Actividad1Binding;

public class T7_Actividad1 extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private T7Actividad1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = T7Actividad1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarT7Actividad1.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.desplegable;

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.item_menu_add, R.id.item_menu_search)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_t7_actividad1);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.t7_actividad1_setting, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_t7_actividad1);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}