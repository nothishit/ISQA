package app;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.testng.Assert.*;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    
    @BeforeMethod
    public void setUpStreams() {
        // Устанавливаем локаль, чтобы избежать проблем с разделителями
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(outContent));
    }
    
    @AfterMethod
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        outContent.reset();
    }
    
    @Test
    public void testTask8ValidInput() {
        String input = "50";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Main.task8();
        assertEquals(outContent.toString().trim(), "tf = 122.0");
    }
    
    @Test
    public void testTask8InvalidInput() {
        String input = "-10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Main.task8();
        assertEquals(outContent.toString().trim(), "Введите значения [0,100]");
    }
    
    @Test
    public void testTask2() {
        String input = "2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Main.task2();
        // Убираем "X= " из проверки, так как это приглашение для ввода
        assertTrue(outContent.toString().trim().endsWith("f(x)= 5.7321"));
    }
    
    @Test
    public void testTask3() {
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Main.task3();
        assertTrue(outContent.toString().trim().endsWith("F(x)= -2.6191"));
    }
    
    @Test
    public void testTask7() {
        String input = "3\n7";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Main.task7();
        assertTrue(outContent.toString().trim().endsWith("Расстояние между X1 и X2 - 4.0000"));
    }
    
    @Test
    public void testTask6() {
        Main.task6();
        assertEquals(outContent.toString().trim(), "Число кроликов через год = 376");
    }
}
