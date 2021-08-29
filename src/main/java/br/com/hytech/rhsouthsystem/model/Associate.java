package br.com.hytech.rhsouthsystem.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
@Entity
@NoArgsConstructor
public class Associate {

    @Id
    @CPF
    private String cpf;

    private String name;
}
