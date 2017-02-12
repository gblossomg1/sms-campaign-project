package com.concreteitsolutions.commonframework.core.exceptions.tmp;


public class LOG {

    public static void debug(final String message) {
        System.out.println(message);
    }

    public static void debug(final Object object) {
        System.out.println(object);
    }

    public static void debug(final String message1, final Object value1) {
        System.out.println(message1 + " : " + value1);
    }

    /*public static void debug(final String message1, final Object value1, final String message2, final Object value2) {
        System.out.println(message1 + " : " + value1 + "");
    } */
}
