package com.app.programacion_multimedia.tema8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.adapter.T8_RecyclerPeces;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Frag_t8_caso extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.t8_frag_caso, container, false);

        RecyclerView recycler = v.findViewById(R.id.recyclerFish);


        try {

            ArrayList<Pescado> pescados = new ArrayList<>();
            String CONTENIDO = "[{\"fish_name\":\"Indian Mackerel\",\"cat_name\":\"Marine  Fish\",\"size_name\":\"Medium\",\"price\":\"100\"},\n" +
                    "{\"fish_name\":\"Manthal Repti\",\"cat_name\":\"Marine Fish\",\"size_name\":\"Small\",\"price\":\"200\"},\n" +
                    "{\"fish_name\":\"Baby Sole Fish\",\"cat_name\":\"Marine Fish\",\"size_name\":\"Small\",\"price\":\"600\"},\n" +
                    "{\"fish_name\":\"Silver Pomfret\",\"cat_name\":\"Marine Fish\",\"size_name\":\"Large\",\"price\":\"300\"},\n" +
                    "{\"fish_name\":\"Squid\",\"cat_name\":\"Shell Fish\",\"size_name\":\"Small\",\"price\":\"800\"},\n" +
                    "{\"fish_name\":\"Clam Meat\",\"cat_name\":\"Shell Fish\",\"size_name\":\"Small\",\"price\":\"350\"},\n" +
                    "{\"fish_name\":\"Indian Prawns\",\"cat_name\":\"Shell Fish\",\"size_name\":\"Medium\",\"price\":\"270\"},\n" +
                    "{\"fish_name\":\"Mud Crab\",\"cat_name\":\"Shell Fish\",\"size_name\":\"Medium\",\"price\":\"490\"},\n" +
                    "{\"fish_name\":\"Grey Mullet\",\"cat_name\":\"Backwater Fish\",\"size_name\":\"Small\",\"price\":\"670\"},\n" +
                    "{\"fish_name\":\"Baasa\",\"cat_name\":\"Backwater Fish\",\"size_name\":\"Large\",\"price\":\"230\"},\n" +
                    "{\"fish_name\":\"Pearl Spot\",\"cat_name\":\"Backwater Fish\",\"size_name\":\"Small\",\"price\":\"340\"},\n" +
                    "{\"fish_name\":\"Anchovy\",\"cat_name\":\"Marine Fish\",\"size_name\":\"Small\",\"price\":\"130\"},\n" +
                    "{\"fish_name\":\"Sole Fish\",\"cat_name\":\"Marine Fish\",\"size_name\":\"Medium\",\"price\":\"250\"},\n" +
                    "{\"fish_name\":\"Silver Croaker\",\"cat_name\":\"Marine Fish\",\"size_name\":\"Small\",\"price\":\"220\"}]";
            JSONArray jArray = new JSONArray(CONTENIDO);

            for(int i=0; i<jArray.length(); i++) {
                JSONObject obj = jArray.getJSONObject(i);
                String nombre = obj.getString("fish_name");
                String tipo = obj.getString("cat_name");
                String size = obj.getString("size_name");
                int precio = obj.getInt("price");
                Pescado p = new Pescado(nombre,size, tipo, precio);
                pescados.add(p);

             }

            recycler.setHasFixedSize(true);

            LinearLayoutManager llm = new LinearLayoutManager(Frag_t8_caso.this.getContext());
            recycler.setLayoutManager(llm);
            T8_RecyclerPeces adaptador = new T8_RecyclerPeces(Frag_t8_caso.this.getContext(), pescados);
            recycler.setAdapter(adaptador);
            adaptador.refrescar();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return v;
    }
}