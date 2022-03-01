

### recommend

直接在IDEA点击merge按钮来更新即可。


### the master of gitlab project has been updated , but my local project has not updated. so i need to merge latest code to my local project 

```java
//Query the current remote version
$ git remote -v

//Get the latest code to the local
$ git fetch origin master  

//View version differences
$ git log -p master..origin/master

//Merge the latest code to the local branch
$ git merge origin/master 
```
if shows warning message

```java
Please enter a commit message to explain why this merge is necessary, especially if it merges an updated upstream into a topic branch
```
and then 
```java
input : git stash save ""

and try merge again

```




