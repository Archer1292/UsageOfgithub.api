package example.github.api;

import github.api.ContributorToRepo;

import org.junit.Test;
import static org.junit.Assert.*;


public class ContributorToRepoTest {
    @Test
    public void contributorTest() {
        ContributorToRepo contributor = new ContributorToRepo("I", 100500);
        assertNotNull(contributor.getCommitsCount());
        assertEquals("\nI with 100500 commits", contributor.toString());
    }
}
