package com.ugb.miprimeraaplicacion;

import java.util.Base64;

public class utilidades {
    static String url_consulta = "http://192.168.200.79:5984/emerson/_design/jaime/_view/jaime";
    static String url_mto = "http://192.168.200.79:5984/emerson";
    static String user = "admin";
    static String passwd = "guilledavid31";
    static String credencialesCodificadas = Base64.getEncoder().encodeToString((user + ":" + passwd).getBytes());
    public String generarUnicoId(){
        return java.util.UUID.randomUUID().toString();
    }
}