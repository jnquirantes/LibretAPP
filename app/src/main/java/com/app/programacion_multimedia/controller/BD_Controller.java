package com.app.programacion_multimedia.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.programacion_multimedia.tema7.T7_Actividad1_Receta;

import java.util.ArrayList;


public class BD_Controller extends SQLiteOpenHelper {


    //CREAR TABLAS
    private final String CREATE_RECETAS = "CREATE TABLE Recetas (titulo TEXT, preparacion TEXT, i1 TEXT, " +
            "i2 TEXT, i3 TEXT, i4 TEXT, i5 TEXT, i6 TEXT, i7 TEXT, i8 TEXT, i9 TEXT)";
    private final String CREATE_LIBROS = "CREATE TABLE Libros (nombre TEXT, descripcion TEXT, ISBN TEXT, imagenID INTEGER)";

    //BORRAR TABLAS
    private final String DROP_RECETAS = "DROP TABLE IF EXISTS Recetas";
    private final String DROP_LIBROS = "DROP TABLE IF EXISTS Libros";

    private SQLiteDatabase bd = null;

    public static final int BD_VERSION = 1;
    public static final String BD_NOMBRE = "BDActividades.db";

    private Context contexto;

    public BD_Controller(Context contexto) {
        super(contexto, BD_NOMBRE, null, BD_VERSION);
        this.contexto = contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RECETAS);
        db.execSQL(CREATE_LIBROS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_RECETAS);
        db.execSQL(DROP_LIBROS);
        db.execSQL(CREATE_RECETAS);
        db.execSQL(CREATE_LIBROS);
    }

    //TEMA7
        //Actividad 1
    public void insertarRecetas(EditText etTitulo, EditText etPreparacion, ArrayList<String> ingredientes) {
        bd = getWritableDatabase();
        long newRowId;

        if(bd != null) {
            ContentValues values = new ContentValues();
            values.put("titulo", etTitulo.getText().toString());
            values.put("preparacion", etPreparacion.getText().toString());

            for(int i=1; i<ingredientes.size(); i++) {
                values.put("i" + i, ingredientes.get(i));
            }
            newRowId = bd.insert("Recetas", "", values);
        }

    }

    public ArrayList<T7_Actividad1_Receta> consultarRecetas(){

        ArrayList<T7_Actividad1_Receta> recetas = new ArrayList<>();
        bd = getReadableDatabase();
        String sortOrder = "titulo ASC";

        Cursor c = bd.query(
                "Recetas",
                null,
                null,
                null,
                null,
                null,
                sortOrder
        );

        c.moveToFirst();

        if(c.getCount() > 0) {
            do {
                String titulo = c.getString(0);
                String preparacion = c.getString(1);
                ArrayList<String> ingredientes = new ArrayList<>();

                for(int i=2; i<11; i++) {
                    ingredientes.add(c.getString(i));
                }

                recetas.add(new T7_Actividad1_Receta(titulo, preparacion, ingredientes));

            } while (c.moveToNext());

        } else {
            Toast.makeText(contexto, "No hay ninguna receta", Toast.LENGTH_SHORT).show();
        }

        return recetas;
    }

    //TEMA 7
       //Actividad 2

    public void insertarLibro(EditText etNombre, EditText etDescripcion, EditText etISBN, ImageView imagen){
        bd = getWritableDatabase();

        long newRowId;

        if(bd != null) {
            ContentValues values = new ContentValues();
            values.put("nombre", etNombre.getText().toString());
            values.put("descripcion", etDescripcion.getText().toString());
            values.put("ISBN", etISBN.getText().toString());
            values.put("imagenID", imagen.getId());

            newRowId = bd.insert("AddLibros", "", values);
        }
    }

    public void cerrarBD(){
        if(bd != null){
            bd.close();
        }
    }
}
