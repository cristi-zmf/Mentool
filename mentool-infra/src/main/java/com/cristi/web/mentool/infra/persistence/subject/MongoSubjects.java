package com.cristi.web.mentool.infra.persistence.subject;

import com.cristi.web.mentool.domain.subject.Subject;
import com.cristi.web.mentool.domain.subject.SubjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Set;

public interface MongoSubjects extends MongoRepository<Subject, SubjectId> {
    Set<Subject> findByTitleValueContaining(String title);
}
