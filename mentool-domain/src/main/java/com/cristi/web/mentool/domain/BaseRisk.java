package com.cristi.web.mentool.domain;

import java.util.Set;


public abstract class BaseRisk {
    private String id;
    private Set<String> labels;

    public BaseRisk(String id, Set<String> labels) {
        this.id = id;
        this.labels = labels;
    }

    //USED BY JPA
    private BaseRisk() {
    }
}
