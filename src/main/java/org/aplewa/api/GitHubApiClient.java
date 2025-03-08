package org.aplewa.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.aplewa.dto.GitHubBranchResponse;
import org.aplewa.dto.GitHubRepositoryResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(baseUri = "https://api.github.com")
public interface GitHubApiClient {

    @GET
    @Path("/users/{username}/repos")
    @Produces(MediaType.APPLICATION_JSON)
    List<GitHubRepositoryResponse> getUserRepositories(String username);


    @GET
    @Path("/repos/{owner}/{repo}/branches")
    @Produces(MediaType.APPLICATION_JSON)
    List<GitHubBranchResponse> getRepositoryBranches(@PathParam("owner") String owner, @PathParam("repo") String repo);
}
