package bobs.Job;

import org.quartz.Trigger;
import org.springframework.stereotype.Component;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Component
public class JobTriggerBuilder {

    public Trigger makeAlarmJobTrigger() {
        Trigger AlarmTrigger = newTrigger()
                .withIdentity("AlarmTrigger", "AlarmGroup")
                .withSchedule(cronSchedule("1/30 * * * * ?"))
                .forJob("Alarm", "AlarmGroup")
                .build();
        return AlarmTrigger;
    }
}
