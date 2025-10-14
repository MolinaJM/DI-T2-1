package com.javafx.B_cargaOL;

//Robot creado con Alt+Insert Code tras introducir las propiedades privadas
public class Robot {

    private String nombre;
    private String peli;

    public Robot(String nombre, String peli) {
        this.nombre=nombre;
        this.peli=peli;
    }
    
    public Robot() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public String getPeli() {
        return peli;
    }

    public void setPeli(String peli) {
        this.peli=peli;
    }




  
}
