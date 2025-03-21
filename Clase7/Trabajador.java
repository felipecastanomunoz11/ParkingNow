public class trabajador {

    // Atributos
    private int idTrabajo;
    private string nombre;
    private string apellido;

    // Costructor 
    public trabajador(int idTrabajo,string nombre, string apellido){
        this.idTrabajo = idTrabajo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // metodos getter 
    public string getNombre(){
        return nombre;
    }

    public int getidTrabajador(){
        return idTrabajo;
    }

    public  double pagar(){
            return 0.0;
    }

    public string tostring(){
        return "Trabajdor { idTrabajador:" + idTrabajador +
                 "Nombre: " + nombre + 
                 " Apellido: " + apellido + "}";
    }
}