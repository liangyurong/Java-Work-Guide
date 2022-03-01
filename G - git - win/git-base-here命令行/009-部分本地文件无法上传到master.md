### 1、background

Some local folders cannot be uploaded to gitlab .

### 2、not upload folder

docker folder

node folder

### 3、reason

check .gitignore file , and found that the directory names of the two files are inside . 

### 4、solve

delete the directory names of the two files , and push again .

```java
git add . 

git commit -m 'upload docker folder and node folder'

git push -u origin
```

