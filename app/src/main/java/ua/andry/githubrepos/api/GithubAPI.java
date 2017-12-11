package ua.andry.githubrepos.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.andry.githubrepos.models.ReposList;
import ua.andry.githubrepos.models.User;

/**
 * Created by shink on 10.12.2017.
 */

public interface GithubAPI {

    @GET("/search/repositories")
    Call<ReposList> getRepos(@Query("q") String nameOfRepository);

    @GET("/users/{user}")
    Call<User> getFollowers(@Query("user") String username);
}
