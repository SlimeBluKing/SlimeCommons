package com.slime.slimecommons.common.utils;

import java.util.concurrent.TimeUnit;

public class TimeFormatter {
    public static String format(long milliseconds){
        long millis = milliseconds;
        String output = "";

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis = millis - TimeUnit.DAYS.toMillis(days);

        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis = millis - TimeUnit.HOURS.toMillis(hours);

        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis = millis - TimeUnit.MINUTES.toMillis(minutes);

        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        if (days > 1){
            output += days + " days ";
        }
        else if(days == 1) {
            output += days + " day ";
        }

        if (hours > 1) {
            output += hours + " hours ";
        }
        else if (hours == 1) {
            output += hours + " hour ";
        }

        if (minutes > 1) {
            output += minutes + " minutes ";
        }
        else if (minutes == 1) {
            output += minutes + " minute ";
        }

        if (seconds > 1) {
            output += seconds + " seconds ";
        }
        else if (seconds == 1) {
            output += seconds + " second ";
        }

        if (output.isEmpty()) {
            return "0 seconds";
        }

        return output.trim();
    }

    public static String shortFormat(long milliseconds){
        long millis = milliseconds;
        String output = "";

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis = millis - TimeUnit.DAYS.toMillis(days);

        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis = millis - TimeUnit.HOURS.toMillis(hours);

        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis = millis - TimeUnit.MINUTES.toMillis(minutes);

        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        if (days > 1){
            output += days + "d ";
        }
        else if(days == 1) {
            output += days + "d ";
        }

        if (hours > 1) {
            output += hours + "h ";
        }
        else if (hours == 1) {
            output += hours + "h ";
        }

        if (minutes > 1) {
            output += minutes + "m ";
        }
        else if (minutes == 1) {
            output += minutes + "m ";
        }

        if (seconds > 1) {
            output += seconds + "s ";
        }
        else if (seconds == 1) {
            output += seconds + "s ";
        }

        if (output.isEmpty()) {
            return "0s";
        }

        return output.trim();
    }
}
