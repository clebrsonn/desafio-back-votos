package br.com.hytech.rhsouthsystem.service.vote;

import br.com.hytech.rhsouthsystem.model.Vote;
import br.com.hytech.rhsouthsystem.resource.EntityRequest;

public interface IVoteService{
    Vote vote(EntityRequest entity);


}
