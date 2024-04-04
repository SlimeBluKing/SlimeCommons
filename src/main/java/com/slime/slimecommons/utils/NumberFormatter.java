package com.slime.slimecommons.utils;

import java.text.DecimalFormat;

public class NumberFormatter {
    public static String formatNumber(Number value) {
        long num = value.longValue();
        if (num < 1000) {
            return String.valueOf(num);
        } else if (num < 1000000) {
            return formatDecimal(num / 1000.0) + "k";
        } else if (num < 1000000000) {
            return formatDecimal(num / 1000000.0) + "m";
        } else if (num < 1000000000000L) {
            return formatDecimal(num / 1000000000.0) + "b";
        } else if (num < 1000000000000000L) {
            return formatDecimal(num / 1000000000000.0) + "t";
        } else {
            return formatDecimal(num / 1000000000000000.0) + "q";
        }
    }

    private static String formatDecimal(double value) {
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(value);
    }
}