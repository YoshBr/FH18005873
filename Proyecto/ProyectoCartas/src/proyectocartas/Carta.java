/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocartas;

/**
 *
 * @author Bryan Obando
 */
public class Carta {
    private String palo;
    private String valor;
    private int valorNumerico;
    
    public Carta(String palo, String valor){
        this.palo = palo;
        this.valor = valor;
        this.valorNumerico = calcularValorNumerico(valor);
    }
    
    //Calculamos el valor numerico de las cartas
    private int calcularValorNumerico(String valor){
        switch(valor){
            case "As" : return 1;
            case "J" : return 11;
            case "Q" : return 12;
            case "K" : return 13;
            default : return Integer.parseInt(valor);
        }
    }    
    
    public String getPalo(){
        return palo;
    }
    
    public String getValor(){
        return valor;
    }
        
    public int getValorNumerico(){
        return valorNumerico;
    }
    
    @Override
    public String toString(){
        return valor + " de " + palo;
    }
    
    public static Carta[] crearBaraja (){
        String[] palos = {"Corazones", "Diamantes", "Treboles", "Picas"};
        String[] valores = {"As","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        
        Carta[] baraja = new Carta[52];
        int contador = 0;
        
        for (String palo : palos){
            for (String valor : valores){
                baraja[contador] = new Carta(palo, valor);
                contador++;
            }
        }
        return baraja;
    }
    
    public static void main (String[] args){
        System.out.println("=== PRUEBA CLASE CARTA - AVANCE 1 ===");
        
        //Probamos carta individual
        Carta miCarta = new Carta("Corazones", "As");
        System.out.println("Carta individual: " + miCarta);
        System.out.println("valor numerico: " + miCarta.getValorNumerico());
        
        //Probamos la baraja completa
        Carta[] baraja = crearBaraja();
        System.out.println("\nTotal de cartas en baraja: " + baraja.length);
        
        //Mostramos las primeras 5 cartas
        System.out.println("\nPrimeras 5 cartas:");
        for (int i = 0; i < 5; i++){
            System.out.println((i+1) + " . " + baraja[i] + "(valor: " + baraja[i].getValorNumerico() + ")");
        }
        
        //Verificamos que hayan 52 cartas
        System.out.println("\n=== Verificacion ===");
        System.out.println("Baraja completa? " + (baraja.length == 52 ? "Si" : "No"));
        System.out.println("Clase carta realizada");
    }
}
