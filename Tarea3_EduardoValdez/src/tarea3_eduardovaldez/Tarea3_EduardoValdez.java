/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea3_eduardovaldez;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author guali
 */
public class Tarea3_EduardoValdez {

    /**
     * @param args the command line arguments
     */
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        char resp = 's';
        while (resp == 's') {
            System.out.print("**********Menu**********\n1. Veamos Si Podemos Formar La Palabra\n2. Numeros primero\n3. Ordenar Alfabeticamente\n4. Codificar Cadenas\n5. Jugando Con Arreglos\n6. Salir\nIngrese una opcion: ");
            int opcion = leer.nextInt();
            System.out.println();
            switch (opcion) {
                case 1:
                    System.out.println("*****Veamos Si Podemos Formar La Palabra*****");
                    Formarpalabras();

                    break;
                case 2:
                    System.out.println("*****Numeros Primero*****");
                    Numerosprimero();
                    break;
                case 3:
                    System.out.println("*****Ordenar Alfabeticamente*****");
                    System.out.print("Ingrese cadena 1: ");
                    leer.nextLine();
                    String cad1 = leer.nextLine();
                    System.out.println("Valor Entero Retornado: " + Ordenalfa(cad1));
                    System.out.println();

                    break;
                case 4:
                    System.out.println("*****Codificar Cadenas*****");
                    System.out.print("Ingrese cadena 1: ");
                    leer.nextLine();
                    String cad = leer.nextLine();
                    System.out.println(codificar(cad));
                    System.out.println();
                    break;
                case 5:
                    System.out.println("*****Jugando Con Arreglos*****");
                    int [] arreglo = new int [10];
                    int[] arraylleno = llenararreglo (arreglo);
                    System.out.print("Arreglo impreso: ");
                    imprimir(arraylleno);
                    break;
                case 6:
                    System.out.println("Salio del Programa");
                    resp = 'n';
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }//fin del switch principal

        }//fin del while      
    }//fin del main

    public static void Formarpalabras() {
        System.out.print("Ingrese cadena 1: ");
        leer.nextLine();
        String cad1 = leer.nextLine();
        System.out.print("Ingrese cadena 2: ");
        String cad2 = leer.nextLine();
        String cadenacorta;
        String cadenalarga;
        if (cad1.length() > cad2.length()) {
            cadenacorta = cad2.toLowerCase();
            cadenalarga = cad1.toLowerCase();
        } else {
            cadenacorta = cad1.toLowerCase();
            cadenalarga = cad2.toLowerCase();
        }
        int cont = 0;

        for (int i = 0; i < cadenacorta.length(); i++) {
            int limite = cadenalarga.length();
            for (int j = 0; j < limite; j++) {
                if (cadenacorta.charAt(i) == cadenalarga.charAt(j)) {
                    cont = cont + 1;
                    limite = j;
                }
            }

        }
        if (cont == cadenacorta.length()) {
            System.out.println("Si se puede armar " + cadenacorta);
        } else {
            System.out.println("No se puede armar " + cadenacorta);
        }
        System.out.println();

    }//fin de Formarpalabras

    public static void Numerosprimero() {
        System.out.print("Ingrese una cadena que contenga letras y numeros: ");
        leer.nextLine();
        String cad1 = leer.nextLine();
        String numeros = "";
        String letras = "";
        for (int i = 0; i < cad1.length(); i++) {
            if (cad1.charAt(i) > 47 && cad1.charAt(i) < 58) {
                numeros += cad1.charAt(i);
            } else {
                letras += cad1.charAt(i);
            }

        }
        String cadnueva = numeros + letras;
        System.out.println("Cadena ordenada: " + cadnueva);
        System.out.println();

    }//fin de numerosprimero

    public static int Ordenalfa(String cadena) {
        int entero = 0;
        String cadenaordenada = "";
        String cad = cadena.toLowerCase();
        int cont = 97;
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < cad.length(); j++) {
                if (cad.charAt(j) == cont) {
                    cadenaordenada += cad.charAt(j);
                }
            }
            cont = cont + 1;

        }
        System.out.println("Cadena Ordenada: " + cadenaordenada);

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) > 47 && cadena.charAt(i) < 58) {
                entero = entero + 1;
            }

        }
        return entero;
    }// fin de ordenalfa

    public static String codificar(String cadena) {
        String cadcodificada = "";
        String cad = cadena.toLowerCase();
        for (int i = 0; i < cad.length(); i++) {
            if(cad.charAt(i)!=32 && i!=0 && cad.charAt(i-1) != ' '){
               cadcodificada += "-"; 
            }
            if (cad.charAt(i) > 96 && cad.charAt(i) < 123) {
                int num = cad.charAt(i) - 96;
               
                    cadcodificada += num;
                

            } else if (cad.charAt(i) > 47 && cad.charAt(i) < 58) {
                int num2 = cad.charAt(i) + 16;
      
                    cadcodificada += (char) num2;
                

            } else if (cad.charAt(i) == 32) {
                cadcodificada += " ";
            }

        }
        return cadcodificada;
    }//fin de codificar
    
    public static int [] llenararreglo (int[] array){
        int[] arreglolleno = new int [10];
        for(int i = 0; i <array.length;i++){
            System.out.println("Ingrese valor de la posicion ["+i+"]: ");
            int num = leer.nextInt();
            arreglolleno[i]=num;
        }
        return arreglolleno;
    }//fin llenararreglo
    
     public static void imprimir(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");

        }
        System.out.println();
    }// fin imprimir

}//fin de la clase
