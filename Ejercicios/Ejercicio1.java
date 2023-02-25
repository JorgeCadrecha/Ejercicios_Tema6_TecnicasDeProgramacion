import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer numero");
        double num1 = sc.nextDouble();
        System.out.println("Ingrese el segundo numero");
        double num2 = sc.nextDouble();
        System.out.println("El mayor es: " + mayor(num1, num2));

        System.out.println("'0' si los valores son iguales, '1' si el primer valor es el mayor y '-1'si el segundo es mayor: " + mayor2(num1,num2));
    }
    public static double mayor(double num1, double num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }

    public static String mayor2(double num1, double num2) {
        if (num1 > num2) {
            return "1";
        } else if (num1 == num2) {
            return "0";
        } else {
            return "-1";
        }
    }
}