package com.tv.docker.model;

import java.util.List;

public class StringSearchResponse {
    private int countOccurred;
    private List<Integer> positions;
    private String matchPattern;
    private List<String> matchString;
    private Response res;

    public StringSearchResponse(int countOccurred, List<Integer> positions, List<String> matchString, String matchPattern, Response res) {
        this.countOccurred = countOccurred;
        this.positions = positions;
        this.matchString = matchString;
        this.matchPattern = matchPattern;
        this.res = res;
    }

    public List<String> getMatchString() {
        return matchString;
    }

    public void setMatchString(List<String> matchString) {
        this.matchString = matchString;
    }

    public int getCountOccurred() {
        return countOccurred;
    }

    public void setCountOccurred(int countOccurred) {
        this.countOccurred = countOccurred;
    }

    public List<Integer> getPositions() {
        return positions;
    }

    public void setPositions(List<Integer> positions) {
        this.positions = positions;
    }

    public String getMatchPattern() {
        return matchPattern;
    }

    public void setMatchPattern(String matchPattern) {
        this.matchPattern = matchPattern;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    @Override
    public String toString() {
        return "StringSearchResponse{" +
                "countOccurred=" + countOccurred +
                ", positions=" + positions +
                ", matchPattern='" + matchPattern + '\'' +
                ", matchString=" + matchString +
                ", res=" + res +
                '}';
    }
}
