package br.com.mls.dbtag.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

/**
 * Created by manasses on 2/13/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DropboxTag {

    @Field
    private Tag tag;

    @Field
    private DropboxFile file;

    public DropboxTag(String tagName, String fileName) {
        this.tag = new Tag(tagName);
        this.file = new DropboxFile(fileName);
    }
}
