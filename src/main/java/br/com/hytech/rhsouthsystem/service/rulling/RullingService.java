package br.com.hytech.rhsouthsystem.service.rulling;

import br.com.hytech.rhsouthsystem.model.Rulling;
import br.com.hytech.rhsouthsystem.repository.RullingRepository;
import br.com.hytech.rhsouthsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class RullingService extends AbstractService<Rulling, Long, RullingRepository> {

    public RullingService(RullingRepository repository) {
        super(repository);
    }

    @Override
    public Rulling validateSave(Rulling rulling) {
        return rulling;
    }


}
