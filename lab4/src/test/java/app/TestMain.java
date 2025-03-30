package app;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import app.Main;

public class TestMain {

    // Тесты для аналог task8
    @Test
    public void testTask8_ValidInput() {
        String result = Main.task8(50);
        assertEquals(result, "tf = 122.0000");
    }

    @Test
    public void testTask8_InvalidInputLow() {
        String result = Main.task8(-10);
        assertEquals(result, "Введите значения [0,100]");
    }

    // Тесты для task2
    @Test
    public void testTask2_PositiveX() {
        double result = Main.task2(2);
        assertEquals(result, 5.732050807568877, 0.0001);
    }

    @Test
    public void testTask2_NegativeX() {
        double result = Main.task2(-1);
        assertEquals(result, -5.0, 0.0001);
    }

    // Тесты для аналог task3
    @Test
    public void testTask3_PositiveX() {
        double result = Main.task3(1);
        assertEquals(result, -3.072187, 0.0001);
    }

    @Test
    public void testTask3_ZeroX() {
        double result = Main.task3(0);
        assertEquals(result, 0.0, 0.0001);
    }

    // Тесты для аналог task7
    @Test
    public void testTask7_Positive() {
        double result = Main.task7(3, 7);
        assertEquals(result, 4.0, 0.0001);
    }

    @Test
    public void testTask7_Negative() {
        double result = Main.task7(-2, -5);
        assertEquals(result, 3.0, 0.0001);
    }

    // Тест для task6
    @Test
    public void testTask6() {
        int result = Main.task6();
        assertEquals(result, 376);
    }
}