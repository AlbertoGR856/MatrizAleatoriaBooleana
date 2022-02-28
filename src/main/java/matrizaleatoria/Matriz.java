/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrizaleatoria;

import java.util.Random;

/**
 *
 * @author albertogarzon
 */
public class Matriz {

    private boolean[][] matriz;
    private int x;
    private int y;

    //Constructor por defecto que generara de dos numeros aleatorios entre 3-10 y los utilizara
    //para inicializar y dar el tamaño la matriz booleana
    public Matriz() {
        Random aleatorio = new Random();
        this.x = aleatorio.nextInt(100 - 100 + 1) + 100;
        this.y = aleatorio.nextInt(100 - 100 + 1) + 100;
        this.matriz = new boolean[x][y];
    }

    //Método para rellenar las casillas de la matriz de forma aleatoria con true o false
    public void rellenarMatriz() {
        Random aleatorio = new Random();
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                matriz[i][j] = aleatorio.nextBoolean();
            }
        }
    }

    //Método para imprimir la matriz
    public void imprimirMatriz() {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print("" + matriz[i][j] + "\t");
            }

            System.out.println("|");
        }
    }

    //Crear un metodo que dada la matriz, encuentre la primera casilla que sea true 
    //y este rodeada de false en sus vecinas. El metodo devuelve un objeto Coordenada
    public Coordenada trueVecinas(boolean[][] matriz) {

        Coordenada coordenada = null;
        boolean resultado = false;
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                if (matriz[i][j] == true) {

                    resultado = recorrerVecinas(matriz, i, j);

                    if (resultado == true) {

                        coordenada = new Coordenada(i, j);

                    }

                }
            }

        }

        return coordenada;

    }

    public boolean recorrerVecinas(boolean[][] matriz, int i, int j) {

        boolean resultado = true;

        for (int k = i - 1; k <= i + 1; k++) {

            if (k > 0 && k < matriz.length) {

                for (int m = j - 1; m <= j + 1; m++) {

                    if (m >= 0 && m < matriz[k].length) {

                        if (!((i != k && j == m) && matriz[k][m] == true)) {

                            resultado = false;
                            
                            return resultado;
                        }

                    }
                }

            }

        }

        return resultado;
    }

    public boolean[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(boolean[][] matriz) {
        this.matriz = matriz;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Matriz{" + "matriz=" + matriz + '}';
    }

}
