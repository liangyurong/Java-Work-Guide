
第一种

        // 读取数据写到buffer中 (返回的int值代表有多少字节读到了buffer中)  read to buffer
        int bytesRead = channel.read(buffer);

第二种

        // 将数据写入缓冲区
        buffer.put(newData.getBytes());