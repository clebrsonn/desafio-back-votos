package br.com.hytech.rhsouthsystem.service.vote;

import br.com.hytech.rhsouthsystem.model.Vote;
import br.com.hytech.rhsouthsystem.resource.dto.VoteDTO;

public interface IVoteService{
    Vote vote(VoteDTO entity);


}
