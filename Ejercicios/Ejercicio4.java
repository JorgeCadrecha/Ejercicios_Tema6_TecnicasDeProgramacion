import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        final int num_Ovejas_Para_Contar = 3;
        final int TAMANIO = num_Ovejas_Para_Contar * 2 + 1;
        char[][] tablero = new char[TAMANIO][TAMANIO];
        boolean victoria;
        inicializarTablero(tablero);
        mostrarTablero(tablero);
        do {
            jugarUnCoup(tablero);
            mostrarTablero(tablero);
            victoria = gana(tablero);
        } while (!victoria && !bloque(tablero));
        if (victoria) {
            System.out.println("Bravo ! ha tenido éxito !!!");
        } else {
            System.out.println("Ha perdido ! Estás bloqueado...");
        }
    }

    public static void inicializarTablero(char[][] tablero) {
        final int num_Ovejas_Para_Contar = 3;
        final int TAMANIO = num_Ovejas_Para_Contar * 2 + 1;
        for (int i = 0; i < num_Ovejas_Para_Contar; i++) {
            tablero[i][0] = '>';
        }
        tablero[num_Ovejas_Para_Contar][0] = ' ';
        for (int i = num_Ovejas_Para_Contar + 1; i < TAMANIO; i++) {
            tablero[i][0] = '<';
        }
    }

    public static void mostrarTablero(char[][] tablero) {
        final int num_Ovejas_Para_Contar = 3;
        final int TAMANIO = num_Ovejas_Para_Contar * 2 + 1;
        for (int i = 1; i <= TAMANIO; i++) {
            System.out.print("    " + i  + "   ");
        }
        System.out.println();
        for (int i = 0; i < TAMANIO; i++) {
            System.out.print("|");
            for (int j = 0; j < TAMANIO; j++) {
                System.out.print(tablero[i][j]);
            }
        }
        System.out.println("|");

    }


    public static boolean gana(char[][] tablero) {
        final int num_Ovejas_Para_Contar = 3;
        boolean inicioOk = true;
        int i = 0;
        while (inicioOk && i < num_Ovejas_Para_Contar) {
            inicioOk = tablero[i][0] == '<';
            i++;
        }
        return inicioOk && tablero[num_Ovejas_Para_Contar][0] == ' ';
    }

    public static boolean bloque(char[][] tablero) {
        final int num_Ovejas_Para_Contar = 3;
        final int TAMANIO = num_Ovejas_Para_Contar * 2 + 1;
        int posCB = 0;
        while (tablero[posCB][0] != ' ') {
            posCB++;
        }
        return !(posCB > 0 && tablero[posCB - 1][0] == '>'
                || posCB > 1 && tablero[posCB - 2][0] == '>' && tablero[posCB - 1][0] == '<'
                || posCB < TAMANIO - 1 && tablero[posCB + 1][0] == '<'
                || posCB < TAMANIO - 2 && tablero[posCB + 2][0] == '<' && tablero[posCB + 1][0] == '>');
    }

    public static void jugarUnCoup(char[][] tablero) {
        final int num_Ovejas_Para_Contar = 3;
        final int TAMANIO = num_Ovejas_Para_Contar * 2 + 1;
        int pos = pedirPosicion() - 1;
        if (pos < 0 || pos > TAMANIO - 1) {
            System.out.println("Posición fuera del tablero de juego !");
        } else {
            if (tablero[pos][0] == ' ') {
                System.out.println("Celda vacía, movimiento imposible !");
            } else {
                if (tablero[pos][0] == '>') {
                    if (pos < TAMANIO - 1 && tablero[pos + 1][0] == ' ') {
                        tablero[pos][0] = ' ';
                        tablero[pos + 1][0] = '>';
                    } else {
                        if (pos < TAMANIO - 2 && tablero[pos + 1][0] == '<' && tablero[pos + 2][0] == ' ') {
                            tablero[pos][0] = ' ';
                            tablero[pos + 2][0] = '>';
                        } else {
                            System.out.println("movimiento no permitido");
                        }
                    }
                } else {
                    if (pos > 0 && tablero[pos - 1][0] == ' ') {
                        tablero[pos][0] = ' ';
                        tablero[pos - 1][0] = '<';
                    } else {
                        if (pos > 1 && tablero[pos - 1][0] == '>' && tablero[pos - 2][0] == ' ') {
                            tablero[pos][0] = ' ';
                            tablero[pos - 2][0] = '<';
                        } else {
                            System.out.println("movimiento no permitido");
                        }
                    }
                }
            }
        }
    }

    private static int pedirPosicion() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qué peón quiere mover? ");
        return sc.nextInt();
    }

}