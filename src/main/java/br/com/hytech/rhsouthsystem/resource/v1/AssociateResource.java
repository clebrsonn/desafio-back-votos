package br.com.hytech.rhsouthsystem.resource.v1;

import br.com.hytech.rhsouthsystem.model.Associate;
import br.com.hytech.rhsouthsystem.service.associate.AssociateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/associates")
public class AssociateResource extends AbstractController<Associate, String, AssociateService>{
    public AssociateResource(AssociateService associateService) {
        super(associateService);
    }
}
