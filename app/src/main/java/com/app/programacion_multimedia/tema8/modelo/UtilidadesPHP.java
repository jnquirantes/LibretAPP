package com.app.programacion_multimedia.tema8.modelo;

import android.net.Uri;

import java.util.HashMap;
import java.util.Map;

public class UtilidadesPHP {
    public static final String URL_SERVIDOR = "http://192.168.1.5/PHP/";

    public static String buildURL(String url, HashMap<String, String> params) {
        Uri.Builder builder = Uri.parse(url).buildUpon();

        if(params != null) {
            for(Map.Entry<String,String> entry : params.entrySet()) {
                builder.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return builder.build().toString();
    }



}
