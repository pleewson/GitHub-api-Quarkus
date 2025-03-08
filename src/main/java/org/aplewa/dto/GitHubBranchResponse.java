package org.aplewa.dto;

import org.aplewa.model.Commit;

public class GitHubBranchResponse {
    private String name;
    private Commit commit;


    //getters setters
    public String getName() {
        return name;
    }

    public Commit getCommit() {
        return commit;
    }
}
