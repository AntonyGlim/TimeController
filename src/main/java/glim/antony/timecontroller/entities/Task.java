package glim.antony.timecontroller.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
//@TypeDef( typeClass = PostgreSQLIntervalType.class, defaultForType = Duration.class)
public class Task implements Serializable {
    private static final long serialVersionUID = -9892325227711419L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "is_done")
    private Boolean isDone;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "is_in_archive")
    private Boolean isInArchive;

    @Column(name = "is_canseled")
    private Boolean isCanseled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "total_time")
    private Long totalTime; //TODO FIX [4] - type Duration

    @Column(name = "until_time")
    private LocalDateTime untilTime;

    //TODO THINK about statuses
    public enum Status {
        NEW,
        IN_PROCESS,
        PAUSE,
        DONE,
        REJECTED
    }

    public enum Type {
        DAILY_CHECK_TASK,
        USEFUL_PROJECT,
        UNUSEFUL_PROJECT,
        BACKWARD_TIMER,
        THOUGHT,
        PLAN
    }

}
