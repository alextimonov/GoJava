package ua.goit.timonov.hometask_04.temperatureConverting;

/**
 * Class with methods that convert given value of temperature:
 * 1) from fahrenheit degrees to celsius degrees;
 * 2) from celsius degrees to fahrenheit degrees.
 */

public class TemperatureConverter {
    public static final float CELSIUS_TO_FAHRENHEIT_ADDITION = 32f;
    public static final float CELSIUS_TO_FAHRENHEIT_MULTIPLIER = 1.8f;

    /**
     * Converts given temperature in fahrenheit degrees to celsius degrees
     */
    public float fahrenheitToCelsius(float tempFahrenheit) {
        checkTempFahrenheit(tempFahrenheit);
        return (tempFahrenheit - CELSIUS_TO_FAHRENHEIT_ADDITION) / CELSIUS_TO_FAHRENHEIT_MULTIPLIER;
    }

    // Checks given value if it is too small to be deducted with float type (-Float.MAX_VALUE will be reached)
    private void checkTempFahrenheit(float tempFahrenheit) {
        double minFloat = -Float.MAX_VALUE + CELSIUS_TO_FAHRENHEIT_ADDITION ;
        if (minFloat >= tempFahrenheit) {
            throw new IllegalArgumentException("Float min value is reached.");
        }
    }

    /**
     * Converts given temperature in celsius  degrees to fahrenheit degrees
     */
    public float celsiusToFahrenheit(float tempCelsius) {
        checkTempCelsius(tempCelsius);
        return tempCelsius * CELSIUS_TO_FAHRENHEIT_MULTIPLIER + CELSIUS_TO_FAHRENHEIT_ADDITION;
    }

    // Checks given value if it's too big to be added with float type (Float.MAX_VALUE will be reached)
    private void checkTempCelsius(float tempCelsius) {
        double maxValue = (Float.MAX_VALUE - CELSIUS_TO_FAHRENHEIT_ADDITION) / CELSIUS_TO_FAHRENHEIT_MULTIPLIER;
        double minValue = -Float.MAX_VALUE / CELSIUS_TO_FAHRENHEIT_MULTIPLIER;
        if (tempCelsius >= maxValue || tempCelsius <= minValue )  {
            throw new IllegalArgumentException("Float max or min will be reached.");
        }
    }
}
