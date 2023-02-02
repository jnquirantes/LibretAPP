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
import com.app.programacion_multimedia.tema8.modelo.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ControladorUser {
    private static final String BUSCAR_USER = URL_SERVIDOR + "buscar_user.php";
    private static final String BUSCAR_ID = URL_SERVIDOR + "buscar_user.php?id=";
    private static final String INSERT_USER = URL_SERVIDOR + "insert_user.php?user=";

    public static void obtenerUsers(Context context, ArrayList<User> users, EditText etID) {

        RequestQueue colaServer = Volley.newRequestQueue(context);
        String url, ID;
        ID = etID.getText().toString();

        if(ID.isEmpty()) {
            url = BUSCAR_USER;

        } else {
            url = BUSCAR_ID + ID;
        }

        JsonArrayRequest jar = new JsonArrayRequest(url,
                response -> {
                    JSONObject obj;

                    for (int i = 0; i < response.length(); i++) {
                        try {
                            obj = response.getJSONObject(i);
                            String id = String.valueOf(obj.getInt("id"));
                            String user = obj.getString("user");
                            String pass = obj.getString("pass");
                            User u = new User(id, user, pass);
                            users.add(u);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, error -> {
        });
        colaServer.add(jar);
    }

    public static void crearRegistro(Context context, EditText etUser, EditText etPass){

        final String user= etUser.getText().toString().trim();
        final String pass= etPass.getText().toString().trim();

        // Construimos la direccion de la URL remota, pasando los parametros
        String url= INSERT_USER + user + "&pass=" + pass;

        RequestQueue colaServidor = Volley.newRequestQueue(context);
        StringRequest respuesta = new StringRequest(
                Request.Method.GET, url,
                response -> {
                    if(!user.isEmpty()) {
                        Toast.makeText(context, "Usuario: " + user + " creado", Toast.LENGTH_SHORT).show();
                        etUser.setText("");
                        etPass.setText("");
                    } else {
                        etUser.requestFocus();
                        etUser.setError("Inserte nombre de usuario");
                    }
                },

                error -> Toast.makeText(context, "Error al crear usuario", Toast.LENGTH_SHORT).show()
        );
        colaServidor.add(respuesta);
    }
}