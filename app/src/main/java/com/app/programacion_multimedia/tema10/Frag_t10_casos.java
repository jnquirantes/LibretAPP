package com.app.programacion_multimedia.tema10;

import static com.app.programacion_multimedia.tema10.Frag_t10_Actividad1.enviado;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.programacion_multimedia.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Frag_t10_casos extends Fragment {

    private static ArrayList<LatLng> listaMarcadores = new ArrayList<>();
    private static ArrayList<String> listaTitulos = new ArrayList<>();


    private OnMapReadyCallback callback = googleMap -> {
        LatLng granada = new LatLng(37.17820568878431, -3.5945339662230125);
        //googleMap.addMarker(new MarkerOptions().position(granada).title("Granada"));

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(granada));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(granada, 12.5f));

        if(enviado == true) {
            String marcador = getActivity().getIntent().getExtras().getString("marcador");
            String latitudS = getActivity().getIntent().getExtras().getString("latitud");
            Double latitud = Double.parseDouble(latitudS);
            String longitudS = getActivity().getIntent().getExtras().getString("longitud");
            Double longitud = Double.parseDouble(longitudS);

            LatLng coordenadas = new LatLng(latitud, longitud);
            listaMarcadores.add(coordenadas);
            listaTitulos.add(marcador);
            enviado = false;
        }

        for (int i=0; i<listaTitulos.size(); i++) {
            googleMap.addMarker(new MarkerOptions().position(listaMarcadores.get(i)).title(listaTitulos.get(i)));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_t10_casos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }




    }
}