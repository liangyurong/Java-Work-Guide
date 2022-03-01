
### 步骤

1. 关闭Navicat Premium 12；

2. 然后 win+R，输入regedit 回车，打开注册表编辑器；

3. 展开HKEY_CURRENT_USER\Software\PremiumSoft\Data。删除这个Data文件夹

4. 展开HKEY_CURRENT_USER\Software\Classes\CLSID。展开子目录，如果某个文件夹爱里面只包含一个名为Info的文件夹，就删掉它。（可能有很多文件夹都有info文件夹，那就都删掉info文件夹）
// 第四步骤非常麻烦，因为你遇到的文件夹数量可能非常多

5. 关闭注册表，重新打开Navicat Premium 12即可。
