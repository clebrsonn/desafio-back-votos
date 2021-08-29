package br.com.hytech.rhsouthsystem.resource.v1.dto;

import br.com.hytech.rhsouthsystem.enums.VoteChoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@Builder
public class VoteDTO {

    @NotNull
    private String associationId;

    @NotNull
    private Long session;

    @NotNull
    private VoteChoice choice;
}
