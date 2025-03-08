package org.aplewa.rest;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aplewa.model.*;
import org.aplewa.service.GitHubService;

import java.util.List;

@Path("/git")
public class GitHubResource {
    private final GitHubService gitHubService;

    @Inject
    public GitHubResource(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }


    @GET
    @Path("/{username}/repositories")
    @Produces(MediaType.APPLICATION_JSON)
    @Blocking
    public Uni<Response> getUserRepositories(@PathParam("username") String username) {
         List<Repository> repositories = gitHubService.getUserRepositories(username);

        if (repositories.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse(404, "User not found");
            return Uni.createFrom().item(Response.status(Response.Status.NOT_FOUND)
                    .entity(errorResponse)
                    .build());
        }

        return Uni.createFrom().item(Response.ok(repositories)
                .build());
    }
}
