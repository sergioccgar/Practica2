package edd.src.Automata;

import java.util.Random;
import edd.src.Estructuras.*;

public class Mondrian extends AC {

    int[][] Maux2 = new int[Imagen.numCells][Imagen.numCells];
    int[][] MauxCopia = new int[Imagen.numCells][Imagen.numCells];
    int[][] CopiaM = new int[Imagen.numCells][Imagen.numCells];

    /*
     * Metodo que pinta una matriz inicial de Blanco y le da valores aleatorios a las
     * casillas.
     *
     */
    @Override
    public int[][] getAutomata() {
        int aux1;
        //Inicializo dos matrices con colores al azar
        for (int i = 0; i < Maux2.length; i++) {
            for (int j = 0; j < Maux2.length; j++) {
                if (((int)(Math.random() * 6)) == 5) {
                    if (((int)(Math.random() * 6)) == 5) {
                        Maux2[i][j] = (int) (Math.random() * 6);
                        MauxCopia[i][j] = (int) (Math.random() * 6);
                    }
                } else {
                    Maux2[i][j] = (int) (Math.random() * 5);
                    MauxCopia[i][j] = (int) (Math.random() * 5);
                }
            }
        }
        return Maux2;
    }

    /*
     * Metodo para evolucionar el automata.
     *
     */
    // @Override
    // public void evoluciona() {
    //
    //     // Se crea una matriz copia para reemplazar los Valores.
    //     int[][] CopiaM = new int[Imagen.numCells][Imagen.numCells];
    //
    //     // Aqui empieza una evolucion.
    //
    //     //Creamos una pila y una cola para que te diviertas joven Artista.
    //     Pila<Integer> pila = new Pila<Integer>();
    //     //Cola<Integer> pila = new Cola<Integer>();
    //
    //
    //
    //     //For que escanea toda la matriz.
    //     for (int i=0;i<Maux2.length;i++) {
	// 		for (int j=0;j<Maux2.length;j++)   {
    //
    //             for (int k=i-1;k<=i+1;k++) {
	// 				for (int l=j-1;l<=j+1;l++) {
    //
    //
    //                     if (k >= 0 && l >= 0 && k < Maux2.length && l < Maux2.length && (k != i || l !=j)) {
    //                         if (Maux2[k][l] ==2) {
    //                             pila.push(4);
    //                         } else if (Maux2[k][l] == 3) {
    //                             pila.push(2);
    //                         } else if (Maux2[k][l] == 4) {
    //                             pila.push(3);
    //                         }
    //                     }
    //
    //                 }
    //             }
    //             if (pila.pop() == 2) {
    //                 CopiaM[i][j] = 2;
    //             } else if (pila.pop() == 3){
    //                 CopiaM[i][j] = 3;
    //             }  else if (pila.pop() == 4){
    //                 CopiaM[i][j] = 4;
    //             }
    //         }
    //     }
    //
    //
    //
    //
    //     for (int i = 0; i < Maux2.length; i++) { // Fors que arreglan la matriz a regresar en la copia.
    //         for (int j = 0; j < Maux2.length; j++) {
    //             Maux2[i][j] = CopiaM[i][j];
    //         }
    //     }
    //     // System.out.println("Termine");//SOP que ayuda a saber cuando acaba una
    //     // evolucion.
    // }

    /*
     * Metodo para evolucionar el automata.
     *
     */
    @Override
    public void evoluciona() {

        Pila<Integer> pila = new Pila<Integer>();
        Lista<Integer> blackRows = new Lista<Integer>();
        Lista<Integer> blackColumns = new Lista<Integer>();
        int prim = 0;
        //For que escanea toda la matriz.
        for (int i = 0; i < Maux2.length; i++) {
			for (int j = 0; j < Maux2.length; j++) {
                if (MauxCopia[i][j] == 5) {
                    blackRows.add(i);
                    blackColumns.add(j);
                }
            }
        }

        for (int i = 0; i < Maux2.length; i++) {
			for (int j = 0; j < Maux2.length; j++) {
                if (blackRows.contains(i) || blackColumns.contains(j)) {
                    Maux2[i][j] = 5;
                }
            }
        }

        for (int i = 0; i < Maux2.length; i++) { // Fors que arreglan la matriz a regresar en la copia.
            for (int j = 0; j < Maux2.length; j++) {
                Maux2[i][j] = MauxCopia[i][j];
            }
        }
        // System.out.println("Termine");//SOP que ayuda a saber cuando acaba una
        // evolucion.
    }

    public int[][] getAutomata2() {
        return Maux2;
    }
}
