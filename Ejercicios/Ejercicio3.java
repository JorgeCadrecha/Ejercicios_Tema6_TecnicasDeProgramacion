
import java.util.Random;

public class Ejercicio3 {

    public static void main(String[] args) {
        int[] tabla = crearTabla(10, 0, 100);
        int mayor = mayor(tabla);
        System.out.println("El mayor valor de la tabla es: " + mayor);
    }

    public static int[] crearTabla(int tam, int min, int max) {
        int[] tabla = new int[tam];
        Random r = new Random();
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = r.nextInt(max - min + 1) + min;
        }
        return tabla;
    }

    public static int mayor(int[] tabla) {
        int mayor = tabla[0];
        for (int i = 1; i < tabla.length; i++) {
            if (tabla[i] > mayor) {
                mayor = tabla[i];
            }
        }
        return mayor;
    }
}