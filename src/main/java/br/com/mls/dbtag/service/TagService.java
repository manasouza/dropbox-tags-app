package br.com.mls.dbtag.service;

import br.com.mls.dbtag.model.DropboxFile;
import br.com.mls.dbtag.model.DropboxTag;
import br.com.mls.dbtag.model.Tag;
import br.com.mls.dbtag.repository.DropboxTagRepository;
import br.com.mls.dbtag.repository.TagRepository;
import br.com.mls.dbtag.service.exception.DropboxFileNotFoundException;
import br.com.mls.dbtag.service.exception.DropboxIntegrationException;
import br.com.mls.dbtag.service.exception.TagNotFoundException;
import com.dropbox.core.DbxException;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by manasses on 2/11/17.
 */
@Service
@Slf4j
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private DropboxTagRepository dropboxTagRepository;

    @Autowired
    private DropboxTagService dropboxTagService;

    public List<Tag> getTags(String s, String s1) {
        List<Tag> tagList = Lists.newArrayList();
        tagRepository.findAll().forEach(t -> tagList.add(t));
        return tagList;
    }

    public List<DropboxTag> createTags(List<DropboxTag> dropboxTags) throws DropboxFileNotFoundException {
        List<DropboxTag> savedTags = Lists.newArrayList();
        for (DropboxTag dropboxTag : dropboxTags) {
            try {
                if (!dropboxTagService.fileExists(dropboxTag.getFile().getName())) {
                    throw new DropboxFileNotFoundException(dropboxTag.getFile().getName());
                }
            } catch (DbxException e) {
                log.error(e.getMessage(), e);
                throw new DropboxIntegrationException();
            }
            savedTags.add(dropboxTagRepository.save(dropboxTag));
        }
        return savedTags;
    }

    public void removeTags(Tag tag) {
        tagRepository.delete(tag);
    }

    public Tag getTagByName(String name) throws TagNotFoundException {
        Objects.nonNull(name);
        Tag tag = tagRepository.findByName(name);
        if (tag == null) {
            throw new TagNotFoundException(name);
        }
        return tag;
    }
}
