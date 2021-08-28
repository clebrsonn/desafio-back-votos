package br.com.hytech.rhsouthsystem.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Table
@Entity
@NoArgsConstructor
public class Session extends AbstractEntity{

    //(a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default

}
