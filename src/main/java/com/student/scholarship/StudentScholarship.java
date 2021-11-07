package com.student.scholarship;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "student_scholarship")
public class StudentScholarship {

    @Id
    private Long id;

    private String name;

    private Boolean status;
}
