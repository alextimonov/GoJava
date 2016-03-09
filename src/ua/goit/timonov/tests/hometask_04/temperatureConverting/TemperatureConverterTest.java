package ua.goit.timonov.tests.hometask_04.temperatureConverting;

import org.junit.Before;
import org.junit.Test;
import ua.goit.timonov.hometask_04.temperatureConverting.TemperatureConverter;

import static org.junit.Assert.*;

/**
 * Created by Alex on 09.03.2016.
 */
public class TemperatureConverterTest {
    private TemperatureConverter converter;

    @Before
    public void setUp() {
        converter = new TemperatureConverter();
    }

    // =================== Tests for FahrenheitToCelsius =================
    @Test
    public void testFahrenheitToCelsiusNormal_1() {
        assertEquals(0f, converter.fahrenheitToCelsius(32f), 10E-3f);
    }

    @Test
    public void testFahrenheitToCelsiusNormal_2() {
        assertEquals(100f, converter.fahrenheitToCelsius(212f), 10E-3f);
    }

    @Test
    public void testFahrenheitToCelsiusNormal_3() {
        assertEquals(50f, converter.fahrenheitToCelsius(122f), 10E-3f);
    }

    @Test
    public void testFahrenheitToCelsiusBorder_1() {
        assertEquals( (Float.MAX_VALUE - 32f) / 1.8f, converter.fahrenheitToCelsius(Float.MAX_VALUE), 10E-3f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFahrenheitToCelsiusBorder_2() {
        assertEquals(-Float.MAX_VALUE, converter.fahrenheitToCelsius(-Float.MAX_VALUE), 10E-3f);
    }

    // =================== Tests for CelsiusToFahrenheit =================
    @Test
    public void testCelsiusToFahrenheitNormal_1() {
        assertEquals(32f, converter.celsiusToFahrenheit(0f), 10E-3f);
    }

    @Test
    public void testCelsiusToFahrenheitNormal_2() {
        assertEquals(212f, converter.celsiusToFahrenheit(100f), 10E-3f);
    }

    @Test
    public void testCelsiusToFahrenheitNormal_3() {
        assertEquals(122f, converter.celsiusToFahrenheit(50f), 10E-3f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCelsiusToFahrenheitBorder_1() {
        assertEquals(Float.POSITIVE_INFINITY, converter.celsiusToFahrenheit(Float.MAX_VALUE), 10E-3f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCelsiusToFahrenheitBorder_2() {
        assertEquals( Float.NEGATIVE_INFINITY , converter.celsiusToFahrenheit(-Float.MAX_VALUE), 10E-3f);
    }
}