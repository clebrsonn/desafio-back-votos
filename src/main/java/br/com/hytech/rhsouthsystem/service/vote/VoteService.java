package br.com.hytech.rhsouthsystem.service.vote;

import br.com.hytech.rhsouthsystem.model.Vote;
import br.com.hytech.rhsouthsystem.repository.VoteRepository;
import br.com.hytech.rhsouthsystem.resource.EntityRequest;
import br.com.hytech.rhsouthsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class VoteService extends AbstractService<Vote, Long, VoteRepository> implements IVoteService{
    protected VoteService(VoteRepository repository) {
        super(repository);
    }

    @Override
    public Vote vote(EntityRequest entity) {
        return null;
    }
}
