package app;

// import java.util.Scanner;
import java.lang.Math;
import java.util.Scanner;

public class Main {
    /** (47) Конвертация температуры из Цельсия в Фаренгейт */
    public static void task8() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Температуру Цельсия");
        double temperatureCelsius = scanner.nextDouble();

        if (0 <= temperatureCelsius && temperatureCelsius <= 100) {
            double temperatureFahrenheit = ((temperatureCelsius * 9) / 5) + 32;
            System.out.printf("tf = %.4f%n", temperatureFahrenheit);
        } else {
            System.out.println("Введите значения [0,100]");
        }
        scanner.close();
    }

    /** (76) Вычислить значение f(x) */
    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("X= ");
        double x = scanner.nextDouble();
        double a = 1;
        double b = 4;
        double f = Math.sqrt(x + a) + ((Math.pow(x, 2) + b) / x);
        System.out.printf("f(x)= %.4f%n", f);
        scanner.close();
    }

    /** (77) Вычислить значение f(x) по формуле: f(x)=log3(x^2+1)-3,25x */
    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("X= ");
        double x = scanner.nextDouble();
        double f = (Math.log(x * x + 1) / Math.log(3)) - 3.25 * x;
        System.out.printf("F(x)= %.4f%n", f);
        scanner.close();
    }

    /** (81) Найдите расстояние между двумя точками с заданными координатами x1 и x2 на числовой оси: |x2-x1|. */
    public static void task7() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите X1 - ");
        double x1 = scanner.nextDouble();
        System.out.print("Введите X2 - ");
        double x2 = scanner.nextDouble();
        double distance = Math.abs(x2 - x1);
        System.out.printf("Расстояние между X1 и X2 - %.4f%n", distance);
        scanner.close();
    }

    /** (87) Числа Фибоначчи */
    public static void task6() {
        int sum = 0;
        int a = 0, b = 1;
        for (int i = 0; i < 12; i++) {
            sum += a;
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.printf("Число кроликов через год = %d%n", sum);
    }

    /**
     * (61) Два рабочих заработали вместе money рублей.
     * Один работал 2 недели, а другой 4 недели. Сколько денег заработал каждый?
     */
    public static void task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сколько двое рабочих заработали вместе: ");
        double money = scanner.nextDouble();
        
        int week1Working = 2;
        int week2Working = 4;
        
        double earnings1 = (week1Working / (double)(week1Working + week2Working)) * money;
        double earnings2 = (week2Working / (double)(week1Working + week2Working)) * money;
        
        System.out.printf("Первый рабочий заработал: %.4f рублей%n", earnings1);
        System.out.printf("Второй рабочий заработал: %.4f рублей%n", earnings2);
        scanner.close();
    }

    /**
     * (63) Найти расстояние между двумя точками с заданными координатами х1 и х2 на числовой оси |x2-x1|
     */
    public static void task63() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координату x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Введите координату x2: ");
        double x2 = scanner.nextDouble();
        
        double distance = Math.abs(x2 - x1);
        System.out.printf("Расстояние между координатами: %.4f%n", distance);
        scanner.close();
    }

    /**
     * (78) Найти длину образующей l усеченного конуса, если известны радиусы основания r и R, а также высота h
     */
    public static void task5() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Радиус меньшего основания (r): ");
        double r = scanner.nextDouble();
        System.out.print("Радиус большего основания (R): ");
        double R = scanner.nextDouble();
        System.out.print("Высота конуса (h): ");
        double h = scanner.nextDouble();
        
        double coneGeneratrix = Math.sqrt(Math.pow(h, 2) + Math.pow(R - r, 2));
        System.out.printf("Образующая (l): %.4f%n", coneGeneratrix);
        scanner.close();
    }


    public static void main(String[] args) {
        task2();
    }
}
