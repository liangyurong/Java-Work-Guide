
```jshelllanguage
package com.demo.nio_syn_channel;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class SynChannel {
    @Test
    public void readByFuture() throws Exception{
        // 文件路径
        String filePath = "src/main/java/com/demo/nio_syn_channel/aa.txt";

        // 创建Path实例
        Path path = Paths.get(filePath);

        // 创建异步文件通道
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        // 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 调用channel的read方法得到Future
        Future<Integer> future = fileChannel.read(buffer, 0);

        // 判断是否完成
        while (!future.isDone()){
            // 异步读取，直到读取完成才释放
        }

        // 读取数据到buffer
        buffer.flip();
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(new String(data));
        buffer.clear();

        fileChannel.close();

    }
    
}
```