package com.example.convert;

public class Weight {
    public static double convert(Double input, String from, String to) {
        double ansKg = toKilogram(from, input);
        switch (to) {
            case "Milligram": return ansKg * 1_000_000;
            case "Gram": return ansKg * 1_000;
            case "Kilogram": return ansKg;
            case "Ton": return ansKg / 1_000;
            case "Ounce": return ansKg * 35.274;
            case "Pound": return ansKg * 2.20462;
            case "Stone": return ansKg * 0.157473;
            default: return 0;
        }
    }

    private static double toKilogram(String from, Double input) {
        switch (from) {
            case "Milligram": return input / 1_000_000;
            case "Gram": return input / 1_000;
            case "Kilogram": return input;
            case "Ton": return input * 1_000;
            case "Ounce": return input * 0.0283495;
            case "Pound": return input * 0.453592;
            case "Stone": return input * 6.35029;
            default: return 0;
        }
    }
}
