package app;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestMain 
{
    @DataProvider(name = "temperatureDataProvider")
    public Object[][] provideTemperatureData() 
    {
        return new Object[][]{
                {"50\n", "tf = 122,0000"},
                {"0\n", "tf = 32,0000"},
                {"100\n", "tf = 212,0000"},
                {"1,25\n", "tf = 34,2500"}
        };
    }

    @Test(dataProvider = "temperatureDataProvider", groups = {"smoke"})
    public void testTask8ValidInput(String input, String expectedOutput) 
    {
        // ARRANGE
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        // ACT
        Main.task8();
        // ASSERT
        String output = out.toString();
        assertTrue(output.contains(expectedOutput));
    }

    @Test(groups = {"smoke"})
    public void testTask8InvalidInput() 
    {
        // ARRANGE
        String input = "101\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        // ACT
        Main.task8();
        // ASSERT
        String output = out.toString();
        assertTrue(output.contains("Введите значения [0,100]"));
    }

    @Test(groups = {"task2"})
    public void testTask2PositiveX() 
    {
        // ARRANGE
        String input = "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        // ACT
        Main.task2();
        // ASSERT
        String output = out.toString();
        assertTrue(output.contains("f(x)= 5,7321"));
    }

    @Test(groups = {"task2"})
    public void testTask2NegativeX() 
    {
        // ARRANGE
        String input = "-1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        // ACT
        Main.task2();
        // ASSERT
        String output = out.toString();
        assertTrue(output.contains("f(x)= -5,0000"));
    }

    @Test(groups = {"regression"})
    public void testTask3() 
    {
        // ARRANGE
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        // ACT
        Main.task3();
        // ASSERT
        String output = out.toString();
        assertTrue(output.contains("F(x)= -2,6191"));
    }

    @Test(groups = {"regression"})
    public void testTask7() 
    {
        // ARRANGE
        String input = "3\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        // ACT
        Main.task7();
        // ASSERT
        String output = out.toString();
        assertTrue(output.contains("Расстояние между X1 и X2 - 4,0000"));
    }


    @Test(groups = {"regression"})
    public void testTask7Exception() 
    {
        // ARRANGE
        String input = "three\nseven\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        // ACT
        String expectedException = "InputMismatchException";
        try 
        {
            Main.task7();
            if (expectedException != null) 
            {
                // ASSERT
                fail("Ожидалось исключение: " + expectedException);
            }
        }
        catch (Exception e) 
        {
            // ASSERT
            assertEquals(e.getClass().getSimpleName(), expectedException);
        }
    }

    @Test(groups = {"regression"})
    public void testTask6() 
    {
        // ARRANGE
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        // ACT
        Main.task6();
        // ASSERT
        String output = out.toString();
        assertTrue(output.contains("Число кроликов через год = 232"));
    }
}
