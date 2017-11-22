package github.api;

import lombok.Getter;


public class ContributorToRepo {
    private String name;
    @Getter
    private int commitsCount;

    public ContributorToRepo(String name, int commitsCount) {
        this.name = name;
        this.commitsCount = commitsCount;
    }

    @Override
    public String toString() {
        StringBuilder contributor = new StringBuilder();
        contributor.append("\n").append(name).append(" with ").append(commitsCount).append(" commits");
        return contributor.toString();
    }
}
