package br.com.hytech.rhsouthsystem.jms.job;

import br.com.hytech.rhsouthsystem.service.session.CloseSessionService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CloseSessionJob implements Job {

    @Autowired
    private CloseSessionService sessionService;

    @Override
    public void execute(JobExecutionContext context) {
        sessionService.closeSession();

    }
}
