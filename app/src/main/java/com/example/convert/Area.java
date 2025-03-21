package com.example.convert;

public class Area {
    public static double convert(Double input, String from, String to) {
        double ansSqM = toSquareMeter(from, input);
        switch (to) {
            case "Square Millimeter": return ansSqM * 1_000_000;
            case "Square Centimeter": return ansSqM * 10_000;
            case "Square Meter": return ansSqM;
            case "Square Kilometer": return ansSqM / 1_000_000;
            case "Square Inch": return ansSqM * 1550.0031;
            case "Square Foot": return ansSqM * 10.7639;
            case "Square Yard": return ansSqM * 1.19599;
            case "Acre": return ansSqM * 0.000247105;
            case "Hectare": return ansSqM * 0.0001;
            default: return 0;
        }
    }

    private static double toSquareMeter(String from, Double input) {
        switch (from) {
            case "Square Millimeter": return input / 1_000_000;
            case "Square Centimeter": return input / 10_000;
            case "Square Meter": return input;
            case "Square Kilometer": return input * 1_000_000;
            case "Square Inch": return input * 0.00064516;
            case "Square Foot": return input * 0.092903;
            case "Square Yard": return input * 0.836127;
            case "Acre": return input * 4046.86;
            case "Hectare": return input * 10_000;
            default: return 0;
        }
    }
}
