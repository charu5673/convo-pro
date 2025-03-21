package com.example.convert;

public class Time {
    public static double convert(Double input, String from, String to) {
        double ansS = toSecond(from, input);
        switch(to) {
            case "Nanosecond": return ansS * 1_000_000_000;
            case "Microsecond": return ansS * 1_000_000;
            case "Millisecond": return ansS * 1_000;
            case "Second": return ansS;
            case "Minute": return ansS / 60;
            case "Hour": return ansS / 3600;
            case "Day": return ansS / 86400;
            case "Week": return ansS / 604800;
            case "Month": return ansS / 2_629_746; // Average month length in seconds
            case "Year": return ansS / 31_556_952; // Average year length in seconds
            default: return 0;
        }
    }

    private static double toSecond(String from, Double input) {
        switch(from) {
            case "Nanosecond": return input / 1_000_000_000;
            case "Microsecond": return input / 1_000_000;
            case "Millisecond": return input / 1_000;
            case "Second": return input;
            case "Minute": return input * 60;
            case "Hour": return input * 3600;
            case "Day": return input * 86400;
            case "Week": return input * 604800;
            case "Month": return input * 2_629_746;
            case "Year": return input * 31_556_952;
            default: return 0;
        }
    }
}
