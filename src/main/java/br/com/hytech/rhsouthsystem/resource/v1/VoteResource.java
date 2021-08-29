package br.com.hytech.rhsouthsystem.resource.v1;

import br.com.hytech.rhsouthsystem.model.Vote;
import br.com.hytech.rhsouthsystem.service.vote.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/votes")
public class VoteResource extends AbstractController<Vote, Long, VoteService>{
    public VoteResource(VoteService service) {
        super(service);
    }

    @Override
    protected ResponseEntity<Vote> delete(Long aLong) {
        return new ResponseEntity<>(null, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    protected ResponseEntity<Vote> update(Long aLong, Vote user) {
        return new ResponseEntity<>(null, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
