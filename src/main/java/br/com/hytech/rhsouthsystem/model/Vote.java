package br.com.hytech.rhsouthsystem.model;

import br.com.hytech.rhsouthsystem.enums.VoteChoice;
import br.com.hytech.rhsouthsystem.model.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(uniqueConstraints = {
            @UniqueConstraint(columnNames = {"cd_associate", "cd_session"})
        })
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Vote extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "cd_associate")
    private Associate associate;

    @ManyToOne
    @JoinColumn(name = "cd_session")
    private Session session;

    @Enumerated(EnumType.STRING)
    private VoteChoice choice;

}
