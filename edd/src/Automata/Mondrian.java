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
        //Inicializo dos matrices en blanco
        for (int i = 0; i < Maux2.length; i++) {
            for (int j = 0; j < Maux2.length; j++) {
                Maux2[i][j] = 2;
                MauxCopia[i][j] = 2;
            }
        }
        // Modifico cada valor de la matriz Maux de forma aleatoria. Para empezar con un estado random de colores
        for (int i = 0; i < Maux2.length; i++) {
            for (int j = 0; j < Maux2.length; j++) {



                if (i == 5 || i == 20) {

                    Maux2[i][j] = 3;
                } else if (j == 4 || j == 19) {
                     Maux2[i][j] = 3;
                } else if (i == 26 && j <= 4 ) {
                    Maux2[i][j] = 3;
                } else if (i == 28 && j >= 19 ) {
                    Maux2[i][j] = 3;
                } else if (i == 32 && (j >= 4 && j <19) ) {
                    Maux2[i][j] = 3;
                } else if ((i > 5 && i < 28) && j == 23 ) {
                    Maux2[i][j] = 3;
                } else if ((i > 28) && j == 25 ) {
                    Maux2[i][j] = 3;
                } else if (i > 5  && i < 20  && j > 4 && j < 19 ) {
                    Maux2[i][j] = 4;
                } else if (i > 20 && i < 26 && j <4 ) {
                    Maux2[i][j] = 4;
                } else if (i > 32 && j > 4 && j < 19 ) {
                    Maux2[i][j] = 4;
                } else if (i > 28 && j > 19 && j < 26 ) {
                    Maux2[i][j] = 4;
                } else if (i > 5 && i < 20 && j > 23) {
                    Maux2[i][j] = 4;
                } else if (i < 5 && j < 4) {
                    Maux2[i][j] = 4;
                } else if (i > 5 && i < 20 && j < 4) {
                    Maux2[i][j] = 4;
                } else if (i > 28 && j > 25) {
                    Maux2[i][j] = 4;
                }
            }
        }
        return Maux2;
    }

    /*
     * Metodo para evolucionar el automata.
     *
     */
    @Override
    public void evoluciona() {

        // Se crea una matriz copia para reemplazar los Valores.
        int[][] CopiaM = new int[Imagen.numCells][Imagen.numCells];

        // Aqui empieza una evolucion.

        //Creamos una pila y una cola para que te diviertas joven Artista.
        Pila<Integer> pila = new Pila<Integer>();
        //Cola<Integer> pila = new Cola<Integer>();



        //For que escanea toda la matriz.
        for (int i=0;i<Maux2.length;i++) {
			for (int j=0;j<Maux2.length;j++)   {

                for (int k=i-1;k<=i+1;k++) {
					for (int l=j-1;l<=j+1;l++) {


                        if (k >= 0 && l >= 0 && k < Maux2.length && l < Maux2.length && (k != i || l !=j)) {
                            if (Maux2[k][l] ==2) {
                                pila.push(4);
                            } else if (Maux2[k][l] == 3) {
                                pila.push(2);
                            } else if (Maux2[k][l] == 4) {
                                pila.push(3);
                            }
                        }

                    }
                }
                if (pila.pop() == 2) {
                    CopiaM[i][j] = 2;
                } else if (pila.pop() == 3){
                    CopiaM[i][j] = 3;
                }  else if (pila.pop() == 4){
                    CopiaM[i][j] = 4;
                }
            }
        }




        for (int i = 0; i < Maux2.length; i++) { // Fors que arreglan la matriz a regresar en la copia.
            for (int j = 0; j < Maux2.length; j++) {
                Maux2[i][j] = CopiaM[i][j];
            }
        }
        // System.out.println("Termine");//SOP que ayuda a saber cuando acaba una
        // evolucion.
    }

    public int[][] getAutomata2() {
        return Maux2;
    }
}
