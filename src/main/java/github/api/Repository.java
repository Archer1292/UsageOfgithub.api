package github.api;

import lombok.Getter;
import lombok.Setter;
import java.lang.reflect.Field;


public class Repository {
    @Getter
    private String name;
    @Setter @Getter
    private int starsCount;
    private String description;
    private String language;
    @Setter @Getter
    private int commitsCount;
    @Setter @Getter
    private ContributorToRepo[] contributors;

    public Repository(String name, String description, String language) {
        this.name = name;
        this.description = description;
        this.language = language;
    }

    @Override
    public String toString() {
        StringBuilder repo = new StringBuilder();
        try {
            String fieldName;
            Object fieldValue;
            for (Field field : this.getClass().getDeclaredFields()) {
                fieldName = field.getName();
                fieldValue = field.get(this);
                if (fieldValue != null)
                    if (fieldValue instanceof String || (fieldValue instanceof Integer && (Integer)fieldValue != 0))
                        repo.append("\n").append(fieldName).append(": ").append(fieldValue);
            }
        }
        catch (IllegalAccessException e) {
            System.out.println("Some fields weren't retrieved!");
        }
        finally {
            if (contributors != null && contributors.length != 0) {
                repo.append("\nContributors:");
                for (ContributorToRepo contributor : contributors)
                    repo.append(contributor.toString());
            }
        }
        return repo.toString();
    }
}
