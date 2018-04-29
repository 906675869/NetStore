package com.example.demo.util.utilimpl;

public class CommonUtils {
    public static String convertNullToString(Object object){
        return object == null ? "" :object.toString();
    }
}
