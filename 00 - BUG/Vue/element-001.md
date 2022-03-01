### 安装elementui

打开webstorm的terminal
```text
//先安装loader模块,使用npm安装可能会出现错误，用cnpm安装
cnpm install style-loader -D
cnpm install css-loader -D
cnpm install file-loader -D

//安装Element-ui模块
cnpm install element-ui --save
```

### vue中引用element-ui后，在打包后部署到centos服务器猴不显示图标问题

解决：在build文件夹中找到utils.js，再这个js文件中找到下面的代码，添加 publicPath: '../../'

参考
```js
    if (options.extract) {
      return ExtractTextPlugin.extract({
        use: loaders,
        fallback: 'vue-style-loader',
        // 解决部署到服务器上icon图标不显示的bug
        publicPath: '../../'
      })
    }
```
