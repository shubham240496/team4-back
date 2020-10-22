package com.morningstar.mssearch.web.entity;

/**
 *
 */
public class SearchRequest {

    private String keyWords;
    private String sourceType;

    public String getKeyWords() { return keyWords; }

    public void setKeyWords(String keyWords) { this.keyWords = keyWords; }

    public String getSourceType() { return sourceType; }

    public void setSourceType(String sourceType) { this.sourceType = sourceType; }
}
