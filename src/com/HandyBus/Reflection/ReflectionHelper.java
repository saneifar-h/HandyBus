package com.HandyBus.Reflection;

public class ReflectionHelper {

    public static String NameOf(Object object)
    {
        return object.getClass().getSimpleName();
    }

    public static String NameOf(Class cls)
    {
        return cls.getSimpleName();
    }
}
