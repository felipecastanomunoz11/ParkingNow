package Principales;

public class Moto {
    private int cilindraje;
    private String placa;
    private int horaEntrada;
    private int minutosEntrada;


    public Moto(){
        
    }

    public Moto(int cilindraje, int horaEntrada, int minutosEntrada, String placa) {
        this.cilindraje = cilindraje;
        this.horaEntrada = horaEntrada;
        this.minutosEntrada = minutosEntrada;
        this.placa = placa;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public String getPlaca() {
        return placa;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public int getMinutosEntrada() {
        return minutosEntrada;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setMinutosEntrada(int minutosEntrada) {
        this.minutosEntrada = minutosEntrada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("cilindraje=").append(cilindraje);
        sb.append(", placa=").append(placa);
        sb.append(", hora ingreso=").append(horaEntrada).append(":").append(minutosEntrada);
        return sb.toString();
    }


}
