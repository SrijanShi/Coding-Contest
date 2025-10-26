package com.shodhacode.backend.repo;

import com.shodhacode.backend.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
