### Pull the branch of the gitlab project to the local 

- on gitlab website , create new branch , named " **lyr** " . 
- in local computer , create new folder , named " **test** " . 
- in the test folder ,  right click to select " **git bash here** " .
- enter following code .

```txt
git init

git remote add origin http://main.yurong333.com:8888/lyr/hello.git // replace with your http link 
```

- Pull the remote designated branch
```
git fetch origin lyr
```

- create a new loccal branch and associate to the specified remote branch .
```
git checkout -b lyr origin/lyr
```

- finish .
