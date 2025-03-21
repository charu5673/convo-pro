package com.example.convert;

public class Energy {
    public static double convert(Double input, String from, String to) {
        double ansJoule = toJoule(from, input);
        switch(to) {
            case "Joule": return ansJoule;
            case "Kilojoule": return ansJoule / 1000;
            case "Calorie": return ansJoule / 4.184;
            case "Kilocalorie": return ansJoule / 4184;
            case "Watt hour": return ansJoule / 3600;
            case "Kilowatt hour": return ansJoule / 3_600_000;
            case "Electronvolt": return ansJoule * 6.242e+18;
            default: return 0;
        }
    }

    private static double toJoule(String from, Double input) {
        switch(from) {
            case "Joule": return input;
            case "Kilojoule": return input * 1000;
            case "Calorie": return input * 4.184;
            case "Kilocalorie": return input * 4184;
            case "Watt hour": return input * 3600;
            case "Kilowatt hour": return input * 3_600_000;
            case "Electronvolt": return input / 6.242e+18;
            default: return 0;
        }
    }
}
