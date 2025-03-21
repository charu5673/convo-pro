package com.example.convert;

public class Pressure {
    public static double convert(Double input, String from, String to) {
        double ansPascal = toPascal(from, input);
        switch(to) {
            case "Pascal": return ansPascal;
            case "Kilopascal": return ansPascal / 1000;
            case "Bar": return ansPascal / 100000;
            case "PSI": return ansPascal / 6894.76;
            case "Atmosphere": return ansPascal / 101325;
            case "Torr": return ansPascal / 133.322;
            default: return 0;
        }
    }

    private static double toPascal(String from, Double input) {
        switch(from) {
            case "Pascal": return input;
            case "Kilopascal": return input * 1000;
            case "Bar": return input * 100000;
            case "PSI": return input * 6894.76;
            case "Atmosphere": return input * 101325;
            case "Torr": return input * 133.322;
            default: return 0;
        }
    }
}
