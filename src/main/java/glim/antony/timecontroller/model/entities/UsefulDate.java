package glim.antony.timecontroller.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "useful_dates")
@Data
@NoArgsConstructor
public class UsefulDate implements Serializable {
    private static final long serialVersionUID = -90000039L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "date")
    LocalDate date;

    @Column(name = "useful")
    Boolean useful;
}
