package github.api;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        long time = System.nanoTime();
        try {
            testGitHubHandler();
        }
        catch (IOException e) {
            System.out.println("Wasn't able to retrieve full information");
        }
        System.out.println((System.nanoTime() - time) * Math.pow(10, -6) + " millisec");
        getMemoryConsumption();
    }

    private static void testGitHubHandler() throws Exception {
        GitHubHandler handler = new GitHubHandler();
        Repository[] starredRepos = handler.getTop10StarredRepos();
        for (Repository starredRepo : starredRepos) {
            starredRepo.setContributors(handler.getTop5ReposContributors(starredRepo));
            System.out.println(starredRepo);
        }
        Repository[] committedRepos = handler.getTop10CommitedRepositoriesInWeek(5);
        for (Repository committedRepo : committedRepos) {
            committedRepo.setContributors(handler.getTop5ReposContributors(committedRepo));
            System.out.println(committedRepo);
        }
    }

    private static void getMemoryConsumption() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.printf("Memory used: %d B \n", memory);
    }
}
