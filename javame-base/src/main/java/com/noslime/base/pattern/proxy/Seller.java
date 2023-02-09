package com.noslime.base.pattern.proxy;

/**
 * description : com.noslime.base.pattern.proxy
 *
 * @author qklee
 * @date 2/7/23
 */
public class Seller implements IPerson{

    public Seller() {}

    @Override
    public void sellHouse() {
        System.out.println("i sell my house.");
    }
}
