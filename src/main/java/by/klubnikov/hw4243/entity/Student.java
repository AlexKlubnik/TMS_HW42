package by.klubnikov.hw4243.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="some_students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="student_name", nullable = false)
    @Size(min=2, max=50)
    private String studentName;

    @Column(name = "age")
    @Min(value = 17)
    private int age;
}
