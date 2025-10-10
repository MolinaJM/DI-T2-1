package com.javafx.tableview;

import javax.print.DocFlavor.STRING;

public class Futbolista {

    private String nombre;
    private int dorsal;

    private String posic;

    public Futbolista(String nombre, int dorsal, String posic) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.posic = posic;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosic() {
        return posic;
    }

    public void setPosic(String posic) {
        this.posic = posic;
    }


    

}
