package br.com.hytech.rhsouthsystem.resource.v1;

import br.com.hytech.rhsouthsystem.model.Rulling;
import br.com.hytech.rhsouthsystem.service.rulling.RullingService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RullingResource extends AbstractController<Rulling, Long, RullingService> {

    public RullingResource(RullingService service) {
        super(service);
    }


}
