package com.lyr.demo.decorate;

/**
 * 工厂类，提供Computer
 */
public class ComputerFactory {

    public Computer createComputer(String name){
        Computer computer = null;
        if(name.equals("a")){
            computer = new ComputerA();
        }else {
            computer = new ComputerB();
        }
        return computer;
    }

}
