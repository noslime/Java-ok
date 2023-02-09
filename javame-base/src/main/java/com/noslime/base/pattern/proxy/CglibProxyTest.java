package com.noslime.base.pattern.proxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * description : com.noslime.base.pattern.proxy
 *
 * @author qklee
 * @date 2/8/23
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"/home/qklee/mycode/javame/javame-base/$Proxy0_cglib_class");
        CglibIntermediary cglibIntermediary = new CglibIntermediary();
        Seller seller = (Seller) cglibIntermediary.getInstance(Seller.class);
        seller.sellHouse();
    }


    public static void test() {
        Seller seller = new Seller();

        CglibIntermediary cglibIntermediary = new CglibIntermediary();
        Seller instance = (Seller)cglibIntermediary.getInstance(seller.getClass());
        instance.sellHouse();
    }
}
