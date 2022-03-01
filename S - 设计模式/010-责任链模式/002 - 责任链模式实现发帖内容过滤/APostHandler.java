package com.sdyb.aiyimei.test;

/** 具体的责任人对象 */
public class APostHandler extends PostHandler {
  @Override
  public void handlerRequest(Post post) {
    String content = post.getContent();
    content = content.replaceAll("点赞", "**").replaceAll("关注", "##").replaceAll("转发", "&&");
    post.setContent(content);
    System.out.println("过滤评论:点赞关注转发");
    next(post);
  }
}
