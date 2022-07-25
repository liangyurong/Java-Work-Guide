### 配置npm

使用淘宝镜像配置npm

    去到node.js安装目录, 将npm.cmd中的prefix -g修改为 prefix --location=global 
    
    打开cmd，输入：npm config set registry http://registry.npm.taobao.org/

查看npm版本

    npm -v