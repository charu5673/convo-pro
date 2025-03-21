package com.example.convert;

public class Density {
    public static double convert(Double input, String from, String to) {
        double ansKgPerCubicMeter = toKgPerCubicMeter(from, input);
        switch(to) {
            case "Kilogram per Cubic Meter": return ansKgPerCubicMeter;
            case "Gram per Cubic Centimeter": return ansKgPerCubicMeter / 1000;
            case "Gram per Liter": return ansKgPerCubicMeter;
            case "Pound per Cubic Foot": return ansKgPerCubicMeter * 0.06242796;
            case "Pound per Cubic Inch": return ansKgPerCubicMeter * 0.000036127;
            default: return 0;
        }
    }

    private static double toKgPerCubicMeter(String from, Double input) {
        switch(from) {
            case "Kilogram per Cubic Meter": return input;
            case "Gram per Cubic Centimeter": return input * 1000;
            case "Gram per Liter": return input;
            case "Pound per Cubic Foot": return input / 0.06242796;
            case "Pound per Cubic Inch": return input / 0.000036127;
            default: return 0;
        }
    }
}
