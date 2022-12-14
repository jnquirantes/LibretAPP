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

import com.app.programacion_multimedia.databinding.T7Actividad2Binding;

public class T7_Actividad2 extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private T7Actividad2Binding binding2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding2 = T7Actividad2Binding.inflate(getLayoutInflater());
        setContentView(binding2.getRoot());

        setSupportActionBar(binding2.t7Actividad2AppBar.toolbar3);

        DrawerLayout drawer = binding2.drawerLayout2;
        NavigationView navigationView = binding2.desplegable2;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_libreria, R.id.nav_addLibro, R.id.nav_eliminarLibro, R.id.nav_modificarLibro)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_t7_actividad2);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.t7_actividad2_setting, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_t7_actividad2);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}