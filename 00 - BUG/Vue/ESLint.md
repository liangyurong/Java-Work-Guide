## ESLint:Initialization arror(ESLint).Cannot find module 'optionator'

bug：Initialization error (ESLint). Cannot find module 'optionator'

说明：导入新的vue项目，就会有这种提示。

解决
```text
1、删除node_module文件夹
2、webstorm打开terminal，输入 cnpm install (其实最好使用npm install，因为cnpm install可能会丢包)
```

## ESLint: Trailing spaces not allowed.(no-trailing-spaces)

原因:是因为vue-cli的eslint的语法规范导致的.你可以把eslint给关闭了.

解决:找到.eslintrc.js文件，或者使用ctrl+shirf+R，搜索'babel-eslint' (引号也一起搜索) ，打开，将'standard'注释

```text

```

## ESLint: Expected space or tab after '//' in comment.(spaced-comment)
    
原因：ESLint的语法检查，我们只需要禁用掉即可

解决：打开WebStorm，Settings - Languages & frameWorks - ESLint - 点击 Disable ESLint - 点击apply

或者：ctrl+shift+a ， 搜索ESLint , 点击 Disable ESLint ， 点击apply





















