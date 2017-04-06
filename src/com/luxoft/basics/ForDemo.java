package com.luxoft.basics;

import java.util.Arrays;

public class ForDemo {

    public static void main(String[] args) {

        String[] field = {"B", " ", " ", "B", "B", " ", "B", "B", "B"};

        for (int i = 0; i < field.length; i+=3)
        {
            //System.out.println(field[i], field[i+1], field[i+2]);
        }
//        String[] newField = new String[3];
//        int a = 0;
//        for (String s: field){
//            newField[a++] = s;
//            if(a==2){
//                a=0;
//                System.out.println(Arrays.toString(newField));
//            }
//
//        }

    }
}
