package com.thuannd.erm.utils;

public final class Constants{

    private Constants(){
        throw new IllegalStateException("Utility class");
    }

    public static final Integer STATUS_NEW = 0;
    public static final Integer STATUS_DISABLE = 1;
    public static final Integer STATUS_REMOVE = 2;

    public static final Integer ACTIVE = 1;
    public static final Integer INACTIVE = 0;
}