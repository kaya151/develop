package com.tuomi.develop.test;



public class DecimalTest {
//    public static String getRounding(float number){
//        String format = String.format("%.2f", number);
//        String[] split = format.split("\\.");
//        if (split[1].lastIndexOf("0")==1){
//            format = String.format("%.1f", number);
//            String[] split1 = format.split("\\.");
//            if (split1[1].lastIndexOf("0")==0){
//                format = String.format("%.0f", number);
//            }
//        }
//        return format;
//    }
    public static void main(String[] args) {
        float a = 23.016648f;
        String format = String.format("%.2f", a);
        System.out.println("11111   "+format);
        String[] split = format.split("\\.");
        if (split[1].lastIndexOf("0")==1){
            format = String.format("%.1f", a);
            System.out.println("22222   "+format);
            String[] split1 = format.split("\\.");
            if (split1[1].lastIndexOf("0")==0){
                format = String.format("%.0f", a);
                System.out.println("33333   "+format);
            }
        }
        System.out.println("last    "+format);
    }
}
