## 待解决

## 2021-09

vue能不能像SpringBoot一样，可以设置dev,prod,test的环境？

vue，能不能设置什么时候显示log，什么时候不显示log？

cdn加速是什么？为什么用cdn？

vue权限用异步加载是什么东西？

导航守卫是什么？

什么是钩子？什么作用？

vue官方文档，看一遍，照着手敲代码，不明白的地方一定要搞清楚。

## 什么时候使用 npm run dev ？ 什么时候使用 npm run serve ？ 

```text
npm run serve basically is just saying " npm please run the command I defined under the name serve in package.json " the same happens with npm run dev.

Given this the commands can do the exact same thing, similar things, or very different things. Usually they are a shorthand for running a dev server on localhost, but it’s not a rule, only a convention.

So you'll need to check in your package.json file and look for

"scripts": {
    "serve": "[list of commands here]",
    "dev": "[list of commands here]"
},
```
