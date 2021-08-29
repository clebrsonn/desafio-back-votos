package br.com.hytech.rhsouthsystem.resource.v1;

import br.com.hytech.rhsouthsystem.model.Vote;
import br.com.hytech.rhsouthsystem.resource.v1.dto.VoteDTO;
import br.com.hytech.rhsouthsystem.service.vote.VoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/vote")
public class VoteResource extends AbstractController<Vote, Long, VoteService>{
    public VoteService voteService;

    public VoteResource(VoteService service) {
        super(service);
    }
    @PostMapping
    public ResponseEntity<Vote> vote(@Valid @RequestBody VoteDTO voteDTO){
        return ResponseEntity.ok(voteService.vote(voteDTO));
    }
}
