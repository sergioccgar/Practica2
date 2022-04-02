package edd.src.Estructuras;

import java.util.Scanner;
/**
 * Clase que prueba los métodos caracteristicos de una cola y una pila, además, implementa un
 * método que convierte los número sdecimales a binarios y otro método que simula las torrers de Hanoi.
 * @author Irvin y Sergio.
 */
public class Practica2 {

    /**
     * Método que imprime un estado del paso actual de las Torres de Hanoi.
     */
    public static void impTorres(int pasoActual, Pila<Integer> origen, Pila<Integer> auxiliar, Pila<Integer> destino){
        System.out.println("####################################");
        System.out.println("El paso actual es el " + pasoActual + "°");
        System.out.println(origen.toString() + " <- Torre de origen");
        System.out.println(auxiliar.toString() +  " <- Torre auxiliar");
        System.out.println(destino.toString() + " <- Torre de destino\n");
    }

    /**
     * Método que simula un juego con Torres de Hanoi.
     *
     * @param cantidadDiscos Es el número de discos con el que comenzamos el juego.
     * @param origen Representa a la varilla donde comienzan todos los discos.
     * @param auxiliar Representa a la varilla del centro que nos sirve para nuestros movimientos intermedios.
     * @param destino Representa a la varilla donde deben terminar todos los discos.
     *
     */
    public static void torresHanoi(int cantidadDiscos,Pila<Integer> origen, Pila<Integer> auxiliar, Pila<Integer> destino){
        // Agregamos el número de discos a la "varilla" de origen.
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("¡Bienvenidx a la Torre de Hanoi! Comencemos:");
        for (int i = cantidadDiscos; i >= 1; i--){
            origen.push(i);
        }
        // Calculamos el número de movimientos:
        int numMovimientos = (int)(Math.pow(2,cantidadDiscos)-1);
        System.out.println("El número de pasos a ejecutar es: " + numMovimientos);
        // Revisamos la paridad de cantidadDiscos para ver cómo acomodar las "varillas" auxiliar y de destino.
        boolean t = (cantidadDiscos%2==0);
        System.out.println("El estado inicial de las torres es:");
        impTorres(0,origen,auxiliar,destino);
        // Dependiendo de el booleano t, hacemos uno u otro tipo de los siguientes movimientos:
        if (t){
            for (int i = 1; i <= numMovimientos; i++) {
                if (i%3==1){
                    if (origen.isEmpty()){
                        origen.push(auxiliar.pop());
                    } else if (auxiliar.isEmpty()) {
                        auxiliar.push(origen.pop());
                    } else if (origen.peek() < auxiliar.peek()){
                        auxiliar.push(origen.pop());
                    } else origen.push(auxiliar.pop());
                }
                if (i%3==2){
                    if (origen.isEmpty()){
                        origen.push(destino.pop());
                    } else if (destino.isEmpty()) {
                        destino.push(origen.pop());
                    } else if (origen.peek() < destino.peek()){
                        destino.push(origen.pop());
                    } else origen.push(destino.pop());
                }
                if (i%3==0){
                    if (destino.isEmpty()){
                        destino.push(auxiliar.pop());
                    } else if (auxiliar.isEmpty()) {
                        auxiliar.push(destino.pop());
                    } else if (destino.peek() < auxiliar.peek()){
                        auxiliar.push(destino.pop());
                    } else destino.push(auxiliar.pop());
                }
                impTorres(i,origen,auxiliar,destino);
            }
        } else {
            for (int i = 1; i <= numMovimientos; i++) {
                if (i%3==1){
                    if (origen.isEmpty()){
                        origen.push(destino.pop());
                    } else if (destino.isEmpty()) {
                        destino.push(origen.pop());
                    } else if (origen.peek() < destino.peek()){
                        destino.push(origen.pop());
                    } else origen.push(destino.pop());
                }
                if (i%3==2){
                    if (origen.isEmpty()){
                        origen.push(auxiliar.pop());
                    } else if (auxiliar.isEmpty()) {
                        auxiliar.push(origen.pop());
                    } else if (origen.peek() < auxiliar.peek()){
                        auxiliar.push(origen.pop());
                    } else origen.push(auxiliar.pop());
                }
                if (i%3==0){
                    if (auxiliar.isEmpty()){
                        auxiliar.push(destino.pop());
                    } else if (destino.isEmpty()) {
                        destino.push(auxiliar.pop());
                    } else if (auxiliar.peek() < destino.peek()){
                        destino.push(auxiliar.pop());
                    } else auxiliar.push(destino.pop());
                }
                impTorres(i,origen,auxiliar,destino);
            }
        }
        System.out.println("¡Terminamos!\n");

    }


    /**
     * Método que imprime los número binarios desde 0 hasta N usando una cola.
     *
     * @param N Es el número limite hasta al que se hace la conversión.
     */
    public static void binarioColas(int N){
        Cola<String> cola = new Cola<String>();
        String cero = "0", uno = "1", auxPares = "", auxImpares;

        System.out.println("\nConversión de números décimales a binarios desde 0 hasta " + N + ".");

        for (int i = 0; i <= N; i++) {
            if (i%2 == 0) { // Indica si el número decimal es par para solo concatenar un cero.
                if (i == 0) { // Incerta el cero inicial.
                    cola.push(cero);
                    System.out.println(i + " = " + cola);
                    cola.pop();
                } else {
                    auxPares = cola.pop();
                    System.out.println(i + " = " + auxPares + cero);
                    cola.push(auxPares + cero);
                }
            } else { // Si el número no es par concatena un uno.
                if (i == 1) { // Incerta el uno inical.
                    cola.push(uno);
                    System.out.println(i + " = " + cola);
                } else {
                    auxImpares = auxPares + uno;
                    System.out.println(i + " = " + auxImpares);
                    cola.push(auxImpares);
                }
            }
        }
    }

    public static void main(String[] args) {

        /*
        * Prueba para el método push de cola.
        */
        Cola<Integer> colaPush = new Cola<Integer>();
        for(int i = 1; i <= 5; i++) {
            colaPush.push(i);
            System.out.println("Se agrega " + i + " a la cola: " + colaPush);
        }

        Cola<Integer> cola = new Cola<Integer>();

        /*
        * Preuba para el método clone.
        */
        for (int i = 0; i < 10; i++) {
            cola.push(i);
        }
        Cola<Integer> colaClonada = cola.clone();

        if (!cola.equals(colaClonada)) {
            System.out.println("Las colas no son iguales.");
        }

        Cola<Integer> cola2 = new Cola<Integer>();

        /*
        * Prueba para el método push.
        */
        for (int i = 1; i < 10; i++) {
            cola2.push(i);
        }

        cola.pop();

        if (!cola.equals(cola2)) {
            System.out.println("El método pop de cola no funciona.");
        }

        binarioColas(10);

        /*
        * Prueba para el método push de pila.
        */
        Pila<Integer> pila = new Pila<Integer>();
        for(int i = 1; i <= 5; i++) {
            pila.push(i);
            System.out.println("Se agrega " + i + " a la pila " + pila);
            System.out.println(pila.peek());
        }

        /*
        * Prueba para el método clone de pila.
        */
        Pila<Integer> pilaClone = pila.clone();
        if (!pila.equals(pilaClone)) {
            System.out.println("Las pilas no son iguales.");
        }

        Pila<Integer> pila2 = new Pila<Integer>();
        Pila<Integer> pila3 = new Pila<Integer>();

        /*
        * Prueba para el método push de pila.
        */
        for (int i = 0; i <= 5; i++) {
            pila3.push(i);
        }

        for (int i = 0; i < 5; i++) {
            pila2.push(i);
        }

        pila3.pop();

        if (!pila3.equals(pila2)) {
            System.out.println("El método pop de pila no funciona.");
        }

        /**
         * Revisa que Torres de Hanoi funcione
         */
        Pila<Integer> a = new Pila<Integer>();
        Pila<Integer> b = new Pila<Integer>();
        Pila<Integer> c = new Pila<Integer>();
        torresHanoi(1,a,b,c);
        a.empty();
        b.empty();
        c.empty();
        torresHanoi(2,a,b,c);
        a.empty();
        b.empty();
        c.empty();
        torresHanoi(3,a,b,c);
        a.empty();
        b.empty();
        c.empty();
        torresHanoi(4,a,b,c);
        a.empty();
        b.empty();
        c.empty();
        torresHanoi(5,a,b,c);
        a.empty();
        b.empty();
        c.empty();
        Scanner scn = new Scanner(System.in);
        System.out.println("¡Es tu turno! Dame un número y te daré la simulación de un juego de Torres de Hanoi con el número de discos que ingreses.");
        int n = Integer.parseInt(scn.nextLine());
        torresHanoi(n,a,b,c);
        System.out.println("¡Hasta entonceees!");

    }
}
