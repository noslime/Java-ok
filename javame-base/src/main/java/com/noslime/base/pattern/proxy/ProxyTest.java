package com.noslime.base.pattern.proxy;

/**
 * description : com.noslime.base.pattern.proxy
 *
 * @author qklee
 * @date 2/7/23
 */
public class ProxyTest {

    public static void main(String[] args) {
        Seller seller = new Seller();

        Intermediary intermediary = new Intermediary(seller);
        intermediary.sellHouse();

    }
}
