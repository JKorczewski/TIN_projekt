package database.entity.groupSubject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class GroupSubjectId implements Serializable {

    @Column(name = "Id_Grupy")
    private Long groupId;
    @Column(name = "Id_Przedmiotu")
    private Long subjectId;

}
