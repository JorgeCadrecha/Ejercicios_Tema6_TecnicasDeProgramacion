
import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] tablero = new char[10][40];
        inicializarTablero(tablero);
        mostrarTablero(tablero);
        int opcion = 0;
        do {
            System.out.println("1. Dibujar un carácter");
            System.out.println("2. Dibujar un rectángulo");
            System.out.println("3. Cambiar el color (de carácter)");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    dibujarCaracter(tablero);
                    break;
                case 2:
                    dibujarRectangulo(tablero);
                    break;
                case 3:
                    cambiarColor(tablero);
                    break;
                case 4:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opcion != 4);
    }

    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }

    public static void dibujarCaracter(char[][] tablero) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la coordenada x");
        int x = sc.nextInt();
        System.out.println("Ingrese la coordenada y");
        int y = sc.nextInt();
        System.out.println("Ingrese el caracter");
        char caracter = sc.next().charAt(0);
        tablero[x][y] = caracter;
        mostrarTablero(tablero);
    }

    public static void dibujarRectangulo(char[][] tablero) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la coordenada x");
        int x  = sc.nextInt();
        System.out.println("Ingrese la coordenada y");
        int y = sc.nextInt();
        System.out.println("Ingrese el ancho");
        int ancho = sc.nextInt();
        System.out.println("Ingrese el alto");
        int alto = sc.nextInt();
        System.out.println("Ingrese el caracter");
        char caracter = sc.next().charAt(0);
        for (int i = x; i < x + alto; i++) {
            for (int j = y; j < y + ancho; j++) {
                tablero[i][j] = caracter;
            }
        }
        mostrarTablero(tablero);
    }

    public static void cambiarColor(char[][] tablero) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el caracter");
        char caracter = sc.next().charAt(0);
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != ' ') {
                    tablero[i][j] = caracter;
                }
            }
        }
        mostrarTablero(tablero);
    }
}
