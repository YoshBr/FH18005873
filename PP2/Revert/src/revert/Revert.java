/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package revert;

import java.io.*;
import java.util.Stack;

/**
 *
 * @author Bryan Obando
 */
public class Revert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<Character> pila = new Stack<>();
        
        try {
            // Leemos el archivo de entrada
            FileReader reader = new FileReader("input.txt");
            int caracter;
            
            // Leemos caracter por caracter y los agregamos a la pila
            while ((caracter = reader.read()) != -1) {
                pila.push((char) caracter);
            }
            reader.close();
            
            // Creamos el archivo de salida
            FileWriter writer = new FileWriter("output.txt");
            
            // Vaciamos la pila (y salen en orden inverso) y escribe
            while (!pila.isEmpty()) {
                writer.write(pila.pop());
            }
            writer.close();
            
            System.out.println("Archivo invertido creado exitosamente!");
            
        } catch (IOException e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
            // Si el archivo no existe, creamos uno de ejemplo
            try {
                FileWriter ejemplo = new FileWriter("input.txt");
                ejemplo.write(".txet emos \si sihT");
                ejemplo.close();
                System.out.println("Se creo input.txt de ejemplo. Ejecuta de nuevo.");
            } catch (IOException ex) {
                System.out.println("No se pudo crear el archivo de ejemplo.");
            }
        }
    }
}