package com.noslime.base.pattern.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * description : com.noslime.base.pattern.proxy
 *
 * @author qklee
 * @date 2/7/23
 */
public class JDKProxyTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        IPerson person = new Seller();
        JdkIntermediaryProvider jdkIntermediary = new JdkIntermediaryProvider();
        IPerson instance = jdkIntermediary.getInstance(person);
        instance.sellHouse();
        byte[] $Proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IPerson.class});
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/home/qklee/mycode/javame/javame-base/$Proxy0.class");
            fileOutputStream.write($Proxy0s);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void test() {
        Seller seller = new Seller();

        JdkIntermediaryProvider jdkIntermediary = new JdkIntermediaryProvider();
        IPerson instance = jdkIntermediary.getInstance(seller);
        instance.sellHouse();

    }
}
