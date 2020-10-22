package com.morningstar.mssearch.web.entity;

/**
 *
 */
public class Post {

    private String title;
    private String content;
    private String sourceType;
    private String url;
    private String createTime;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getCreateTime() { return createTime; }

    public void setCreateTime(String createTime) { this.createTime = createTime; }
}
