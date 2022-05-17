### redis中的hash对应的数据结构

两种：ziplist(压缩列表)，hashtable(哈希表)

field-value长度较短且个数较少时，使用ziplist ， 否则使用hashtable


