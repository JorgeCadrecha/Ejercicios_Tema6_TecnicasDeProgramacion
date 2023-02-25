import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {
    private static Scanner console = new Scanner(System.in);

    public static final char vacio = '-';
    public static final char barco = 'b';
    public static final char agua = 'a';

    public static void main(String[] args) {

        final int ALTURA = 4;
        final int ANCHURA = 4;
        char[][] tablero = new char[ALTURA][ANCHURA];
        boolean gana;

        iniciarTablero(tablero, ALTURA, ANCHURA);

        do {
            mostrarTablero(tablero, ALTURA, ANCHURA);
            gana = disparar(tablero, ALTURA, ANCHURA);
        } while (!gana);
        console.close();
    }

    public static void iniciarTablero(char[][] tablero, int X, int Y) {
        for (int j = 0; j < X; j++)
            for (int i = 0; i < Y; i++)
                tablero[j][i] = agua;

        Random rand = new Random();
        tablero[rand.nextInt(X)][rand.nextInt(Y)] = barco;
    }

    public static void mostrarTablero(char[][] tablero, int X, int Y) {
        for (int j = 0; j < X; j++) {
            for (int i = 0; i < Y; i++)
                if (tablero[j][i] == barco || tablero[j][i] == agua)
                    System.out.print("?");
                else
                    System.out.print(tablero[j][i]);
            System.out.println();
        }
    }

    public static int introducirEnteroEntreLimites(String message, int min, int max) {
        int valido;
        boolean sePuede;

        System.out.println(message);
        do {
            valido = console.nextInt();
            console.nextLine();
            sePuede = min <= valido && valido <= max;
            if (!sePuede) {
                System.out.println("El valor debe estar comprendido entre " + min + " y " + max + ". Inténtelo de nuevo...");
            }
        } while (!sePuede);
        return valido;
    }


    public static boolean disparar(char[][] tablero, int X, int Y) {
        int x = introducirEnteroEntreLimites("¿Qué columna?", 1, Y) - 1;
        int y = introducirEnteroEntreLimites("¿Qué línea?", 1, X) - 1;
        if (tablero[y][x] != barco) {
            // test del disparo
            tablero[y][x] = vacio;
            System.out.println("Agua");
        } else {
            System.out.println("Tocado y hundido. Bravo, has ganado.");
        }
        return tablero[y][x] == barco;
    }

}