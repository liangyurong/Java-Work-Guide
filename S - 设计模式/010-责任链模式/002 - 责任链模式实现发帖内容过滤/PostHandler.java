package com.sdyb.aiyimei.test;

import javafx.geometry.Pos;

/** 责任人的抽象类角色：处理器父类 */
public abstract class PostHandler {

  /** 该类的下一个节点（参考链表的下一节点，是相同的思想） */
  private PostHandler postHandler;

  /** 设置该类的子类 */
  public void setPostHandler(PostHandler postHandler) {
    this.postHandler = postHandler;
  }

  /** 处理过滤评论的请求。不同子类有不同的过滤需求，子类需要具体处理，所以这里需要设置为抽象类 */
  public abstract void handlerRequest(Post post);

  /**
   * 传递，让下一个节点处理请求
   */
  protected final void next(Post post) {
    // 如果不为空，则继续处理请求
    if (null != this.postHandler) {
      this.postHandler.handlerRequest(post);
    }
  }
}
