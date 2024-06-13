package com.example.task_management.scheduler;
import com.example.task_management.service.RabbitMQSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TaskScheduler {

    private final RabbitMQSenderService rabbitMQSenderService;

    @Scheduled(fixedRate = 60000)
    @SchedulerLock(name = "scheduledTask", lockAtMostFor = "PT10M", lockAtLeastFor = "PT1M")
    public void scheduledTask() {
        log.info("Running scheduled task");
        String message = "Hello, this is a scheduled message!";
        rabbitMQSenderService.sendMessage(message);
    }
}

