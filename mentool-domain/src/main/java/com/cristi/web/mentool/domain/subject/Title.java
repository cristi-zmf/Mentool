package com.cristi.web.mentool.domain.subject;

import com.cristi.web.mentool.domain.BaseValueObject;

import javax.validation.constraints.Size;
import java.util.List;

import static java.util.Arrays.asList;

public class Title extends BaseValueObject<Title> {
    @Size(max = 200)
    private String value;

    public Title(String value) {
        super(Title.class);
        this.value = value;
        validate(this);
    }

    private Title() {
        super(Title.class);
        this.value = null;
    }

    @Override
    protected List<Object> attributesToIncludeInEqualityCheck() {
        return asList(value);
    }

    public String getValue() {
        return value;
    }
}
