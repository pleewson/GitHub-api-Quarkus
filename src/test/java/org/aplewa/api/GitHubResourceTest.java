package org.aplewa.api;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class GitHubResourceTest {

    @Test
    void testGetUserRepositoriesHappyPath() {

        String username = "octocat"; // github.com/octocat

        given().pathParam("username", username)

                .when()
                .get("http://localhost:8080/git/{username}/repositories")

                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", greaterThan(0))
                .body("[0].owner.login", equalTo(username))
                .body("[0].branches.size()", greaterThan(0))
                .body("[0].branches[0].lastCommitSha", not(emptyString()));
    }
}