package com.javafx.tableview;

//Tras introducir las propiedades privadas se autogenera el código  
//con Botón Derecho sobre el código, luego Source Actions, luego Generate Constructors,
//luego Generate Getters and Setters, incluso Generate toString() 
public class Robot {
    //OJO! Los tipos de datos tendrán que ir acorde con el uso que se les va a dar luego
    //Si configuramos TV es obligatorio para configurar las columnas del TV 
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
