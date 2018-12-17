package com.cristi.web.mentool.domain.subject;

import com.cristi.web.mentool.domain.BaseValueObject;

import javax.validation.constraints.Size;
import java.util.List;

import static java.util.Arrays.asList;

public class Description extends BaseValueObject<Description> {
    @Size(max = 5000)
    private String value;

    public Description(String value) {
        super(Description.class);
        this.value = value;
        validate(this);
    }

    public String getValue() {
        return value;
    }

    private Description() {
        super(Description.class);
        this.value = null;
    }

    @Override
    protected List<Object> attributesToIncludeInEqualityCheck() {
        return asList(value);
    }
}
