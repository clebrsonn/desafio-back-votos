package br.com.hytech.rhsouthsystem.model;

import br.com.hytech.rhsouthsystem.model.entity.AbstractEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

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

    @Column(nullable = false)
    private Long duration;

    private boolean isClosed = false;

    public void setDuration(Long duration) {
        this.duration = duration;
        if(duration == null || duration <=0){
            this.duration = 1L;
        }
        setClosedTime(getOpenTime().plusMinutes(getDuration()));
    }

    public void setOpenTime(LocalDateTime openTime) {
        this.openTime = openTime;
        if(openTime == null){
            this.openTime = LocalDateTime.now();
        }
    }

    public LocalDateTime getOpenTime() {

        return Objects.isNull(openTime) ? LocalDateTime.now() : openTime;
    }
}
