package br.com.hytech.rhsouthsystem.service.associate;

import br.com.hytech.rhsouthsystem.model.Associate;
import br.com.hytech.rhsouthsystem.repository.AssociateRepository;
import br.com.hytech.rhsouthsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class AssociateService extends AbstractService<Associate, String, AssociateRepository> {

    public AssociateService(AssociateRepository repository) {
        super(repository);
    }

    public Associate hableToVote(String id){

        return null;

    }
}
