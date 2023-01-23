package by.klubnikov.hw4243.config;

import by.klubnikov.hw4243.entity.Student;
import by.klubnikov.hw4243.service.StudentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class AppEvent {

    private final StudentService service;

    @EventListener(ApplicationReadyEvent.class)
    public void startApplication() {
        Student student = new Student();
        student.setStudentName("Alex");
        student.setAge(33);
        service.save(student);

        Student student1 = new Student();
        student1.setStudentName("Elen");
        student1.setAge(20);
        service.save(student1);

        Student student2 = new Student();
        student2.setStudentName("Andrew");
        student2.setAge(25);
        service.save(student2);
    }
}
