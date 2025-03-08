package org.aplewa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Branch {
    public Branch(String name, String lastCommitSha) {
        this.name = name;
        this.lastCommitSha = lastCommitSha;
    }

    @JsonProperty("branchName")
    private String name;
    @JsonProperty("lastCommitSha")
    private String lastCommitSha;


    //getters setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastCommitSha() {
        return lastCommitSha;
    }

    public void setLastCommitSha(String lastCommitSha) {
        this.lastCommitSha = lastCommitSha;
    }
}
