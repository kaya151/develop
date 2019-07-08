package com.tuomi.develop.util;

public class DecimalUtil {
    public static String getRounding(float number){
        String format = String.format("%.2f", number);
        String[] split = format.split("\\.");
        if (split[1].lastIndexOf("0")==1){
            format = String.format("%.1f", number);
            String[] split1 = format.split("\\.");
            if (split1[1].lastIndexOf("0")==0){
                format = String.format("%.0f", number);
            }
        }
        return format;
    }
}
