### 1. 需求

公司用内网搭建的gitlab。我自己的项目用github。因此需要git使用ssh同时连接github和gitlab。

确定默认主账号，推荐使用公司邮箱，因为主要还是用公司邮箱推送代码到 gitlab 仓库进行开发。

**全局默认配置** : 下面的name和email对应的是公司的gitlab的名称和邮箱。github对应的是xxx和xxx@qq.com.(在config文件中有设置)


```java
//去到ssh的目录：/Users/用户名/.ssh，右键选择git base here，输入下面的代码。

git config --global user.name 'liangyurong' && git config --global user.email 'liangyurong@qq.com'
```

### 2. 生成公钥和私钥，主 gitlab 账号直接使用常见的 ssh-keygen -t rsa -C方法, 副账号需要指定生成的文件名。默认的ssh目录为/Users/用户名/.ssh，如有不同则下面的目录需要手动改正。

```java
# 生成默认 gitlab 主账户，公司日常开发用
ssh-keygen -t rsa -C "liangyurong@qq.com"

# 生成副账号 github 的公钥、密钥，同时指定文件名
ssh-keygen -t rsa -f ~/.ssh/github_rsa -C "liangyurong@qq.com"
```

生成的文件有

```txt

github_rsa

github_rsa.pub

id_rsa

id_rsa_pub

```

### 3. 增加config文件。名称就是config，没有任何后缀。

对于如何让 github 和 gitlab 识别不同的公钥、密钥，下面需要进行最重要的一步，增加配置文件（config），用于代码仓库来判断该使用何种的公钥、密钥进行比对。

新建好 config 配置文件后，添加如下内容到 config 配置文件中（副账号为 github），

```jav
Host *github.com
     IdentityFile ~/.ssh/github_rsa
     User xxx
```
### 4. 上传 ssh key

登陆各自的 github 和 gitlab账户,在各自的 github 和 gitlab 的账号设置中添加 ssh key。步骤为

1.登陆账户成功之后 => 点击自己的头像 => setting => Add SSH Key

2.主账号 gitlab 中的 ssh key 粘贴 id_rsa.pub 文件中的内容

3.副账号 github 中的 ssh key 粘贴 id_rsa.github.pub 文件中的内容

### 5. 测试连接（因为gitlab是内网的，测试失败也没关系）

在目录：C:\Users\lyr\.ssh，右键选择git base here

```java

ssh -T git@github.com  //测试连接github

ssh-keyscan -t rsa github.com >> ~/.ssh/known_hosts //若连接失败，则输入这行代码,生成known_hosts文件，然后再连接

ssh -T git@gitlab.com # 测试连接 gitlab（测试不成功也没关系，直接去项目中）
```

### 6. 在公司内网的gitlab新建一个仓库为test

仓库的http连接为：http://localhost:8888/liangyurong/test.git

- 同时连接gitlab和github的话，每次新建本地项目要push到远程仓库，都需要设置name，email，还有remote命令。下一次操作就没必要设置了。直接add,commit,push即可。

- 本地电脑新建一个test文件夹，在里面新建一个test.txt测试文件，

- 在test文件夹里面右键，选择git base here

- 输入命令

```java
git init

git config --global user.name "liangyurong"

git config --global user.email "liangyurong@qq.com"

git remote add origin http://main.sdyunban.com:8888/liangyurong/test.git

git add .

git commit -m '1'

git push -u origin --all

```

### 7. 在github新建一个仓库为test

- 仓库的http连接为：https://github.com/LiangYurong/test.git

- 同时连接gitlab和github的话，每次新建本地项目要push到远程仓库，都需要设置name，email，还有remote命令。下一次操作就没必要设置了。直接add,commit,push即可。

- 本地电脑新建一个test文件夹，在里面新建一个test.txt测试文件，

- 在test文件夹里面右键，选择git base here

- 输入命令

```java
git init

git config --global user.name "xxx" //对应config文件设置的user名称

git config --global user.email "xxx@qq.com"

git remote add origin https://github.com/LiangYurong/test.git

git add .

git commit -m '11'

git push -u origin --all
```
