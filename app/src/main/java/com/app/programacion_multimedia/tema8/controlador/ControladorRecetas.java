package com.app.programacion_multimedia.tema8.controlador;

import static com.app.programacion_multimedia.tema8.modelo.UtilidadesPHP.URL_SERVIDOR;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ControladorRecetas {
    private static final String BUSCAR_RECETAS = URL_SERVIDOR + "buscar_receta.php";
    private static final String BUSCAR_CATEGORIA = URL_SERVIDOR + "buscar_receta.php?categoria=";
    private static final String INSERT_RECETA = URL_SERVIDOR + "insert_receta.php?nombre=";

    public static void obtenerRecetas(Context context, ArrayList<String> titulos, EditText etCategoria) {
        RequestQueue colaServer = Volley.newRequestQueue(context);
        String url, categoria;
        categoria = etCategoria.getText().toString();

        if(categoria.isEmpty()) {
            etCategoria.setError("Introduzca una categoría");
            etCategoria.requestFocus();
            return;
        }

        if(!categoria.equals("PLATO") && !categoria.equals("BEBIDA") && !categoria.equals("POSTRE")) {
            etCategoria.setError("PLATO, BEBIDA O POSTRE");
            etCategoria.requestFocus();
            Toast.makeText(context, "Categoría errónea", Toast.LENGTH_SHORT).show();
            return;

        }  else {
            url = BUSCAR_CATEGORIA + categoria;

            JsonArrayRequest jar = new JsonArrayRequest(url,
                    response -> {
                        JSONObject obj;

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                obj = response.getJSONObject(i);
                                String nombre = obj.getString("nombre");
                                titulos.add(nombre);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }, Throwable::printStackTrace);
            colaServer.add(jar);
        }
    }

    public static void crearReceta(Context context, EditText etTitulo, EditText etPreparacion, EditText etBuscar, ArrayList<String> ingredientes){

        final String nombre = etTitulo.getText().toString().trim();
        final String preparacion = etPreparacion.getText().toString().trim();
        final String categoria = etBuscar.getText().toString().trim().toUpperCase();

        // Construimos la direccion de la URL remota, pasando los parametros
        String url= INSERT_RECETA + nombre + "&categoria=" + categoria + "&preparacion=" + preparacion + "&ingredientes=" + ingredientes.get(0);

        if(nombre.isEmpty() || categoria.isEmpty()) {
            Toast.makeText(context, "Rellene los campos obligatorios", Toast.LENGTH_SHORT).show();
            etTitulo.setError("Obligatorio");
            etBuscar.setError("Obligatorio");
            return;
        }

        if(!categoria.equals("PLATO") && !categoria.equals("BEBIDA") && !categoria.equals("POSTRE")) {
            etBuscar.setError("PLATO; BEBIDA O POSTRE");
            etBuscar.requestFocus();
            Toast.makeText(context, "Categoría errónea", Toast.LENGTH_SHORT).show();
            return;
        }

        RequestQueue colaServidor = Volley.newRequestQueue(context);
        StringRequest respuesta = new StringRequest(
                Request.Method.GET, url,
                response -> {
                    etTitulo.setText("");
                    etPreparacion.setText("");
                    etBuscar.setText("");
                    ingredientes.clear();
                    Toast.makeText(context, "Receta de " + nombre + "añadida", Toast.LENGTH_SHORT).show();
                },

                Throwable::printStackTrace

        );
        colaServidor.add(respuesta);
    }
}
