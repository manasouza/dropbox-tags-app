package br.com.mls.dbtag.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by manasses on 2/11/17.
 */
@Data
public class Tag {

    private UUID id;
    private String name;
    private LocalDate creationDate;

    public Tag(String name) {
        this.name = name;
    }
}
