package edd.src.Estructuras;


/**
 * Clase que prueba los métodos caracteristicos de una cola y una pila, además, implementa un
 * método que convierte los número sdecimales a binarios y otro método que simula las torrers de Hanoi.
 * @author Irvin y Sergio.
 */
public class Practica2 {
    
    public static void torresHanoi(int cantidadDiscos,Pila<Integer> origen, Pila<Integer> auxiliar, Pila<Integer> destino){
        // No olvides imprimir cada paso de la solución. 
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
    }
}
