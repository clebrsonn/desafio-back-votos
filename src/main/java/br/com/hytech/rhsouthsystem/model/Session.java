package br.com.hytech.rhsouthsystem.model;

import br.com.hytech.rhsouthsystem.model.entity.AbstractEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
@EqualsAndHashCode(callSuper = true)
public class Session extends AbstractEntity {

    //(a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default

    @ManyToOne
    @NotNull
    private Rulling rulling;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime openTime;

    @Column(nullable = false)
    private LocalDateTime closedTime;
}
