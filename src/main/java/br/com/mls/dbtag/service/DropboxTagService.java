package br.com.mls.dbtag.service;

import br.com.mls.dbtag.model.DropboxFile;
import br.com.mls.dbtag.model.TaggedFiles;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by manasses on 2/13/17.
 */
@Service
@Slf4j
public class DropboxTagService {

    @Autowired
    private DropboxIntegration dropboxIntegration;

    @PostConstruct
    public void authenticate() {
        try {
            dropboxIntegration.authenticate();
        } catch (DbxException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public List<TaggedFiles> getTaggedFiles(String tags, String criteria) {
        List<TaggedFiles> taggedFiles = null;
        try {
            DbxEntry.WithChildren dbMetadata = dropboxIntegration.getClient().getMetadataWithChildren("/");
            dbMetadata.children.forEach(c -> System.out.println("children: " + c));
        } catch (DbxException e) {
            log.error(e.getMessage(), e);
        }
        return taggedFiles;
    }

    public boolean fileExists(String fileName) throws DbxException {
        return dropboxIntegration.getClient().getMetadataWithChildren("/")
                .children.stream()
                .filter(c -> fileName.equals(c.name)).findFirst().isPresent();
    }
}
