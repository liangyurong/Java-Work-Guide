## 在linux下修改只读型文件

bug

    不能访问互联网要修改 /etc/sysconfig/network-scripts / ifcfg-ens33文件，

解决

    开始时使用sudo vim  ifcfg-ens33 命令编辑，提示权限不足

    切换为root用户 su root 然后执行 sudo vim  ifcfg-ens33 可以进入编辑，编辑后ESC+：WQ保存成功


