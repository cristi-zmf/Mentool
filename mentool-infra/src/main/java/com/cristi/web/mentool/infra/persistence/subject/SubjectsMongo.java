package com.cristi.web.mentool.infra.persistence.subject;

import com.cristi.web.mentool.domain.subject.Subject;
import com.cristi.web.mentool.domain.subject.SubjectId;
import com.cristi.web.mentool.domain.subject.Subjects;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class SubjectsMongo implements Subjects {
    private final SdjSubjects repo;

    public SubjectsMongo(SdjSubjects repo) {
        this.repo = repo;
    }


    @Override
    public Set<Subject> findAll() {
        return new HashSet<>(repo.findAll());
    }

    @Override
    public Subject getOrThrow(SubjectId id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException(id.getValue()));
    }

    @Override
    public Optional<Subject> get(SubjectId id) {
        return repo.findById(id);
    }

    @Override
    public Subject add(Subject subject) {
        return repo.saveAndFlush(subject);
    }

    @Override
    public Set<Subject> findByTitleContaining(String key) {
        return repo.findByTitleValueContaining(key);
    }
}
