package com.app.programacion_multimedia.tema7.ui.buscar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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
    private BD_Controller bd;
    private ArrayList<T7_Actividad1_Receta> recetas;
    private ArrayList<String> titulos;
    private ArrayList<ArrayList<String>> ingredientes;
    private RecyclerView recyclerRecetas;
    private T7_RecyclerRecetas adaptadorRecetas;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.t7_actividad1_buscar, container, false);


        etBuscar = view.findViewById(R.id.etBuscar);
        Button bSearch = view.findViewById(R.id.bSearch);
        recyclerRecetas = view.findViewById(R.id.recyclerRecetas);
        etBuscar.setText("");
        bd = new BD_Controller(BuscarReceta.this.getContext());
        recetas = new ArrayList<>();
        titulos = new ArrayList<>();
        ingredientes = new ArrayList<>();

        bSearch.setOnClickListener(v -> {
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
                         }
                    }
                    lista.clear();
                }

                recyclerRecetas.setHasFixedSize(false);
                recyclerRecetas.setLayoutManager(new LinearLayoutManager(BuscarReceta.this.getContext()));


                adaptadorRecetas = new T7_RecyclerRecetas(BuscarReceta.this.getContext(), titulos);
                adaptadorRecetas.setOnclickListener(v1 -> {
                    for(int i=0; i<recetas.size(); i++) {
                            //String elegido = recetas.get(recyclerRecetas.getChildAdapterPosition(v1)).getTitulo();
                            AlertDialog alertDialog;
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext().getApplicationContext());
                            builder.setCancelable(true); //Al pulsar la pantalla, fuera del AlertDialog, se cierra

                            LayoutInflater infl = getLayoutInflater();
                            View vi = infl.inflate(R.layout.t7_item_dialog, null);

                            Button aOK = v.findViewById(R.id.aOK);
                            TextView aTitulo = v.findViewById(R.id.aTitulo);
                            TextView aPreparacion = v.findViewById(R.id.aPreparacion);
                            TableRow fila1 = v.findViewById(R.id.fila1);
                            TableRow fila2 = v.findViewById(R.id.fila2);
                            TableRow fila3 = v.findViewById(R.id.fila3);

                            for(int j=0; i< ingredientes.size(); i++) {
                                TextView ing = new TextView(getContext());

                                if(j<3) {
                                    ing.setText(ingredientes.get(i).toString());
                                    fila1.addView(ing);

                                } else if(j<6) {
                                    ing.setText(ingredientes.get(i).toString());
                                    fila2.addView(ing);

                                } else {
                                    ing.setText(ingredientes.get(i).toString());
                                    fila3.addView(ing);
                                }

                            }
                            builder.setView(v);
                            alertDialog = builder.create();

                            aOK.setOnClickListener(v2 -> {

                            });

                            alertDialog.show();
                        }


                });

                recyclerRecetas.setAdapter(adaptadorRecetas);
                adaptadorRecetas.refrescar();


                etBuscar.setText("");
                bd.close();

            } else {
                etBuscar.setError("Introduce un ingrdiente");
                etBuscar.requestFocus();
                return;
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