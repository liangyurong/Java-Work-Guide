## 没有package.json

在webstorm的terminal执行：npm init

## vue项目启动是4.4.4.3

其实并没有任何问题，随便

## "export 'default' (imported as 'router') was not found in './router'



将 import Router from 'vue-router' //引入 Vue 路由 . vue版本是2的时候，使用这个

换为：import * as Router from 'vue-router' ， 即可解决问题

##   warning  in ./node_modules/vue-router/dist/vue-router.esm-bundler.js

原因：

解决：

## This dependency was not found: * vue in ./node_modules/vue-router/dist/vue-router.esm-bundler.js, ./src/main.js and 14 others

没用：npm install vue-router

Error from chokidar (C:\): Error: EBUSY: resource busy or locked, lstat 'C:\pagefile.sys' 信息并不是问题本身。


## 不知道是什么错误

    * vue in ./node_modules/element-ui/lib/element-ui.common.js, ./node_modules/element-ui/lib/tooltip.js and 14 others

    To install it, you can run: npm install --save vue
    Error from chokidar (C:\): Error: EBUSY: resource busy or locked, lstat 'C:\hiberfil.sys'

出现原因：vue项目以前是加了token的，现在取消token了，然后就不行了。

说明：这个问题已经困扰我三个工作日了，根本就找不到解决的方法。（谷歌直接搜索bug信息无法解决）

原因：不清楚

解决：删除package-lock.json文件。在git上把package.json的配置放到现有的package.json，然后删除node_modules文件夹，再npm install

### npm WARN XXX@1.0.0 No description

背景：删除了vue项目的package-lock.json文件，结果输入npm install命令的时候出错‘

原因：不清楚

解决：删除package-lock.json文件。在git上把package.json的配置放到现有的package.json，然后删除node_modules文件夹，再npm install

## Uncaught TypeError: __WEBPACK_IMPORTED_MODULE_1_vue_router__ is not a constructor

原因：引入vue-router错误。使用的vue版本是：2.9.6

解决：
```text
import Router from 'vue-router'  // 会报错：import * as Router from 'vue-router'
```

## 拿一个vue项目，直接输入npm install，出现错误信息

错误信息
```text
npm ERR! code ELIFECYCLE
npm ERR! errno 1
npm ERR! node-sass@4.12.0 postinstall: `node scripts/build.js`
npm ERR! Exit status 1
npm ERR!
npm ERR! Failed at the node-sass@4.12.0 postinstall script.
npm ERR! This is probably not a problem with npm. There is likely additional logging output above.

npm ERR! A complete log of this run can be found in:
npm ERR!     C:\Users\lyr\AppData\Roaming\npm-cache\_logs\2021-09-24T02_59_56_048Z-debug.log
```

关键错误信息
```text
npm ERR! Failed at the node-sass@4.12.0 postinstall script.
```

原因：是因为node-sass已被启用吗？

解决：删除package-lock.json文件，删除node_modules文件夹，然后npm install


## npm ERR! missing script: dev

原因：

解决：npm run serve （不是npm run server）

## resource busy or locked

bug信息
```text
Error from chokidar (C:\): Error: EBUSY: resource busy or locked, lstat 'C:\hiberfil.sys'

Error from chokidar (C:\node_modules): Error: EBUSY: resource busy or locked, lstat 'C:\hiberfil.sys'
```

背景：在项目中，引入了其他项目的一些模块，然后npm run serve的时候出现上面的bug信息。‘

解决：删除node_modules文件夹，重新npm install


## 无法删除node_modules文件夹

bug信息
```text
\node_modules\node-sass\vendor\win32-x64-83\binding.node
```

原因：node_modules文件夹中有node-sass文件夹

解决：除了node-sass文件夹，其他文件夹全部删除，然后在terminal输入：npm install

解决方法2
```text
安装：npm install rimraf -g

删除：rimraf node_modules

```

## net::err_unknown_url_scheme

问题是:没有加入"http://"这个头,因此访问不到.

解决：加入http://

以前的错误写法：'lhzh.sdyunban.com:49810/renren-admin/'

正确写法：'http://lhzh.sdyunban.com:49810/renren-admin/'
