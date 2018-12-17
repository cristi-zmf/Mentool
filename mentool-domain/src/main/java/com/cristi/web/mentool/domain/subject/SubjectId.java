package com.cristi.web.mentool.domain.subject;

import com.cristi.web.mentool.domain.BaseValueObject;

import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;

public class SubjectId extends BaseValueObject<SubjectId> {

    private final String value;

    public SubjectId(String value) {
        super(SubjectId.class);
        this.value = value;
    }

    public SubjectId() {
        super(SubjectId.class);
        this.value = UUID.randomUUID().toString();
    }

    public String getValue() {
        return value;
    }

    @Override
    protected List<Object> attributesToIncludeInEqualityCheck() {
        return asList(value);
    }
}
