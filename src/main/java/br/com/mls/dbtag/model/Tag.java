package br.com.mls.dbtag.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by manasses on 2/11/17.
 */
@Data
@NoArgsConstructor
public class Tag {

    @Field
    private String id;

    @Field
    private String name;

    @Field
    private LocalDate creationDate;

    public Tag(String name) {
        this.name = name;
    }
}
