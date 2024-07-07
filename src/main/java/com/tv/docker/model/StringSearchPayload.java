package com.tv.docker.model;

import java.util.List;

public class StringSearchPayload {
    private List<String> searchStrList;
    private String matchPattern;
    private String searchType;

    public StringSearchPayload(List<String> searchStrList,String matchPattern, String searchType) {
        this.searchStrList = searchStrList;
        this.matchPattern = matchPattern;
        this.searchType = searchType;
    }

    public String getMatchPattern() {
        return matchPattern;
    }

    public void setMatchPattern(String matchPattern) {
        this.matchPattern = matchPattern;
    }

    public List<String> getSearchStrList() {
        return searchStrList;
    }

    public void setSearchStrList(List<String> searchStrList) {
        this.searchStrList = searchStrList;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    @Override
    public String toString() {
        return "StringSearchPayload{" +
                "searchStrList=" + searchStrList +
                ", matchPattern='" + matchPattern + '\'' +
                ", searchType='" + searchType + '\'' +
                '}';
    }
}
