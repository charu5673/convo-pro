package com.example.convert;

public class Temperature {
    public static double convert(Double input, String from, String to) {
        double ansC = toCelsius(from, input);
        switch(to) {
            case "Celsius": return ansC;
            case "Fahrenheit": return (ansC * 9/5) + 32;
            case "Kelvin": return ansC + 273.15;
            default: return 0;
        }
    }

    private static double toCelsius(String from, Double input) {
        switch(from) {
            case "Celsius": return input;
            case "Fahrenheit": return (input - 32) * 5/9;
            case "Kelvin": return input - 273.15;
            default: return 0;
        }
    }
}
