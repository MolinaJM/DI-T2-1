package com.javafx.tableview;

//Tras introducir las propiedades privadas se autogenera el código  
//con Botón Derecho sobre el código, luego Source Actions, luego Generate Constructors,
//luego Generate Getters and Setters, incluso Generate toString() 
public class RobotFoto extends Robot{
//OJO! Siempre tienen que ser OBJETOS, no datos simples, dado que es obligatorio para configurar las columnas del TV 
    private String fotoURL;
    private Boolean sigueconvida;

    public RobotFoto(String nombre, String peli, String fotoURL, Boolean sigueconvida) {
        super(nombre, peli);
        this.fotoURL=fotoURL;
        this.sigueconvida=sigueconvida;
    }

    public Boolean isSigueconvida() {
        return sigueconvida;
    }

    public void setSigueconvida(Boolean sigueconvida) {
        this.sigueconvida=sigueconvida;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL=fotoURL;
    }



  
}
