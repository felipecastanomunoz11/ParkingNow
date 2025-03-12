package Principales;


public class Parqueadero {

    private Moto[] puestosBajoCilindraje = new Moto[20];
    private Moto[] puestosAltoCilindraje = new Moto[10];

    public int calcularPrecio(Moto motoACalcularPrecio, int horaSalida, int minutosSalida){

        if(horaSalida < 7 || horaSalida > 22){
            System.out.println("Ingrese una hora valida (7:00 a 22:00)");
            return -1;
        }

        if(minutosSalida < 0 || minutosSalida > 59 ){
            System.out.println("Ingrese minutos validos (entre 0 y 59)");
            return -1;
        }

        int diferenciaHoras = horaSalida - motoACalcularPrecio.getHoraEntrada();
        int diferenciaMinutos = minutosSalida - motoACalcularPrecio.getMinutosEntrada();

        if(diferenciaHoras < 0 ){
            System.out.println("Ingrese una hora de salida valida");
            return -1;

        } else if( diferenciaHoras == 0){

            if(diferenciaMinutos < 0 || diferenciaMinutos == 0){
                System.out.println("Ingrese minutos validos");
                return -1;
            } 
            else{
                return precioACobrarPorMinutos(diferenciaHoras, motoACalcularPrecio.getMinutosEntrada(), minutosSalida);
            }
        } else {
            return precioACobrarPorMinutos(diferenciaHoras, motoACalcularPrecio.getMinutosEntrada(), minutosSalida);
        }
    }

    private int precioACobrarPorMinutos(int difHoras, int minEntrada, int minSalida){

        int difMinutos = minSalida - minEntrada;

        if(difHoras >= 2 ) return 2000;
        else if(difHoras == 0 ){

            if(difMinutos <= 30 ) return 0;
            else if(difMinutos >= 31 && difMinutos <= 60 ) return 800;
        }
        else{

           int minutosPorCobrar = (60 - minEntrada) + minSalida;
           if(minutosPorCobrar <= 30) return 0;
           else if(minutosPorCobrar >= 31 && minutosPorCobrar <= 60 ) return 800;
           else return 2000;
        }
        return -1;
    }

    public void salidaMoto(Moto motoPorSalir){

        if(motoPorSalir.getCilindraje() <= 400){

           for(int i = 0; i < this.puestosBajoCilindraje.length; i++){

                if(puestosBajoCilindraje[i] != null && puestosBajoCilindraje[i].getPlaca().equals(motoPorSalir.getPlaca()) ){
                 puestosBajoCilindraje[i] = null;
                }
           } 
        } 
        else{
            for(int i = 0; i < this.puestosAltoCilindraje.length; i++){
            
                if(puestosAltoCilindraje[i] != null &&puestosAltoCilindraje[i].getPlaca().equals(motoPorSalir.getPlaca()) ){
                 puestosAltoCilindraje[i] = null;
                }
           } 
        }

    }

    public boolean  entradaMoto(Moto motoAgregar, int posicionArreglo){

        if(motoAgregar.getHoraEntrada() > 22 || motoAgregar.getHoraEntrada() < 0 || motoAgregar.getMinutosEntrada() < 0 || motoAgregar.getMinutosEntrada() > 59){
            System.out.println("Ingrese una hora y minutos validos (Hora entre 0 y 22, minutos entre 0 y 59)");
            return false;
        }

        if(motoAgregar.getCilindraje() <= 400){

            if(posicionPermitida(true, posicionArreglo)){
                this.puestosBajoCilindraje[posicionArreglo] = motoAgregar;
                return true;
            }
        } 
        else{
            if(posicionPermitida(false, posicionArreglo)){
                this.puestosAltoCilindraje[posicionArreglo] = motoAgregar;
                return true;
            }
        }
        return false;
    }

    private boolean posicionPermitida(boolean isBajoCilindraje, int posicion){


        if(isBajoCilindraje){

            if(posicion < 0 || posicion >19){
                System.out.println("Ingrese una posicion valida para bajo cilindraje (de 0 a 20)");
                return false;
            }

            if( this.puestosBajoCilindraje[posicion] != null){
                System.out.println("Posicion no disponible, ingrese otro");
                return false;
            } else return true;

        } else{
            if(posicion < 0 || posicion > 9){
                System.out.println("Ingrese una posicion valida para alto cilindraje (de 0 a 10)");
                return false;
            }

            if( this.puestosAltoCilindraje[posicion] != null){
                System.out.println("Posicion no disponible, ingrese otro");
                return false;
            } else return true;
        }
    }

    public Moto[] getPuestosBajoCilindraje() {
        return puestosBajoCilindraje;
    }

    public Moto[] getPuestosAltoCilindraje() {
        return puestosAltoCilindraje;
    }

    public void setPuestosBajoCilindraje(Moto[] puestosBajoCilindraje) {
        this.puestosBajoCilindraje = puestosBajoCilindraje;
    }

    public void setPuestosAltoCilindraje(Moto[] puestosAltoCilindraje) {
        this.puestosAltoCilindraje = puestosAltoCilindraje;
    }
}
