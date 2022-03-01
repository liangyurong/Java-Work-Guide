### 一、缓冲区

缓冲区是为了提高流的操作效率，创建缓冲区之前必须有流对象

缓冲区的本质是封装了数组

关闭缓冲区，就是在关闭缓冲区中的流对象、因此使用了r.close()就不必再写fr.close()

有一个新的方法，newLine()，写入一个行分隔符。这是一个跨平台的方法。

只要用了缓冲区，写入数据之后就要记得刷新，flush（）

### 二、BufferReader

从字符输入流中读取文本，缓冲各个字符，从而实现字符，数组和行的高效率读取

可以指定缓冲区的大小

### 三、BufferedWrite

可以指定缓冲区的大小

```text
bufferedWriter bf = new bufferedWriter(Writer out );

//写入单个字符
void write(char ch);

//写入字符数据的某一部分。
void write(char []cbuf,int off,int length)

//写入字符串的某一部分
void write(String s,int off,int length)

//写入一个行分隔符
void newLine()

//刷新该流中的缓冲。将缓冲数据写到目的文件中去。
void flush()

//关闭此流，在关闭前会先刷新他
void close()
```
























