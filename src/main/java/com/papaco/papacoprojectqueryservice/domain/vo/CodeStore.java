package com.papaco.papacoprojectqueryservice.domain.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@EqualsAndHashCode
@Embeddable
public class CodeStore {
    @Column(name = "code_store_id")
    private final String id;

    @Column(name = "code_store_name")
    private final String name;

    public CodeStore() {
        this.id = null;
        this.name = null;
    }

    public CodeStore(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
