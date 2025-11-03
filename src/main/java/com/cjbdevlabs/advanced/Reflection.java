package com.cjbdevlabs.advanced;

public class Reflection {

    /*
    NOTE: Reflection should rarely be used. If there is another way to solve the problem in a non-reflective way, use that.
    More information on reflection API can be found here: https://dev.java/learn/reflection/intro/
     */

    /*
    -- Add to main method to execute --

    var someList = new ArrayList<String>();
    var clazz = someList.getClass();
    System.out.println(clazz.getSimpleName());
     */

    /*
    -- Can find different types on the class --
    isAnnotation()
    isAnonymousClass()
    isArray()
    isEnum()
    isHiddent()
    isInterface()
    isLocalClass()
    isMemberClass()
    isPrimitive()
    isRecord()
    isSealed()
    isSynthetic()
    Proxy.isProxyClass(Class<?> cl)
    - Note that for generics, the raw type will always be returned. This is because Java uses type erasure for generics,
    which means the type is erased at run time, as opposed to reified generics
     */

    /*
    -- Multiple ways to get the name of a class --
    getName() - oldest method, strange output for arrays. Don't use
    getSimpleName() - strips away package name. Use this (example output: ArrayList)
    getCanonicalName() - full class name, better for array output. Don't use
    getTypeName() - full class name, better array output, never null. Use this (example output: java.util.Arraylist)
    getPackageName() - package in which class resides. alwasy java.lang for primitives
     */
}
