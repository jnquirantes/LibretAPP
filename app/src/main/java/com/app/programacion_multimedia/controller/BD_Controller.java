package com.app.programacion_multimedia.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

import com.app.programacion_multimedia.tema7.Receta;
import com.app.programacion_multimedia.tema7.T7_Actividad2_Libro;

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

        if(bd != null) {
            ContentValues values = new ContentValues();
            values.put("titulo", etTitulo.getText().toString());
            values.put("preparacion", etPreparacion.getText().toString());

            for(int i=1; i<ingredientes.size(); i++) {
                values.put("i" + i, ingredientes.get(i));
            }
            bd.insert("Recetas", "", values);
        }

    }

    public ArrayList<Receta> consultarRecetas(){

        ArrayList<Receta> recetas = new ArrayList<>();
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

                recetas.add(new Receta(titulo, preparacion, ingredientes, null));

            } while (c.moveToNext());
            c.close();
        } else {
            Toast.makeText(contexto, "No hay ninguna receta", Toast.LENGTH_SHORT).show();
        }

        return recetas;
    }

    //TEMA 7
       //Actividad 2

    public void insertarLibro(EditText etNombre, EditText etDescripcion, EditText etISBN){
        bd = getWritableDatabase();

        if(bd != null) {
            ContentValues values = new ContentValues();
            values.put("nombre", etNombre.getText().toString());
            values.put("descripcion", etDescripcion.getText().toString());
            values.put("ISBN", etISBN.getText().toString());

            bd.insert("Libros", "", values);
            Toast.makeText(contexto, "Libro añadido", Toast.LENGTH_SHORT).show();

        }
    }

    public void eliminarLibro(String isbn) {
        bd = getWritableDatabase();
        bd.delete("Libros", "isbn= ?", new String[]{isbn});
        Toast.makeText(contexto, "Libro borrado", Toast.LENGTH_SHORT).show();

    }

    public void modificarLibro(String isbn, String titulo, String descripcion) {
        bd = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", titulo);
        values.put("descripcion", descripcion);

        bd.update("Libros", values, "isbn=?", new String[]{isbn});
        Toast.makeText(contexto, "Libro modificado", Toast.LENGTH_SHORT).show();

    }

    public ArrayList<T7_Actividad2_Libro> consultar() {
        ArrayList<T7_Actividad2_Libro> libros = new ArrayList<>();
        bd = getReadableDatabase();
        Cursor c = bd.query("Libros", null, null, null, null, null, null);
        if (c.getCount() > 0) {
            c.moveToFirst();
            while(c.moveToNext()) {
                String titulo = c.getString(c.getColumnIndexOrThrow("nombre"));
                String descripcion = c.getString(c.getColumnIndexOrThrow("descripcion"));
                String isbn = c.getString(c.getColumnIndexOrThrow("ISBN"));
                //int img = c.getInt(c.getColumnIndexOrThrow("imagen"));

                T7_Actividad2_Libro libro = new T7_Actividad2_Libro(titulo, descripcion, isbn, 0);
                libros.add(libro);
            }

            c.close();
        }
        return libros;
    }

    public T7_Actividad2_Libro consultarLibro(String isbn) {
        bd = getWritableDatabase();

        Cursor c = bd.query("Libros", null, "isbn=?", new String[]{isbn}, null, null, null);
        String titulo, descripcion;

        if(c.getCount() > 0) {
            c.moveToFirst();
            titulo = c.getString(0);
            descripcion = c.getString(1);
            System.out.println(titulo + "-----------------------------------" + descripcion);
            c.close();
            return new T7_Actividad2_Libro(titulo, descripcion, isbn);

        } else {
            return null;
        }
    }

    public void cerrarBD(){
        if(bd != null){
            bd.close();
        }
    }
}
