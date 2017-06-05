package com.gmail.s12348.evgen;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main (String [] args){
        TextContainer tc = new TextContainer();
        Class<?> cls=tc.getClass();
        String path=null;
        if (cls.isAnnotationPresent(SaveTo.class)){
        SaveTo saveTo = cls.getAnnotation(SaveTo.class);
        path=(String)saveTo.path();
        }
        try {
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Saver.class))
                    method.invoke(tc, path);
            }
        } catch (InvocationTargetException| IllegalAccessException e){
            System.out.println(e);
        }
    }

}
