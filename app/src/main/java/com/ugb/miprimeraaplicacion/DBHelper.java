package com.ugb.miprimeraaplicacion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // Nombre y versión de la base de datos
    private static final String DATABASE_NAME = "productos.db"; // Nombre de la base de datos
    private static final int DATABASE_VERSION = 2; // Versión de la base de datos (la incrementamos a 2 para incluir los cambios)

    // Constructor
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION); // Llama al constructor de SQLiteOpenHelper
    }

    // Método para crear la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Aquí defines las tablas y sus campos
        String createTable = "CREATE TABLE productos (" +
                "idProducto INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "codigo TEXT, " +
                "nombre TEXT, " +
                "presentacion TEXT, " +
                "marca TEXT, " +
                "precio TEXT, " +
                "urlFoto TEXT, " +
                "costo TEXT, " + // Nuevo campo
                "porcentajeGanancia TEXT, " + // Nuevo campo
                "stock TEXT);"; // Nuevo campo

        db.execSQL(createTable); // Ejecuta la consulta para crear la tabla
    }

    // Método para actualizar la base de datos si la versión cambia
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Si se cambia la versión, se agrega la columna (sin perder datos existentes)
        if (oldVersion < 2) {  // Verifica si la versión anterior es menor que la nueva
            db.execSQL("ALTER TABLE productos ADD COLUMN costo TEXT;");
            db.execSQL("ALTER TABLE productos ADD COLUMN porcentajeGanancia TEXT;");
            db.execSQL("ALTER TABLE productos ADD COLUMN stock TEXT;");
        }
    }
}
