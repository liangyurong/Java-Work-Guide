
### 一、在项目index.html同级目录下添加favicon.ico文件

### 二、在项目index.html中引入

添加的代码
```vue
 <link rel="icon" href="./favicon.ico"  type="image/x-icon"> <!--title图标-->
```

示例代码
```vue
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>问卷</title>
    <link rel="icon" href="./favicon.ico"  type="image/x-icon"> <!--title图标-->
  </head>
  <body>
    <div id="app"></div>
    <!-- built files will be auto injected -->
  </body>
</html>
```

### 三、配置webpack配置文件(build文件夹下面)

操作：在下面两个配置文件中加入：favicon: path.resolve('./favicon.ico');

webpack.dev.conf.js
```vue
new HtmlWebpackPlugin({
    filename: config.build.index,
    template: 'index.html',
    favicon: path.resolve('./favicon.ico'),
    inject: true,
}),
```
webpack.prod.config.js
```vue
new HtmlWebpackPlugin({
      filename: process.env.NODE_ENV === 'testing'
        ? 'index.html'
        : config.build.index,
      template: 'index.html',
      favicon: path.resolve('./favicon.ico'),
      inject: true,
      minify: {
        removeComments: true,
        collapseWhitespace: true,
        removeAttributeQuotes: true
        // more options:
        // https://github.com/kangax/html-minifier#options-quick-reference
 })
```
### 四、重新运行项目或者打包

npm run dev

npm run build
