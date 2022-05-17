
这个异步读取是怎么体现的呢？怎么表现出来？

    单线程体现不出来，那多线程怎么体现出来


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
    public void readByCompletionHandler() throws Exception {
        // 文件路径
        String filePath = "src/main/java/com/demo/nio_syn_channel/aa.txt";

        // 创建Path实例
        Path path = Paths.get(filePath);

        // 创建异步文件通道
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        // 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        fileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            // 读取成功会调用complete方法
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("result = "+result);
                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }
            // 读取失败会调用failed方法
            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("读取失败");
            }
        });

        fileChannel.close();
    }
}
```