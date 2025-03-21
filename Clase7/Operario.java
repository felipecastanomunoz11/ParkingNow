public class Operario extends Trabajdor{

    private double horas;
    public final double SALARIO_BASE = 1000; // constante 

    // constructor --> hereda de la superclase idTrabajdor, nombre, apellido
    public Operario( int idTrabajador, string nombre, string apellido, double horas){
        super(idTrabajador, nombre, apellido);
        this.horas = horas;

    }

    public double pagar(){
        return SALARIO_BASE * horas;
    }

    public string tostring(){
        return "Operario { idTrabajador: " + super.getidTrabajador() + Informacion + I
        "Nombre " + super.getNombre() +
        "Apellido: " + super.getApellido() +
        " Horas Laboradas: " + horas + "}";
         
    }



}