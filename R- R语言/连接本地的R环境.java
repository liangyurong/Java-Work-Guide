package com.zteict.rhin.research.test;

import org.rosuda.REngine.Rserve.RConnection;


/** 操作步骤
 * 安装RStudio，在电脑的环境变量设置两个变量：R_HOME（C:\Program Files\R\R-4.0.4）; path中追加(C:\Program Files\R\R-4.0.4\bin)
 *
 * 安装Rserve：打开R.exe，执行命令：install.packages("Rserve", repos = "https://mirrors.ustc.edu.cn/CRAN/")
 *
 * 生成的Rserve文件夹，将这个文件夹复制到R的library路径：C:\Program Files\R\R-4.0.4\library
 *
 * 进入C:\Program Files\R\R-4.0.4\bin，双击R.exe，输入命令：library(Rserve) 和 Rserve()，启动Rserve之后，然后执行下面的方法
 */

// 测试连接R（测试成功）
public class TestConnectRServer {

    public static void main(String[] args) {
        RConnection rcon = null;
        try {
            // 建立与 Rserve 的连接
            rcon = new RConnection("127.0.0.1");

            // eval() 函数用于令 R 执行 R 语句
            // 此处制造了一个 m1 矩阵
            rcon.eval("m1 = matrix(c(1, 2, 3, 4), 2, 2, byrow=TRUE)");

            // solve() 函数在 R 中求 m1 矩阵的逆矩阵
            // 并将结果返回，asDoubleMatrix 函数可以将数据转换成
            // Java 中的 double 二维数组以表示矩阵
            double[][] m1 = rcon.eval("solve(m1)").asDoubleMatrix();

            // 输出矩阵的内容
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    System.out.print(m1[i][j] + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rcon != null){
                rcon.close();
            }
        }
    }

}
