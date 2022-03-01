
### 原因

2021-08月，github不能通过账户密码连接进而push。因此只能采用ssh的方法进行连接。

### 如果一直push不上去，就在电脑重新设置ssh公钥

打开 Git Bash 并输入以下命令(用你的GitHub电子邮件地址替换命令中的电子邮件地址)
```text
ssh-keygen -t rsa -b 4096 -C "xxx@qq.com"
```

当看到以下命令提示时，按回车，就会把文件存在默认的路径下（可以改路径，改路径后，在后边的操作需要额外的操作，这里我不改路径）
```text
Enter a file in which to save the key (/c/Users/you/.ssh/id_rsa):
```

当看到以下命令提示时，输入自定义密码（不是GitHub密码），这个密码在连接GitHub时会用到，比如pull、push的时候
```txt
 > Enter passphrase (empty for no passphrase): [Type a passphrase]
 > Enter same passphrase again: [Type passphrase again]
```

确保生成成功
```txt
当在目录c/Users/you/.ssh/下看到刚才生成的文件时（id_rsa、id_rsa.pub），表示生成成功
```

打开c/Users/you/.ssh/id_rsa.pub文件手动复制

去github，setting - ssh and gpg keys - 新建一个公钥，粘贴进去

### push操作

来到文件夹，右键打开git bash

> git init

> git remote add origin git@github.com:xxx.git

如果更新仓库连接
> git remote set-url origin git@github.com:xxx.git

查看是否建立远程连接
> git remote -v

> git add .
> git commit -m 'message'
> git push -u origin master


















