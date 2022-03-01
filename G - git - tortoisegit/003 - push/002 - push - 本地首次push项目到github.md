
## 本地首次push项目到github

永久网页链接:http://archive.today/ZTft0

## 首次push项目到github，步骤

1、git init : 右键点击“git create repository here”，一定不要勾选“make it bare ”，一定不要勾选，直接点击确定

2、右键，点击“git commit -> master"，在message输入commit的备注信息，在check下面点击all，就可以勾选全部的文件，然后点击commit(首次commit可能需要等待时间)

3、右键，点击“Tortoise git”，点击“push”，会出现一个对话框

    3.1 Local和Remote都填写master

    3.2 点击Deatination的Manage，弹出新框

    3.3 remote填写gitlab，URL和PushUrl都填写gitlab项目的http地址，不需要勾选任何东西，然后一直点击ok即可
    
    3.4 选择putty key（第一次需要设置，以后push新的仓库直接选择即可）
    
    3.5 push的时候可能要输入账号和密码

## 再次push
