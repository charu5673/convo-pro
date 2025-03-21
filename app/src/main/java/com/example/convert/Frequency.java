package com.example.convert;

public class Frequency {
    public static double convert(Double input, String from, String to) {
        double ansHertz = toHertz(from, input);
        switch(to) {
            case "Hertz": return ansHertz;
            case "Kilohertz": return ansHertz / 1000;
            case "Megahertz": return ansHertz / 1_000_000;
            case "Gigahertz": return ansHertz / 1_000_000_000;
            default: return 0;
        }
    }

    private static double toHertz(String from, Double input) {
        switch(from) {
            case "Hertz": return input;
            case "Kilohertz": return input * 1000;
            case "Megahertz": return input * 1_000_000;
            case "Gigahertz": return input * 1_000_000_000;
            default: return 0;
        }
    }
}
