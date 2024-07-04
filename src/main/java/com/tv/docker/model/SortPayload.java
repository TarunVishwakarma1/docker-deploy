package com.tv.docker.model;

import java.util.List;

public class SortPayload {

    private List<Integer> sortArr;

    private String sortType;

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public List<Integer> getSortArr() {
        return sortArr;
    }

    public void setSortArr(List<Integer> sortArr) {
        this.sortArr = sortArr;
    }

    public SortPayload(List<Integer> sortArr, String sortType) {
        this.sortArr = sortArr;
        this.sortType = sortType;
    }

    public SortPayload() {
    }

    @Override
    public String toString() {
        return "SortPayload{" +
                "sortArr=" + sortArr +
                '}';
    }
}
