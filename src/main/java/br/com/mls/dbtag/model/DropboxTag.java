package br.com.mls.dbtag.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by manasses on 2/13/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DropboxTag {

    private String id;

    private Tag tag;

    private DropboxFile file;

    public DropboxTag(Tag tag, DropboxFile dropboxFile) {
        this.tag = tag;
        this.file = dropboxFile;
    }
}
