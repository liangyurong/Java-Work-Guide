
## 拉取最新代码但本地已更新部分代码故无法pull

拉取最新代码但本地已更新无法pull，会报错
```text
git pull: Please commit your changes or stash them before you merge
```

解决
```text

打开TortoiseGit - commit,添加信息，但是千万不要push

情况一：pull最新的代码下来，如果没有冲突，最好情况。然后直接push自己之前commit的代码上去即可。

情况二：pull最新的代码下来，有代码冲突，则可以修改代码，把自己需要的保存下来，（没有具体实操）


```
