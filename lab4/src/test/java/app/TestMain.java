package app;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TestMain {

    // Тесты для аналог task8
    @Test
    public void testTask8_ValidInput() {
        String result = Main.task8(50).strip();
        assertEquals(result, "tf = 122,0000");
    }

    @Test
    public void testTask8_InvalidInputLow() {
        String result = Main.task8(-10).strip();
        assertEquals(result, "Введите значения [0,100]");
    }

    // Тесты для task2
    @Test
    public void testTask2_PositiveX() {
        String result = Main.task2(2).strip();
        assertEquals(result, "f(x)= 5,7321");
    }

    @Test
    public void testTask2_NegativeX() {
        String result = Main.task2(-1).strip();
        assertEquals(result, "f(x)= -5,0000");
    }

    // Тесты для аналог task3
    @Test
    public void testTask3_PositiveX() {
        String result = Main.task3(1).strip();
        assertEquals(result, "F(x)= -2,6191");
    }

    @Test
    public void testTask3_ZeroX() {
        String result = Main.task3(0).strip();
        assertEquals(result, "F(x)= 0,0000");
    }

    // Тесты для аналог task7
    @Test
    public void testTask7_Positive() {
        String result = Main.task7(3, 7).strip();
        assertEquals(result, "Расстояние между X1 и X2 - 4,0000");
    }

    @Test
    public void testTask7_Negative() {
        String result = Main.task7(-2, -5).strip();
        assertEquals(result, "Расстояние между X1 и X2 - 3,0000");
    }

    // Тест для task6
    @Test
    public void testTask6() {
        String result = Main.task6().strip();
        assertEquals(result, "Число кроликов через год = 232");
    }
}