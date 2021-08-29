package br.com.hytech.rhsouthsystem.service.associate;

import br.com.hytech.rhsouthsystem.model.Associate;
import br.com.hytech.rhsouthsystem.repository.AssociateRepository;
import br.com.hytech.rhsouthsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class AssociateService extends AbstractService<Associate, String, AssociateRepository> {
    private final CPFValidator cpfValidator;

    public AssociateService(AssociateRepository repository, CPFValidator cpfValidator) {
        super(repository);
        this.cpfValidator = cpfValidator;
    }

    @Override
    public Associate validateSave(Associate associate) {
        return associate;
    }

    public Associate hableToVote(String id){

        Associate associate = findById(id).orElseThrow();
        cpfValidator.validate(associate.getCpf());

        return associate;
    }

}
