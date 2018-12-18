package com.cristi.web.mentool.infra.persistence.subject;

import com.cristi.web.mentool.domain.subject.Subject;
import com.cristi.web.mentool.domain.subject.SubjectId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SdjSubjects extends JpaRepository<Subject, SubjectId> {
    Set<Subject> findByTitleValueContaining(String title);
}
