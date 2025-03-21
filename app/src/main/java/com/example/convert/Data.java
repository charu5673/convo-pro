package com.example.convert;

public class Data {
    public static double convert(Double input, String from, String to) {
        double ansBytes = toBytes(from, input);
        switch(to) {
            case "Bit": return ansBytes * 8;
            case "Byte": return ansBytes;
            case "Kilobyte": return ansBytes / 1024;
            case "Megabyte": return ansBytes / (1024 * 1024);
            case "Gigabyte": return ansBytes / (1024 * 1024 * 1024);
            case "Terabyte": return ansBytes / (1024L * 1024 * 1024 * 1024);
            default: return 0;
        }
    }

    private static double toBytes(String from, Double input) {
        switch(from) {
            case "Bit": return input / 8;
            case "Byte": return input;
            case "Kilobyte": return input * 1024;
            case "Megabyte": return input * 1024 * 1024;
            case "Gigabyte": return input * 1024 * 1024 * 1024;
            case "Terabyte": return input * 1024L * 1024 * 1024 * 1024;
            default: return 0;
        }
    }
}
