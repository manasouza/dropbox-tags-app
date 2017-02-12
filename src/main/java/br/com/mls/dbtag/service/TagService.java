package br.com.mls.dbtag.service;

import br.com.mls.dbtag.model.Tag;
import br.com.mls.dbtag.service.exception.TagNotFoundException;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by manasses on 2/11/17.
 */
@Service
public class TagService {

    private List<Tag> tagList = Lists.newArrayList();

    public List<Tag> getTags(String s, String s1) {
        return tagList;
    }

    public void createTags(List<Tag> tags) {
        tagList.addAll(tags);
    }

    public void removeTags(Tag tag) {
        boolean removed = tagList.remove(tag);
        if (!removed) {
            throw new TagNotFoundException(tag.getName());
        }
    }

    public Tag getTagByName(String name) throws TagNotFoundException {
        Objects.nonNull(name);
        for (Tag tag : tagList) {
            if (name.equals(tag.getName())) {
                return tag;
            }
        }
        throw new TagNotFoundException(name);
    }
}
