package br.com.mls.dbtag.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.Indexed;

import java.time.LocalDate;

/**
 * Created by manasses on 2/11/17.
 */
@Data
@NoArgsConstructor
public class Tag {

    @Field
    private String id;

    @Indexed(name = "name", type = "string")
    private String name;

    private LocalDate creationDate;

    public Tag(String name) {
        this.name = name;
    }
}
