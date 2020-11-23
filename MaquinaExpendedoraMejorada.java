public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Contador de billetes
    private int contadorBilletesVendidos;
    // escoge si permite premios o no
    private boolean maquinaConPremio;
    //establece un número máximo de billetes que se pueden sacar
    private int maxBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada
    (int precioDelBillete, String origen, String destino, boolean daPremio, int maximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        contadorBilletesVendidos = 0;
        maquinaConPremio = daPremio;
        maxBilletes = maximoBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (contadorBilletesVendidos <= maxBilletes ){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }       
        }
        else{
            System.out.println ("Ya se han sacado el máximo de billetes permitidos, " + maxBilletes);
        }
    }
    
    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {

        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (contadorBilletesVendidos <= maxBilletes ){
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");        
                System.out.println("");
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                // Cuenta el numero de billetes que se van vendiendo
                contadorBilletesVendidos ++;  

                if (maquinaConPremio == true && contadorBilletesVendidos % 3 == 0){
                    System.out.println("Tienes un descuento de " +
                        (precioBillete*0.1) + "€ para compras en el comercio que quieras");
                }
    
            }
            else {
                System.out.println("No hay subiciente dinero. Faltan " + cantidadDeDineroQueFalta);
            }
        }
        else{
            System.out.println ("Ya se han sacado el máximo de billetes permitidos, " + maxBilletes);
        }
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 

    public int vaciarDineroDeLaMaquina (){
        int dineroADevolver = -1;
        if (balanceClienteActual == 0){
            dineroADevolver = totalDineroAcumulado;
            totalDineroAcumulado = 0;    
        }
        else{
            System.out.println
            ("Termine la gestión en curso antes de vaciar la máquina");
        }
        return dineroADevolver;
    }

    public int getNumeroBilletesVendidos() {
        return contadorBilletesVendidos;
    }

    public void imprimeNumeroBilletesVendidos() {
        System.out.println
        ("La máquina ha vendido "
            + contadorBilletesVendidos + " billetes");
    }
}
