## 集群中同时写入多个kv


mset k2 v2 k3 v3

    报错：(error) CROSSSLOT Keys in request don't hash to the same slot


解决：

    mset k2{user} v2 k3{user} v3

    通过keys * 得到： k2{user}  k3{user}