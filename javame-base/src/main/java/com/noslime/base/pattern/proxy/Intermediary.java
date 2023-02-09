package com.noslime.base.pattern.proxy;

/**
 * description : com.noslime.base.pattern.proxy
 *
 * @author qklee
 * @date 2/7/23
 */
public class Intermediary implements IPerson{

    private IPerson person;

    public Intermediary(IPerson person) {
        this.person = person;
    }

    @Override
    public void sellHouse() {
        before();
        person.sellHouse();
        after();
    }

    private void before(){
        System.out.println("start");
    }

    private void after(){
        System.out.println("end");
    }
}
