## 撤销尚未push的commit


### 思路

1、git log 

     找到想要撤销的id。
  
2、git reset --hard id   （代码回滚）
    
    完成撤销，同时将代码恢复到前commit_id 对应的版本，强制回滚到之前的版本。
    
3、git reset id  （强制回退，谨慎操作）
    
    完成撤销，停留在当前版本，不对代码修改进行撤销，可以直接通过git commit重新提交对本地代码的修改。

### git 命令行

git reset --soft HEAD^

### idea 操作

VCS -> Git -> Respository -> Reset HEAD -> 把to commit里面的head改为head^ -> 点击reset即可

补充：head^代表撤销一次commit

### tortoisegit 操作步骤

1、右键 -> tortoiseGit -> revert

2、这样子会回退代码    
