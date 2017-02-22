package br.com.mls.dbtag.repository.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * Created by manasses on 2/20/17.
 */
@Getter
@Setter
@SolrDocument(solrCoreName = "dbtag")
public class DropboxTagEntity {

    @Field
    private String id;

    @Field
    @Indexed
    private String tagName;

    @Field
    private String fileName;

    public DropboxTagEntity(String tagName, String fileName) {
        this.tagName = tagName;
        this.fileName = fileName;
    }
}
