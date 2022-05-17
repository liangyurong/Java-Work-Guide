
如果文件内容不为空，则会覆盖

```jshelllanguage
package com.demo.nio_syn_channel;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class SynChannel {

    @Test
    public void writeByFuture() throws Exception {
        // 文件路径
        String filePath = "src/main/java/com/demo/nio_syn_channel/aa.txt";

        // 创建Path实例
        Path path = Paths.get(filePath);

        // 创建异步文件通道
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        // 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 将数据写入buffer
        buffer.put("教程真的很垃圾".getBytes());
        buffer.flip();

        Future<Integer> future = fileChannel.write(buffer, 0);

        while (!future.isDone()){

        }

        System.out.println("写入数据完成");

        buffer.clear();
        fileChannel.close();
    }

}
```