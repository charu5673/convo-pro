package com.example.convert;

public class Length {
    public static double convert(Double input, String from, String to)
    {
        double ansM=toMetre(from,input);
        switch(to) {
            case "Millimeter": return ansM*1000;
            case "Centimeter": return ansM*100;
            case "Meter": return ansM;
            case "Kilometer": return ansM/1000;
            case "Inch": return ansM*39.3701;
            case "Foot": return ansM*3.28084;
            case "Yard": return ansM*1.09361;
            case "Mile": return ansM*0.000621371;
            default: return 0;
        }
    }

    private static double toMetre(String from, Double input) {
        switch(from) {
            case "Millimeter": return input/1000;
            case "Centimeter": return input/100;
            case "Meter": return input;
            case "Kilometer": return input*1000;
            case "Inch": return input*0.0254;
            case "Foot": return input*0.3048;
            case "Yard": return input*0.9144;
            case "Mile": return input*1609.344;
            default: return 0;
        }
    }
}
