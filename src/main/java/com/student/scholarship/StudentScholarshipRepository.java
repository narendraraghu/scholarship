package com.student.scholarship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentScholarshipRepository extends JpaRepository<StudentScholarship, Long> {
}
