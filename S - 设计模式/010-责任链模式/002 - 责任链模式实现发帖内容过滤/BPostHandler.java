package com.sdyb.aiyimei.test;

/**
 * 具体责任人子类
 */
public class BPostHandler extends PostHandler{
    @Override
    public void handlerRequest(Post post) {
        String content = post.getContent();
        content = content.replaceAll("唱歌", "*sing*").replaceAll("跳舞", "#dance#").replaceAll("rap", "&rap&");
        post.setContent(content);
        System.out.println("过滤评论:唱歌跳舞rap");
        next(post);
    }
}
