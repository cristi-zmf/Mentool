package com.cristi.web.mentool.domain.subject;

import java.util.Optional;
import java.util.Set;

public interface Subjects {
    Set<Subject> findAll();
    Subject getOrThrow(SubjectId id);
    Optional<Subject> get(SubjectId id);
    Subject add(Subject subject);
    Set<Subject> findByTitleContaining(String key);
}
