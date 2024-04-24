package com.example.springtest.aop;

public class Client {
    public static void main(String[] args) {
//        ISolver solver = new Solver();
//        ISolver csProxy = (ISolver) new ProxyFactory(solver).getProxyInstance();
//        csProxy.solve();
//
//        Apple solver_2 = new AppleSolver();
//        Apple csProxyStore = (Apple) new ProxyFactory(solver_2).getProxyInstance();
//        csProxyStore.solve();

        Solver2 solver2 = new Solver2();
        Solver2 proxyInstance = (Solver2) new ProxyFactory2(solver2).getProxyInstance();
        proxyInstance.solve();

    }
}
