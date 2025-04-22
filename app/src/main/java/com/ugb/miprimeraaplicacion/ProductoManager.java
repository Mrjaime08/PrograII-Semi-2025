package com.ugb.miprimeraaplicacion;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.Context;

public class ProductoManager {

    private DBHelper dbHelper;

    public ProductoManager(Context context) {
        dbHelper = new DBHelper(context); // Inicializa el DBHelper con el contexto
    }

    public String administrar_productos(String accion, String[] parametros) {
        SQLiteDatabase db = dbHelper.getWritableDatabase(); // Obtén la base de datos
        String respuesta = "ok";

        switch (accion) {
            case "insertar":
                ContentValues valores = new ContentValues();
                valores.put("codigo", parametros[0]);
                valores.put("nombre", parametros[1]);
                valores.put("presentacion", parametros[2]);
                valores.put("marca", parametros[3]);
                valores.put("precio", parametros[4]);
                valores.put("urlFoto", parametros[5]);
                valores.put("costo", parametros[6]);
                valores.put("porcentajeGanancia", parametros[7]);
                valores.put("stock", parametros[8]);

                db.insert("productos", null, valores); // Inserta el producto
                break;

            case "modificar":
                ContentValues valoresMod = new ContentValues();
                valoresMod.put("codigo", parametros[0]);
                valoresMod.put("nombre", parametros[1]);
                valoresMod.put("presentacion", parametros[2]);
                valoresMod.put("marca", parametros[3]);
                valoresMod.put("precio", parametros[4]);
                valoresMod.put("urlFoto", parametros[5]);
                valoresMod.put("costo", parametros[6]);
                valoresMod.put("porcentajeGanancia", parametros[7]);
                valoresMod.put("stock", parametros[8]);

                db.update("productos", valoresMod, "idProducto = ?", new String[]{parametros[9]});
                break;

            // Puedes agregar más casos como "eliminar", "consultar", etc.

            default:
                respuesta = "Acción no válida";
                break;
        }
        return respuesta;
    }
}
