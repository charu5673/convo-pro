package com.example.convert;

public class Speed {
    public static double convert(Double input, String from, String to) {
        double ansMps = toMetersPerSecond(from, input);
        switch(to) {
            case "Meter per second": return ansMps;
            case "Kilometer per hour": return ansMps * 3.6;
            case "Mile per hour": return ansMps * 2.23694;
            case "Foot per second": return ansMps * 3.28084;
            case "Knot": return ansMps * 1.94384;
            default: return 0;
        }
    }

    private static double toMetersPerSecond(String from, Double input) {
        switch(from) {
            case "Meter per second": return input;
            case "Kilometer per hour": return input / 3.6;
            case "Mile per hour": return input * 0.44704;
            case "Foot per second": return input * 0.3048;
            case "Knot": return input * 0.514444;
            default: return 0;
        }
    }
}
