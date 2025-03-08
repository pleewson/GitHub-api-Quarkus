package org.aplewa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aplewa.model.Owner;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubRepositoryResponse {
    private String name;
    private Owner owner;
    private boolean fork;


    //getters setters
    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }

    public boolean isFork() {
        return fork;
    }
}
