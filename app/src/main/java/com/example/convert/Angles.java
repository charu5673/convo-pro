package com.example.convert;

public class Angles {
    public static double convert(Double input, String from, String to) {
        double ansDegrees = toDegrees(from, input);
        switch(to) {
            case "Degree": return ansDegrees;
            case "Radian": return ansDegrees * (Math.PI / 180);
            case "Gradian": return ansDegrees * (10.0 / 9);
            case "Minute of Arc": return ansDegrees * 60;
            case "Second of Arc": return ansDegrees * 3600;
            case "Turn": return ansDegrees / 360;
            default: return 0;
        }
    }

    private static double toDegrees(String from, Double input) {
        switch(from) {
            case "Degree": return input;
            case "Radian": return input * (180 / Math.PI);
            case "Gradian": return input * (9.0 / 10);
            case "Minute of Arc": return input / 60;
            case "Second of Arc": return input / 3600;
            case "Turn": return input * 360;
            default: return 0;
        }
    }
}
