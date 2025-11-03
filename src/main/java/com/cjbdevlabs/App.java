package com.cjbdevlabs;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        var someList = new ArrayList<String>();
        var clazz = someList.getClass();
        System.out.println(clazz.getSimpleName());
    }
}
