## The remote SSH server rejected X11 forwarding request

bug

    xshell无法连接到vm

解决

    进入vm命令行：vi /etc/ssh/sshd_config

    修改参数：X11Forwarding参数为yes

    去掉注释：UseLogin参数为no