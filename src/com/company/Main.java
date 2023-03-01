package com.company;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int dato = getDato();
        int[] vector = generarPrimos(dato);
        extracted(dato, vector);
    }

    public static void extracted(int dato, int[] vector) {
        System.out.println("\nVector de primos hasta:" + dato);

        for(int i = 0; i < vector.length; ++i) {
            if (i % 10 == 0) {
                System.out.println();
            }

            System.out.print(vector[i] + "\t");
        }

    }

    public static int getDato() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        int[] vector = new int[dato];
        System.out.println("\nVector inicial hasta :" + dato);

        for(int i = 0; i < vector.length; ++i) {
            if (i % 10 == 0) {
                System.out.println();
            }

            System.out.print(i + 1 + "\t");
        }

        return dato;
    }

    public static int[] generarPrimos(int max) {
        if (max >= 2) {
            int dim = max + 1;
            boolean[] esPrimo = new boolean[dim];
            extracted1(dim, esPrimo);
            esPrimo[0] = esPrimo[1] = false;
            extracted(dim, esPrimo);
            int cuenta = getCuenta(dim, esPrimo);
            int[] primos = getInts(dim, esPrimo, cuenta);
            return primos;
        } else {
            return new int[0];
        }
    }

    public static void extracted1(int dim, boolean[] esPrimo) {
        for(int i = 0; i < dim; ++i) {
            esPrimo[i] = true;
        }

    }

    public static void extracted(int dim, boolean[] esPrimo) {
        for(int i = 2; (double)i < Math.sqrt((double)dim) + 1.0; ++i) {
            if (esPrimo[i]) {
                for(int j = 2 * i; j < dim; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

    }

    public static int getCuenta(int dim, boolean[] esPrimo) {
        int cuenta = 0;

        for(int i = 0; i < dim; ++i) {
            if (esPrimo[i]) {
                ++cuenta;
            }
        }

        return cuenta;
    }

    public static int[] getInts(int dim, boolean[] esPrimo, int cuenta) {
        int[] primos = new int[cuenta];
        int i = 0;

        for(int j = 0; i < dim; ++i) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }

        return primos;
    }
}

	
