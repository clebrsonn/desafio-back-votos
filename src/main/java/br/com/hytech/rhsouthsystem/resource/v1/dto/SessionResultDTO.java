package br.com.hytech.rhsouthsystem.resource.v1.dto;

import br.com.hytech.rhsouthsystem.enums.VoteChoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionResultDTO {

    private Long sessionId;

    private Long total;

    private Map<VoteChoice, Long> votesByType;

}
