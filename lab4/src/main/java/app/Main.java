package app;

// import java.util.Scanner;
import java.lang.Math;

public class Main {
    // private static Scanner scanner = new Scanner(System.in);

    /** (47) Конвертация температуры из Цельсия в Фаренгейт */
    public static String task8(double temperatureCelsius) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Введите Температуру Цельсия");
        // double temperatureCelsius = scanner.nextDouble();

        if (0 <= temperatureCelsius && temperatureCelsius <= 100) {
            double temperatureFahrenheit = ((temperatureCelsius * 9) / 5) + 32;
            // System.out.printf("tf = %.4f%n", temperatureFahrenheit);
            return String.format("tf = %.4f%n", temperatureFahrenheit);
        } else {
            // System.out.println("Введите значения [0,100]");
            return "Введите значения [0,100]";
        }
        // scanner.close();
    }

    /** (76) Вычислить значение f(x) */
    public static String task2(double x) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("X= ");
        // double x = scanner.nextDouble();
        double a = 1;
        double b = 4;
        double f = Math.sqrt(x + a) + ((Math.pow(x, 2) + b) / x);
        // System.out.printf("f(x)= %.4f%n", f);
        return String.format("f(x)= %.4f%n", f);
        // scanner.close();
    }

    /** (77) Вычислить значение f(x) по формуле: f(x)=log3(x^2+1)-3,25x */
    public static String task3(double x) {
        // System.out.print("X= ");
        // double x = scanner.nextDouble();
        double f = (Math.log(x * x + 1) / Math.log(3)) - 3.25 * x;
        System.out.printf("F(x)= %.4f%n", f);
        return String.format("F(x)= %.4f%n", f);
        // scanner.close();
    }

    /** (81) Найдите расстояние между двумя точками с заданными координатами x1 и x2 на числовой оси: |x2-x1|. */
    public static String task7(double x1, double x2) {
        // System.out.print("Введите X1 - ");
        // double x1 = scanner.nextDouble();
        // System.out.print("Введите X2 - ");
        // double x2 = scanner.nextDouble();
        double distance = Math.abs(x2 - x1);
        // System.out.printf("Расстояние между X1 и X2 - %.4f%n", distance);
        // scanner.close();
        return String.format("Расстояние между X1 и X2 - %.4f%n", distance);
    }

    /** (87) Числа Фибоначчи */
    public static String task6() {
        int sum = 0;
        int a = 0, b = 1;
        for (int i = 0; i < 12; i++) {
            sum += a;
            int next = a + b;
            a = b;
            b = next;
        }
        // System.out.printf("Число кроликов через год = %d%n", sum);
        return String.format("Число кроликов через год = %d%n", sum);
    }

    public static void main(String[] args) {
        // Пример вызова методов
        // task8();
        // task2();
        // task3();
        // task7();
        // task6();
    }
}
