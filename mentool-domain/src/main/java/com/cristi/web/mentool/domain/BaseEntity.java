package com.cristi.web.mentool.domain;

import org.springframework.data.annotation.Transient;

import javax.validation.constraints.NotNull;

import static java.lang.String.format;

public abstract class BaseEntity<T extends BaseEntity<T, ID>, ID extends BaseValueObject<ID>> implements Validable<BaseEntity<T, ID>> {
    @Transient
    private Class<T> type;

    @NotNull
    private final ID id;

    protected BaseEntity(Class<T> type, ID id) {
        this.type = type;
        this.id = id;
        validate(this);
    }

    public ID getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!type.isInstance(obj)) {
            return false;
        }
        T other = type.cast(obj);
        return id.equals(other.getId());
    }

    @Override
    public String toString() {
        return format("[%s: %s]", type.getSimpleName(), id);
    }
}
