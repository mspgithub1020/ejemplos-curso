package com.java.interfaces;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Coche unCoche = new Coche();
        Acelerador.run(unCoche);
        Frenador.run(unCoche);
    }
}

interface IAcelerable {
    public void acelerar();
}

interface IFrenable {
    public void frenar();
}

class Coche implements IAcelerable, IFrenable {
    public void acelerar(){
        System.out.println("Acelerando");
    }
    public void frenar(){
        System.out.println("Frenando");
    }
}

class Acelerador {
    public static void run(IAcelerable acel){
        acel.acelerar();
    }
}

class Frenador {
    public static void run(IFrenable fren){
        fren.frenar();
    }
}
