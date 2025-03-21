package com.example.convert;

public class Power {
    public static double convert(Double input, String from, String to) {
        double ansWatt = toWatt(from, input);
        switch(to) {
            case "Watt": return ansWatt;
            case "Kilowatt": return ansWatt / 1000;
            case "Megawatt": return ansWatt / 1_000_000;
            case "Horsepower": return ansWatt / 745.7;
            default: return 0;
        }
    }

    private static double toWatt(String from, Double input) {
        switch(from) {
            case "Watt": return input;
            case "Kilowatt": return input * 1000;
            case "Megawatt": return input * 1_000_000;
            case "Horsepower": return input * 745.7;
            default: return 0;
        }
    }
}
