package com.cristi.web.mentool.exposition.subject;

import com.cristi.web.mentool.domain.subject.Subject;
import com.cristi.web.mentool.domain.subject.SubjectId;
import com.cristi.web.mentool.exposition.IncognitoMapping;
import com.cristi.web.mentool.application.subject.CreateViewSubject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@IncognitoMapping
public class CreateOrViewSubjectResource {
    private final CreateViewSubject createViewSubject;

    public CreateOrViewSubjectResource(CreateViewSubject createViewSubject) {
        this.createViewSubject = createViewSubject;
    }

    @PostMapping(path = "/subjects", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Subject> createSubject(@RequestBody CreateSubjectCommandDto createCommand) {
        Subject newSubject = createViewSubject.createSubject(createCommand.title, createCommand.description);
        return ok(newSubject);
    }

    @GetMapping(path = "/subjects/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public Subject viewSubject(@RequestParam SubjectId id) {
        return createViewSubject.viewSubject(id);
    }
}
