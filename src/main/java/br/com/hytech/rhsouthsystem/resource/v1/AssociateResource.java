package br.com.hytech.rhsouthsystem.resource.v1;

import br.com.hytech.rhsouthsystem.model.Associate;
import br.com.hytech.rhsouthsystem.repository.AssociateRepository;
import br.com.hytech.rhsouthsystem.service.associate.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/v1/associate")
public class AssociateResource extends AbstractController<Associate, String, AssociateService>{
    private final AssociateService associateService;

    public AssociateResource(AssociateService associateService) {
        super(associateService);
        this.associateService = associateService;
    }
}
