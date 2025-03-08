package org.aplewa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Repository {
    public Repository(String name, Owner owner, List<Branch> branches) {
        this.name = name;
        this.owner = owner;
        this.branches = branches;
    }

    @JsonProperty("repoName")
    private String name;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("branches")
    private List<Branch> branches;


    //getters setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
