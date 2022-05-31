next()不能得到带有空格的字符串

next()一定要督导有效的字符串才可以结束输入，在此之前遇到的空格，tab或者enter键都会自动忽略；
只有在输入有效字符之后，next才会将输入的空格或者tab作为分隔符，将enter作为结束符。

在next()方法中，输入  空格空格bhsd nsjd  sdh ，读取的是三个字符串

nextLine()方法的结束符只是Enter键

