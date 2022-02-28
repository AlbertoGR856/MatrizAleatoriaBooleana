/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrizaleatoria;

/**
 *
 * @author albertogarzon
 */
public class PruebaMatriz {
    
    public static void main(String[] args) {
        
        Matriz matriz1 = new Matriz();
        
        matriz1.rellenarMatriz();
        
        matriz1.imprimirMatriz();
        
        System.out.println("-------------");
        
        System.out.println(matriz1.trueVecinas(matriz1.getMatriz())); 
        
        
    }
    
}
