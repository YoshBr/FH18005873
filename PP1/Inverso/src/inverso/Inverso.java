/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inverso;

/**
 *
 * @author Bryan Obando
 */
public class Inverso {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        int numero = 12345;
        int inverso = invertir(numero, 0);
        System.out.println(numero + " -> " + inverso);
    }
    
    static int invertir(int n, int acu) {
        if (n == 0) return acu;
        return invertir(n / 10, acu * 10 + (n % 10));
    }
}
