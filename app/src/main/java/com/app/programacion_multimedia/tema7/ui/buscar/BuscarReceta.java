package com.app.programacion_multimedia.tema7.ui.buscar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.adapter.T7_RecyclerRecetas;
import com.app.programacion_multimedia.controller.BD_Controller;
import com.app.programacion_multimedia.databinding.T7Actividad1BuscarBinding;
import com.app.programacion_multimedia.tema7.T7_Actividad1_Receta;

import java.util.ArrayList;

public class BuscarReceta extends Fragment {

private T7Actividad1BuscarBinding binding;

    private EditText etBuscar;
    private Button bSearch;
    private BD_Controller bd;
    private ArrayList<T7_Actividad1_Receta> recetas;
    private ArrayList<String> titulos;
    private ArrayList<ArrayList<String>> ingredientes;
    private RecyclerView recycler;
    private T7_RecyclerRecetas ra;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.t7_actividad1_buscar, container, false);

        etBuscar = view.findViewById(R.id.etBuscar);
        bSearch = view.findViewById(R.id.bSearch);
        recycler = view.findViewById(R.id.recyclerFish);
        etBuscar.setText("");
        bd = new BD_Controller(BuscarReceta.this.getContext());
        recetas = new ArrayList<>();
        titulos = new ArrayList<>();
        ingredientes = new ArrayList<>();

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titulos.clear();
                ingredientes.clear();
                recetas.clear();
                String busqueda = etBuscar.getText().toString();
                ArrayList<String> lista = new ArrayList<>();

                if(!busqueda.equals("")) {
                    recetas.addAll(bd.consultarRecetas()) ;

                    for(int i=0; i<recetas.size(); i++) {
                        ingredientes.add(recetas.get(i).getIngredientes());
                    }

                    for(int i=0; i<ingredientes.size(); i++) {

                        lista.add(ingredientes.get(i).toString());

                        for(int j=0; j<lista.size(); j++){
                            if(lista.get(j).contains(etBuscar.getText().toString())) {
                                titulos.add(recetas.get(i).getTitulo());
                                Log.e("titulos", titulos.get(0));
                             }
                        }
                        lista.clear();
                    }

                    recycler.setHasFixedSize(false);
                    recycler.setLayoutManager(new LinearLayoutManager(BuscarReceta.this.getContext()));

                    ra = new T7_RecyclerRecetas(BuscarReceta.this.getContext(), titulos);
                    recycler.setAdapter(ra);
                    ra.refrescar();


                    etBuscar.setText("");
                    bd.close();

                } else {
                    Toast.makeText(BuscarReceta.this.getContext(), "Introduce un ingrediente", Toast.LENGTH_SHORT).show();
                    etBuscar.requestFocus();
                    return;
                }
            }
        });
        return view;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}