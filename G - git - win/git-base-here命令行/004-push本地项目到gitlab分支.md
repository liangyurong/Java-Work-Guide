### Push the local project to the gitlab branch

- 首先进行操作：**拉取gitlab分支项目到本地，然后再更新项目，最后再push最好**。

- 拉取分支项目到本地后，然后更新文件，之后再输入下面的代码

- 输入：git add .

- 输入：git commit -m "写上你需要补充的信息"

- 连接到远程仓库：git remote add origin http://main.yurong333.com:8888/lyr/hello.git

- push到远程分支，lyr是分支名称：git push -u origin lyr