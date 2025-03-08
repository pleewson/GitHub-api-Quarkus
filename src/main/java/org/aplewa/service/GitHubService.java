package org.aplewa.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.aplewa.api.GitHubApiClient;
import org.aplewa.model.Branch;
import org.aplewa.dto.GitHubRepositoryResponse;
import org.aplewa.model.Repository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class GitHubService {
    private final GitHubApiClient gitHubApiClient;

    public GitHubService(@RestClient GitHubApiClient gitHubApiClient) {
        this.gitHubApiClient = gitHubApiClient;
    }


    public List<Repository> getUserRepositories(String username) {
        try {
            return gitHubApiClient.getUserRepositories(username).stream()
                    .filter(repo -> !repo.isFork())
                    .map(this::mapToRepository)
                    .toList();
        } catch (Exception ex) {
            throw new RuntimeException("Error while fetching repositories", ex);
        }
    }


    private Repository mapToRepository(GitHubRepositoryResponse repo) {
        List<Branch> branches = getBranchesForRepository(repo);
        return new Repository(repo.getName(), repo.getOwner(), branches);
    }


    private List<Branch> getBranchesForRepository(GitHubRepositoryResponse repo) {
        try {
            return gitHubApiClient.getRepositoryBranches(repo.getOwner().getLogin(), repo.getName()).stream()
                    .map(branch -> new Branch(branch.getName(), branch.getCommit().getSha()))
                    .toList();
        } catch (Exception ex) {
            throw new RuntimeException("Error while fetching repositories branches", ex);
        }


    }
}
