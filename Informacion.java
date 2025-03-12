import Principales.Dinero;
import Principales.Moto;
import Principales.Parqueadero;
import java.util.Scanner;

public class Informacion {

    Dinero dinero = new Dinero();
    Parqueadero parqueadero = new Parqueadero();
    Scanner scanner = new Scanner(System.in); 

    public void ejecutarPrograma(){
        boolean programaEnEjecucion = true;
    
        while(programaEnEjecucion){
            int opcion = menuPrincipal();
    
            if(opcion == 1){
                entradaSalidaMoto();
            }
            else if(opcion == 2){
                System.out.println("El total recaudado es: ".concat(dinero.getDineroTotal() + ""));
                System.out.println("El total recaudado con motos de alto cilindraje es: ".concat(dinero.getDineroAltocilindraje() + ""));
                System.out.println("El total recaudado con motos de bajo cilindraje es: ".concat(dinero.getDineroTotalBajoCilindraje() + ""));
            }
            else if(opcion == 3){
                imprimirPosicionesMotos();
            }
            else {
                System.out.println("Saliendo del programa...");
                programaEnEjecucion = false;
            }
        }
    }
    
    public boolean entradaSalidaMoto(){
        imprimirPosicionesMotos();

        int opcionEntradaSalida = imprimirSiEsEntradaOSalida();

        if(opcionEntradaSalida == 1){
            boolean ingresoCorrecto = ingresarMoto();
            return ingresoCorrecto;
        } else {
            boolean salidaCorrecta = sacarMoto();
            return salidaCorrecta;
        }
    }

    public boolean sacarMoto(){
        System.out.println("");
        System.out.println("================================");
        System.out.println("Seleccionaste sacar una moto");

        System.out.print("Ingrese la hora de salida de la moto (De 0 a 22, no utilizar minutos o caracteres especiales, solo enteros): ");
        int horaSalida = scanner.nextInt();
        scanner.nextLine();
  
        System.out.print("Ingrese el minutos de salida de la moto (De 0 a 59, no utilizar puntos solo enteros): ");
        int minutosSalida = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la placa de la moto");
        String placa = scanner.nextLine();

        Moto motoEncontrada = buscarMotoPorPlaca(placa);

        if(motoEncontrada == null){
            System.out.println("Ingrese una placa valida");
            return false;
        }

        int precioMoto = parqueadero.calcularPrecio(motoEncontrada, horaSalida, minutosSalida);

        if(precioMoto == -1){
            return false;
        }

        if(motoEncontrada.getCilindraje() < 400) dinero.sumarDineroTotalBajoCilindraje(precioMoto);
        else dinero.sumarDineroTotalAltoCilindraje(precioMoto);

        parqueadero.salidaMoto(motoEncontrada);
        System.out.println("Se realiza un cobro de: ".concat(precioMoto + "").concat(" a la moto con placa: ").concat(motoEncontrada.getPlaca()));
        return true;
    }

    public Moto buscarMotoPorPlaca(String placa){

        Moto[] bajoCilindraje = parqueadero.getPuestosBajoCilindraje();
        Moto[] altoCilindraje = parqueadero.getPuestosAltoCilindraje();

        for(int i = 0; i < bajoCilindraje.length; i++){
            if(bajoCilindraje[i] != null && placa.equals(bajoCilindraje[i].getPlaca())){
                return bajoCilindraje[i];
            }
        }

        for(int i = 0; i < altoCilindraje.length; i++){
            if(altoCilindraje[i] != null && placa.equals(altoCilindraje[i].getPlaca())){
                return altoCilindraje[i];
            }
        }

        return null;
    }

    public boolean ingresarMoto(){

        System.out.println("");
        System.out.println("================================");
        System.out.println("Seleccionaste ingresar una moto");

        System.out.print("Ingrese el cilindraje de la moto (numero entero): ");
        int cilindraje = scanner.nextInt();
        scanner.nextLine();
  
        System.out.print("Ingrese la placa de la moto: ");
        String placa = scanner.nextLine();

        System.out.print("Ingrese la hora de entrada de la moto (De 0 a 22, no utilizar minutos o caracteres especiales, solo enteros): ");
        int horaEntrada = scanner.nextInt();
        scanner.nextLine();
  
        System.out.print("Ingrese el minutos de entrada de la moto (De 0 a 59, no utilizar puntos solo enteros): ");
        int minutosEntrada = scanner.nextInt();
        scanner.nextLine();

        Moto motoEntrada = new Moto(cilindraje, horaEntrada, minutosEntrada, placa);

        System.out.println("Ingrese en que posicion desea guardarla (entre 0 y el numero de opciones disponibles por el cilindraje (mayor a 400 es alto cilindraje))");
        int posicionGuardar = scanner.nextInt();
        scanner.nextLine();


        return parqueadero.entradaMoto(motoEntrada, posicionGuardar);
    }

    public int imprimirSiEsEntradaOSalida(){
        System.out.println("");
        System.out.println("Ingrese 1 para dar entrada a una moto");
        System.out.println("Ingrese 2 para dar salida a una moto");

        int opcionSel = scanner.nextInt();

        return opcionSel;
    }

    public void imprimirPosicionesMotos(){

        Moto[] puestosMotosBajoCilindraje = parqueadero.getPuestosBajoCilindraje();
        Moto[] puestosMotosAltoCilindraje = parqueadero.getPuestosAltoCilindraje();

        System.out.println("");
        System.out.println("================================");
        System.out.println("Puestos de motos bajo cilindraje");

        for(int i = 0; i < puestosMotosBajoCilindraje.length; i++){
            
            if(puestosMotosBajoCilindraje[i] == null) System.out.println("Posicion: ".concat(i + "").concat(" - Libre") );
            else  System.out.println("Posicion: ".concat(i + "").concat(" - ").concat(puestosMotosBajoCilindraje[i].toString()) );
        }


        System.out.println("");
        System.out.println("================================");
        System.out.println("Puestos de motos alto cilindraje");
        for(int i = 0; i < puestosMotosAltoCilindraje.length; i++){
            
            if(puestosMotosAltoCilindraje[i] == null) System.out.println("Posicion: ".concat(i + "").concat(" - Libre") );
            else  System.out.println("Posicion: ".concat(i + "").concat(" - ").concat(puestosMotosAltoCilindraje[i].toString()) );
        }
    }

    public int menuPrincipal(){

        for(int i = 0; i < 5; i++){
            System.out.println("");
        }
        System.out.println("======= Menu principal =======");
        System.out.println("Ingrese 1 para dar entrada/salida a una moto");
        System.out.println("Ingrese 2 para ver el dinero recolectado");
        System.out.println("Ingrese 3 para conocer los puestos disponibles");
        System.out.println("Ingrese otro numero entero para salir");
        System.out.println("");
        System.out.print("Ingrese la opcion: ");
        int opcionMenu = scanner.nextInt();

        return opcionMenu;
    }
}
