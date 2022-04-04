package com.student.scholarship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentScholarshipRepository extends JpaRepository<StudentScholarship, Long> {

    //GETSTUDENT is the name of procedure
    @Procedure("GETSTUDENT")
    int getTotalStudentByName(String name);

    @Query(value= "select CalcIncome(?1) from dual" ,nativeQuery = true)
    int calculateScholarship(int number);
}
