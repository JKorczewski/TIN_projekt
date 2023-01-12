package database.entity.groupSubject;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Grupa_Przedmiot")
public class GroupSubjectEntity {

    @EmbeddedId
    private GroupSubjectId groupSubjectId;
    @Column(name = "Dzien_Tygodnia")
    private String weekday;
    @Column(name = "Godzina")
    private String hour;


}
