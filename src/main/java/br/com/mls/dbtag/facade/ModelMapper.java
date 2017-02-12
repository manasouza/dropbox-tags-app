package br.com.mls.dbtag.facade;

import br.com.mls.dbtag.dto.TagDTO;
import br.com.mls.dbtag.model.Tag;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manasses on 2/11/17.
 */
public class ModelMapper {


    public static List<Tag> toModel(List<TagDTO> tagDtoList) {
        List<Tag> tags = Lists.newArrayList();
        tagDtoList.forEach(t -> tags.add(new Tag(t.getName())));
        return tags;
    }

    public static List<TagDTO> toFacade(List<Tag> tagList) {
        List<TagDTO> tagsDTO = Lists.newArrayList();
        tagList.forEach(t -> tagsDTO.add(new TagDTO(t.getName())));
        return tagsDTO;
    }

    public static TagDTO toFacade(Tag tag) {
        return new TagDTO(tag.getName());
    }
}
