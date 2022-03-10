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
        this.x = aleatorio.nextInt(10 - 3 + 1) + 3;
        this.y = aleatorio.nextInt(10 - 3 + 1) + 3;
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

        boolean resultado = false;
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                if (matriz[i][j] == true) {

                    resultado = recorrerVecinas(matriz, i, j);

                    if (resultado == true) {

                        Coordenada coordenada = new Coordenada(i, j);

                        return coordenada;
                    }

                }
            }

        }

        return null;

    }

    public boolean recorrerVecinas(boolean[][] matriz, int i, int j) {

        int[] minimo = {i - 1, j - 1};
        int[] maximo = {i + 1, j + 1};

        if (minimo[0] < 0) {
            minimo[0]++;
        }

        if (maximo[0] >= matriz.length) {
            maximo[0]--;
        }

        for (int k = minimo[0]; k <= maximo[0]; k++) {
            if (minimo[1] < 0) {
                minimo[1]++;
            }
            if (maximo[1] >= matriz[k].length) {
                maximo[1]--;
            }

            for (int l = minimo[1]; l <= maximo[1]; l++) {
                if (k != i || j != l) {
                    if (matriz[k][l]) {
                        return false;
                    }

                }
            }
        }

        return true;
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
