package br.com.hytech.rhsouthsystem.model;

import br.com.hytech.rhsouthsystem.enums.VoteChoice;
import br.com.hytech.rhsouthsystem.model.entity.AbstractEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@ToString
@Table(uniqueConstraints = {
            @UniqueConstraint(columnNames = {"cd_associate", "cd_session"})
        })
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vote extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "cd_associate")
    @NotNull
    private Associate associate;

    @ManyToOne
    @JoinColumn(name = "cd_session")
    @NotNull
    private Session session;

    @Enumerated(EnumType.STRING)
    @NotNull
    private VoteChoice choice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Vote vote = (Vote) o;

        return Objects.equals(getId(), vote.getId());
    }

    @Override
    public int hashCode() {
        return 1634544760;
    }
}
