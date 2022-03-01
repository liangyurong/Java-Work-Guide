```
Windows Registry Editor Version 5.00
[HKEY_CLASSES_ROOT\.md]
@="MarkdownFile"
"PerceivedType"="text"
"Content Type"="text/plain"
[HKEY_CLASSES_ROOT\.md\ShellNew]
[HKEY_CLASSES_ROOT\MarkdownFile]
@="Markdown文档"
[HKEY_CLASSES_ROOT\MarkdownFile\DefaultIcon]
@="%SystemRoot%\system32\imageres.dll,-102"
[HKEY_CLASSES_ROOT\MarkdownFile\shell]
[HKEY_CLASSES_ROOT\MarkdownFile\shell\open]
```



1、新建一个txt文件，复制粘贴上面的内容

2、.txt后缀改为.reg后缀

3、双击reg文件，然后重启电脑。