package com.mcserby.training.refactoring;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Helper {
    public static final Map<String,String> countries;
    static {
        countries = new HashMap<>();
        countries.put("getUk", "en_uk");
        countries.put("getNl", "nl");
        countries.put("getDe", "de");
        countries.put("getFr", "fr");
        countries.put("getEs", "es");
        countries.put("getIt", "it");
        countries.put("getAt", "at");
        countries.put("getChFr", "ch_fr");
        countries.put("getChDe", "ch_de");
        countries.put("getChIt", "ch_it");
        countries.put("getBeFr", "be_fr");
        countries.put("getLuDe", "lux_de");
        countries.put("getCaEs", "es_ca");
        countries.put("getLuFr", "lux_fr");
        countries.put("ar02", "Some article");
    }

    public static Details invokeMethod(String methodName) {
        Class<?> c = null;
        try {
            c = Class.forName("com.mcserby.training.refactoring.InternationalValues");
            Object obj = c.getDeclaredConstructor().newInstance();
            Method method = c.getDeclaredMethod(methodName, null);
            method.setAccessible(true);
            return (Details) method.invoke(obj, null);
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
