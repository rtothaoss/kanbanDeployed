package academy.learnprogramming.kanban.exceptions;

import lombok.Getter;
import lombok.Setter;

public class ProjectNotFoundExceptionResponse {

    @Getter
    @Setter
    private String ProjectNotFound;

    public ProjectNotFoundExceptionResponse(String projectNotFound) {
        ProjectNotFound = projectNotFound;
    }
}
