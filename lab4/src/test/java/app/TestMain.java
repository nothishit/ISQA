package app;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestMain {

    @Test
    public void testTask8_ValidInput() {
        String input = "50\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.task8();
        
        String output = out.toString();
        assertTrue(output.contains("tf = 122,0000"));
    }

    @Test
    public void testTask8_InvalidInput() {
        String input = "101\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.task8();
        
        String output = out.toString();
        assertTrue(output.contains("Введите значения [0,100]"));
    }

    @Test
    public void testTask2PositiveX() {
        String input = "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.task2();
        
        String output = out.toString();
        assertTrue(output.contains("f(x)= 5,7321"));
    }

    @Test
    public void testTask2NegativeX() {
        String input = "-1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.task2();
        
        String output = out.toString();
        assertTrue(output.contains("f(x)= -5,0000"));
    }

    @Test
    public void testTask3() {
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.task3();
        
        String output = out.toString();
        assertTrue(output.contains("F(x)= -2,6191"));
    }

    @Test
    public void testTask7() {
        String input = "3\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.task7();
        
        String output = out.toString();
        assertTrue(output.contains("Расстояние между X1 и X2 - 4,0000"));
    }

    @Test
    public void testTask6() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.task6();
        
        String output = out.toString();
        assertTrue(output.contains("Число кроликов через год = 232"));
    }
}
