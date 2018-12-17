package com.cristi.web.mentool.domain.subject;

import com.cristi.web.mentool.domain.BaseEntity;

public class Subject extends BaseEntity<Subject, SubjectId> {

    private Title title;
    private Description description;

    public Subject(Title title, Description description) {
        super(Subject.class, new SubjectId());
        this.title = title;
        this.description = description;
        validate(this);
    }


    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }
}
