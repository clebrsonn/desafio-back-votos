package br.com.hytech.rhsouthsystem.model;

import br.com.hytech.rhsouthsystem.model.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Table
@Entity
@NoArgsConstructor
public class Rulling extends AbstractEntity {

    @Column(unique = true)
    private String name;
}
