

### local project is empty , and need to pull master of the github project to local (do it only once )

-  create new folder , named CodeDemo

- open terminal , and cd the CodeDemo folder path , just like as follows . (you can put the folder to the terminal and you will get the path)
 ```txt
 cd C:/user/lyr/CodeDemo
 ```
- and input the code as follows

```java
git init 

git remote add origin master https://github.com/LiangYurong/CodeDemo.git

git pull --rebase origin master
```

