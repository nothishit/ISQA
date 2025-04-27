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
       System.setIn(new ByteArrayInputStream(input.getBytes()));
        
       ByteArrayOutputStream out = new ByteArrayOutputStream();
       System.setOut(new PrintStream(out));

       Main.task8();
       
       String output = out.toString();
       assertTrue(output.contains(expectedOutput));
    }

    @Test(groups = {"smoke"})
    public void testTask8InvalidInput() 
    {
        String input = "101\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.task8();
        
        String output = out.toString();
        assertTrue(output.contains("Введите значения [0,100]"));
    }

    @Test(groups = {"task2"})
    public void testTask2PositiveX() 
    {
        String input = "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.task2();
        
        String output = out.toString();
        assertTrue(output.contains("f(x)= 5,7321"));
    }

    @Test(groups = {"task2"})
    public void testTask2NegativeX() 
    {
        String input = "-1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.task2();
        
        String output = out.toString();
        assertTrue(output.contains("f(x)= -5,0000"));
    }

    @Test(groups = {"regression"})
    public void testTask3() 
    {
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.task3();
        
        String output = out.toString();
        assertTrue(output.contains("F(x)= -2,6191"));
    }

    @Test(groups = {"regression"})
    public void testTask7() 
    {
        String input = "3\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.task7();
        
        String output = out.toString();
        assertTrue(output.contains("Расстояние между X1 и X2 - 4,0000"));
    }


    @Test(groups = {"regression"})
    public void testTask7Exception() 
    {
        String input = "three\nseven\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        String expectedException = "InputMismatchException";
        try 
        {
            Main.task7();
            if (expectedException != null) 
            {
                fail("Ожидалось исключение: " + expectedException);
            }
        }
        catch (Exception e) 
        {
            assertEquals(e.getClass().getSimpleName(), expectedException);
        }
    }

    @Test(groups = {"regression"})
    public void testTask6() 
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.task6();
        
        String output = out.toString();
        assertTrue(output.contains("Число кроликов через год = 232"));
    }
}
