package com.demo.多线程;

import java.util.LinkedList;

public class TestDemo {

    public static void main(String[] args) throws Exception {
        MessageQueue queue = new MessageQueue(2);

        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(()->{
                Message message = new Message(id, "msg" + id);
                queue.put(message);
            },"生产者"+id).start();
        }

        Thread.sleep(1000);

        new Thread(()->{
            while (true) {
                queue.consume();
            }
        },"消费者").start();

    }
}

class MessageQueue{

    // 消息的队列集合
    private LinkedList<Message> list = new LinkedList<>();

    // 容量
    private int capcity;

    public MessageQueue(int capcity){
        this.capcity = capcity;
    }

    // 存入消息
    public void put(Message message){
        synchronized (list){
            while (capcity == list.size()){
                try {
                    System.out.println("队列已满，"+Thread.currentThread().getName()+"进入等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"存入消息："+message);
            list.addLast(message); // 消息加入队列尾部
            list.notifyAll();      // 唤醒所有等待线程
        }
    }

    // 消费消息
    public Message consume(){
        synchronized (list){
            while (list.isEmpty()){
                try {
                    System.out.println("队列为空，"+Thread.currentThread().getName()+"进入等待");
                    list.wait(); // 队列为空则进行等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = list.removeFirst(); // 从队列获取头部信息并返回
            list.notifyAll(); // 唤醒等待的线程
            System.out.println(Thread.currentThread().getName()+"消费消息："+message);
            return message;
        }
    }

}


// final，子类不能覆盖
final class Message{

    // 只在构造方法进行赋值，保证线程安全
    private int id;
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}

