package br.com.hytech.rhsouthsystem.resource.v1;

import br.com.hytech.rhsouthsystem.model.Vote;
import br.com.hytech.rhsouthsystem.service.vote.VoteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/vote")
public class VoteResource extends AbstractController<Vote, Long, VoteService>{
    public VoteResource(VoteService service) {
        super(service);
    }
}
