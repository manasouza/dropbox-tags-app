package br.com.mls.dbtag.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.solr.core.mapping.Indexed;

/**
 * Created by manasses on 2/14/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DropboxFile {

    @Indexed(name = "id", type = "string")
    private String name;

//    public DropboxFile(String name) {
//        this.name = name;
//    }
}
