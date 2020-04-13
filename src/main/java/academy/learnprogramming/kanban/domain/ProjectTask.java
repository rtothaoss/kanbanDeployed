package academy.learnprogramming.kanban.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class ProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Column(updatable = false, unique = true)
    @Getter @Setter private String projectSequence;
    @NotBlank(message = "Please include a project summary")
    @Getter @Setter private String summary;
    @Getter @Setter private String acceptanceCriteria;
    @Getter @Setter private String status;
    @Getter @Setter private Integer priority;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Getter @Setter private Date dueDate;
    @Column(updatable = false)
    @Getter @Setter private String projectIdentifier;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Getter @Setter private Date created_At;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Getter @Setter private Date updated_At;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "backlog_id", updatable = false, nullable = false)
    @JsonIgnore
    @Getter @Setter private Backlog backlog;

    public ProjectTask() {
    }

    @PrePersist
    protected void onCreate() {
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_At = new Date();
    }

    @Override
    public String toString() {
        return "ProjectTask{" +
                "id=" + id +
                ", projectSequence='" + projectSequence + '\'' +
                ", summary='" + summary + '\'' +
                ", acceptanceCriteria='" + acceptanceCriteria + '\'' +
                ", status='" + status + '\'' +
                ", priority=" + priority +
                ", dueDate=" + dueDate +
                ", projectIdentifier='" + projectIdentifier + '\'' +
                ", created_At=" + created_At +
                ", updated_At=" + updated_At +
                '}';
    }
}
