package com.app.programacion_multimedia.tema9.controlador;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;

public class ControladorChistes {

    private static final String URL = "https://api.chucknorris.io/jokes/random";

    public static void nuevoChiste (Context contexto, String[] value) {
        RequestQueue colaServer = Volley.newRequestQueue(contexto);
        JsonObjectRequest job = new JsonObjectRequest(URL,
                response -> {
                    try {
                        value[0] = response.get("value").toString();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }, error -> System.err.println(error.getMessage()));

        colaServer.add(job);
    }
}
