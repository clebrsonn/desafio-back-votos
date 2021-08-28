package br.com.hytech.rhsouthsystem.entity;

import br.com.hytech.rhsouthsystem.enums.VoteChoice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Vote extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "cd_associate")
    private Associate associate;

    @ManyToOne
    private Session session;

    @Enumerated(EnumType.STRING)
    private VoteChoice choice;

}
