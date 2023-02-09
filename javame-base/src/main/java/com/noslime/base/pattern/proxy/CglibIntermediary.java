package com.noslime.base.pattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * description : com.noslime.base.pattern.proxy
 *
 * @author qklee
 * @date 2/7/23
 */
public class CglibIntermediary implements MethodInterceptor {

    public Object getInstance(Class<?> clz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    private void before() {
        System.out.println("start");
    }

    private void after() {
        System.out.println("end");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();

        Object invoke = methodProxy.invokeSuper(o, objects);

        after();
        return invoke;
    }
}
