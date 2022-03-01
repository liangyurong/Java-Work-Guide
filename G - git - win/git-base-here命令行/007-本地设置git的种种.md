### 1、use local computer connect to git ( only need to operate once )

- download and install git .
- create a new folder , and give the folder a name whatever you want.
- right click to select "git bash here" , input the following code.

```java
git init
    
git config --global user.name "your name" 
    
git config --global user.email "your email"
```

- on local computer , use Listary APP to search "id_rsa.pub" ,  open it and copy everthing inside . 
- on  gitlab website , click "**add new SSH keys**" , paste what you have copy before , and save .

### 2、if ssh invalid or  failed to connect to gitlab website 

- delete the **known_host** file at the same level  as id_rsa.pub .  (use Listary APP to search "known_host" )
- in ssh folder ,  right click to select "git bash here" , enter the following code .

```java
ssh-keygen -t rsa -C 'your email' 
```

- and reset the SSH keys on gitlab website . (just delete old ssh key and add new ssh key)

### 3、in the future , you only need to execute the following code to submit your source code 

```java
git add .
    
git commit -m 'commit message'
    
git push -u origin master    
```

