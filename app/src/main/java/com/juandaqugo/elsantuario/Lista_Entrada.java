package com.juandaqugo.elsantuario;

/**
 * Created by Usuario on 14/03/2017.
 */

public class Lista_Entrada {
    private int idImagen;
    private String nombre, descrip;
    public Lista_Entrada(int idImagen, String nombre, String descrip){
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.descrip = descrip;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
