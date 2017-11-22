package example.github.api;

import github.api.GitHubHandler;
import github.api.Repository;

import org.junit.*;
import static org.junit.Assert.*;


public class GitHubHandlerTest {
    private GitHubHandler handler = new GitHubHandler(System.getenv("GITHUB_TOKEN"));

    @Test
    public void getTop10StarredRepos() throws Exception {
        Repository[] repos = handler.getTop10StarredRepos();
        assertNotNull(repos);
        for (Repository repository : repos) {
            repository.setContributors(handler.getTop5ReposContributors(repository));
            assertNotNull(repository.getContributors());
            assertNotNull(repository.toString());
        }
    }

    @Test
    public void getTop10CommitedRepositoriesInWeek() throws Exception {
        Repository[] repos = handler.getTop10CommitedRepositoriesInWeek(1);
        assertNotNull(repos);
        for (Repository repository : repos) {
            repository.setContributors(handler.getTop5ReposContributors(repository));
            assertNotNull(repository.getContributors());
            assertNotNull(repository.toString());
        }
    }
}