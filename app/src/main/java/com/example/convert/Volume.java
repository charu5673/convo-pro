package com.example.convert;

public class Volume {
    public static double convert(Double input, String from, String to) {
        double ansM = toCubicMeter(from, input);
        switch (to) {
            case "Milliliter": return ansM * 1_000_000;
            case "Liter": return ansM * 1000;
            case "Cubic Centimeter": return ansM * 1_000_000;
            case "Cubic Meter": return ansM;
            case "Gallon (US)": return ansM * 264.172;
            case "Gallon (UK)": return ansM * 219.969;
            case "Pint": return ansM * 2113.38;
            case "Quart": return ansM * 1056.69;
            case "Fluid Ounce": return ansM * 33814;
            default: return 0;
        }
    }

    private static double toCubicMeter(String from, Double input) {
        switch (from) {
            case "Milliliter": return input / 1_000_000;
            case "Liter": return input / 1000;
            case "Cubic Centimeter": return input / 1_000_000;
            case "Cubic Meter": return input;
            case "Gallon (US)": return input / 264.172;
            case "Gallon (UK)": return input / 219.969;
            case "Pint": return input / 2113.38;
            case "Quart": return input / 1056.69;
            case "Fluid Ounce": return input / 33814;
            default: return 0;
        }
    }
}
