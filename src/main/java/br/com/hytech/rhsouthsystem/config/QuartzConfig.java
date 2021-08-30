package br.com.hytech.rhsouthsystem.config;

import br.com.hytech.rhsouthsystem.jms.job.CloseSessionJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Component
public class QuartzConfig {

    @Bean
    public Trigger trigger(JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
                .withIdentity("closeSessions")
                .withDescription("Sample trigger")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInMilliseconds(10))
                .build();
    }

    @Bean
    public JobDetail details() {
        return JobBuilder.newJob(CloseSessionJob.class)
                .withIdentity("closeSessions")
                .storeDurably()
                .build();
    }
}


