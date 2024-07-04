package com.tv.docker.model;

import org.springframework.http.HttpStatusCode;

import java.util.List;

public class SortResponse {
    private List<Integer> sortResponse;
    private Response res;

    private SortResponse(){}

    @Override
    public String toString() {
        return "SortResponse{" +
                "sortResponse=" + sortResponse +
                ", res=" + res +
                '}';
    }

    public List<Integer> getSortResponse() {
        return sortResponse;
    }

    public void setSortResponse(List<Integer> sortResponse) {
        this.sortResponse = sortResponse;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public SortResponse(List<Integer> sortResponse, Response res) {
        this.sortResponse = sortResponse;
        this.res = res;
    }
}
