package com.sdyb.aiyimei.test;

public class TestMain {
  public static void main(String[] args) {

    PostHandler aHandler = new APostHandler();
    PostHandler bHandler = new BPostHandler();

    // 设置ab的连接关系
    aHandler.setPostHandler(bHandler);

    // 请求者：设置评论内容
    Post post = new Post();
    post.setContent("正常内容 唱歌 跳舞 rap 篮球 点赞 关注 转发 三连");

    // 过滤内容
    System.out.println("过滤前的内容："+post.getContent());
    aHandler.handlerRequest(post);
    System.out.println("过滤后的内容："+post.getContent());




  }
}
