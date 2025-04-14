package app;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class NewTasksTest {
    
    static {
        // для корректной работы с точкой в десятичных числах
        Locale.setDefault(Locale.US);
    }

    @DataProvider(name = "earningsData")
    public Object[][] provideEarningsData() {
        return new Object[][]{
                {"100.0\n", 33.3333, 66.6667},
                {"200.0\n", 66.6667, 133.3333},
                {"0.0\n", 0.0, 0.0},
                {"300.0\n", 100.0, 200.0}
        };
    }

    @Test(dataProvider = "earningsData")
    public void testTask4(String input, double expectedEarnings1, double expectedEarnings2) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(outContent));
        
        Main.task4();
        
        String output = outContent.toString();
        String[] lines = output.split("\n");
        
        // Извлекаем числа из строк
        double actual1 = extractDouble(lines[0]);
        double actual2 = extractDouble(lines[1]);
        
        assertEquals(actual1, expectedEarnings1, 0.0001);
        assertEquals(actual2, expectedEarnings2, 0.0001);

        System.setIn(System.in);
        System.setOut(originalOut);
    }

    @DataProvider(name = "distanceData")
    public Object[][] provideDistanceData() {
        return new Object[][]{
                {"1.0\n3.0\n", 2.0},
                {"-1.0\n1.0\n", 2.0},
                {"0.0\n0.0\n", 0.0},
                {"5.5\n2.5\n", 3.0}
        };
    }

    @Test(dataProvider = "distanceData")
    public void testTask63(String input, double expectedDistance) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(outContent));
        
        Main.task63();
        
        String output = outContent.toString();
        double actual = extractDouble(output);
        assertEquals(actual, expectedDistance, 0.0001);

        System.setIn(System.in);
        System.setOut(originalOut);
    }

    @DataProvider(name = "coneData")
    public Object[][] provideConeData() {
        return new Object[][]{
                {"3.0\n5.0\n4.0\n", 4.4721},
                {"1.0\n3.0\n2.0\n", 2.8284},
                {"0.0\n0.0\n0.0\n", 0.0},
                {"2.5\n4.5\n3.0\n", 3.6056}
        };
    }

    @Test(dataProvider = "coneData")
    public void testTask5(String input, double expectedGeneratrix) throws Exception {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(outContent));
        
        Main.task5();
        
        String output = outContent.toString();
        double actual = extractDouble(output);
        assertEquals(actual, expectedGeneratrix, 0.0001);

        System.setIn(System.in);
        System.setOut(originalOut);
    }

    // Вспомогательный метод для извлечения double из строки
    private double extractDouble(String str) {
        // Ищем последовательность цифр с точкой
        String numStr = str.replaceAll(".*?(\\d+\\.\\d+).*", "$1");
        return Double.parseDouble(numStr);
    }
}
