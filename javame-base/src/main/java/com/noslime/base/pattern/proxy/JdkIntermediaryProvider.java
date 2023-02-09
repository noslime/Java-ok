package com.noslime.base.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * description : com.noslime.base.pattern.proxy
 *
 * @author qklee
 * @date 2/7/23
 */
public class JdkIntermediaryProvider implements InvocationHandler {

    private IPerson target;

    public IPerson getInstance(IPerson target) {
        this.target = target;
        Class<?> clz = target.getClass();
        return (IPerson) Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), this);
    }

    private void before() {
        System.out.println("start");
    }

    private void after() {
        System.out.println("end");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        System.out.println(proxy.getClass().getName());
        System.out.println(target.getClass().getName());
        Object result = method.invoke(target, args);
        after();
        return result;
    }
}
