package br.com.mls.dbtag.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by manasses on 2/14/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DropboxFile {

    private String id;

    private String name;

    public DropboxFile(String name) {
        this.name = name;
    }
}
