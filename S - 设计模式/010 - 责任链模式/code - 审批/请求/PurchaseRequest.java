package com.demo.设计模式.责任链模式.审批.请求;

/**
 * 购买请求
 */
public class PurchaseRequest {

    // 请求金额
    private double price;

    public PurchaseRequest(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}
