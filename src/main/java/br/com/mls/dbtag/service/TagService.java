package br.com.mls.dbtag.service;

import br.com.mls.dbtag.model.Tag;
import br.com.mls.dbtag.repository.TagRepository;
import br.com.mls.dbtag.service.exception.TagNotFoundException;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by manasses on 2/11/17.
 */
@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getTags(String s, String s1) {
        List<Tag> tagList = Lists.newArrayList();
        tagRepository.findAll().forEach(t -> tagList.add(t));
        return tagList;
    }

    public void createTags(List<Tag> tags) {
        tagRepository.save(tags);
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
