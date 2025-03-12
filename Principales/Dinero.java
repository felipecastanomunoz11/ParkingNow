package Principales;

public class Dinero {
    private int dineroTotalBajoCilindraje;
    private int dineroTotalAltoCilindraje;

    public Dinero  (){
        this.dineroTotalBajoCilindraje = 0;
        this.dineroTotalAltoCilindraje = 0;
    }

    public void sumarDineroTotalBajoCilindraje(int cantidad){
        this.dineroTotalBajoCilindraje = this.dineroTotalBajoCilindraje + cantidad;
    }

    public void sumarDineroTotalAltoCilindraje(int cantidad){
        this.dineroTotalAltoCilindraje = this.dineroTotalAltoCilindraje + cantidad;
    }

    public int getDineroTotal() {
        return  this.dineroTotalAltoCilindraje + this.dineroTotalBajoCilindraje;
    }

    public int getDineroTotalBajoCilindraje(){
        return dineroTotalBajoCilindraje;
    }

    public int getDineroAltocilindraje(){
        return dineroTotalAltoCilindraje;
    }

    public void setDineroTotalBajoCilindraje(int dineroTotalBajoCilindraje) {
        this.dineroTotalBajoCilindraje = dineroTotalBajoCilindraje;
    }

    public void setDineroTotalAltoCilindraje(int dineroTotalAltoCilindraje) {
        this.dineroTotalAltoCilindraje = dineroTotalAltoCilindraje;
    }


}
