public class StringDemo {
    public static void main(String[] args) {

        // 等同String str = new String("aaa")
        String str = "aaa"; // str直接存储在栈内存中的常量池

        new StringDemo().print(str);
        System.out.println("main方法的str = "+str);
    }

    public void print(String str){
        str += "bbb";
        System.out.println("print方法的str = "+str);
    }

}

// 运行结果
//  print方法的str = aaabbb
//  main方法的str = aaa
