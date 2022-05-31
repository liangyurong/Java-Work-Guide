## String为什么被final修饰

    public final class String{}

如果没有final修饰，子类就可能重写String的某个方法，造成线程不安全