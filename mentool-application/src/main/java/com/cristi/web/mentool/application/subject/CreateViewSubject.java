package com.cristi.web.mentool.application.subject;

import com.cristi.web.mentool.domain.subject.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateViewSubject {
    private final Subjects subjects;

    public CreateViewSubject(Subjects subjects) {
        this.subjects = subjects;
    }


    public Subject createSubject(Title title, Description description) {
        Subject newSubject = new Subject(title, description);
        return subjects.add(newSubject);
    }

    public Subject viewSubject(SubjectId subjectId) {
        return subjects.getOrThrow(subjectId);
    }
}
