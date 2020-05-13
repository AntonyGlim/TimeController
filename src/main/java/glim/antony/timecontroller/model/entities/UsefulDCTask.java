package glim.antony.timecontroller.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "useful_dctasks_dates")
@Data
@NoArgsConstructor
public class UsefulDCTask implements Serializable {
    private static final long serialVersionUID = -90000082L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "date")
    LocalDate date;

    @Column(name = "useful")
    Boolean useful;
}

