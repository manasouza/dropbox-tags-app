package br.com.mls.dbtag.facade;

import br.com.mls.dbtag.dto.TagDTO;
import br.com.mls.dbtag.model.DropboxFile;
import br.com.mls.dbtag.model.DropboxTag;
import br.com.mls.dbtag.model.Tag;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by manasses on 2/11/17.
 */
public class ModelMapper {


//    public static List<Tag> toModel(List<TagDTO> tagDtoList) {
//        List<Tag> tags = Lists.newArrayList();
//        tagDtoList.forEach(t -> tags.add(new Tag(t.getName())));
//        return tags;
//    }

    public static List<DropboxTag> toModel(List<TagDTO> tagDtoList) {
        List<DropboxTag> tags = Lists.newArrayList();
        tagDtoList.forEach(t -> tags.add(new DropboxTag(new Tag(t.getName()), new DropboxFile(t.getDropboxFile()))));
        return tags;
    }

    public static List<TagDTO> toFacade(List<DropboxTag> tagList) {
        List<TagDTO> tagsDTO = Lists.newArrayList();
        tagList.forEach(t -> tagsDTO.add(new TagDTO(t.getTag().getId().toString(), t.getTag().getName(),
                                                    t.getTag().getCreationDate().toString(),
                                                    t.getFile().getName())));
        return tagsDTO;
    }

    public static List<TagDTO> toFacade(Collection<Tag> tagList) {
        List<TagDTO> tagsDTO = Lists.newArrayList();
        tagList.forEach(t -> tagsDTO.add(new TagDTO(t.getId().toString(), t.getName(),
                                                    "", t.getCreationDate().toString())));
        return tagsDTO;
    }

    public static TagDTO toFacade(Tag tag) {
        return new TagDTO(tag.getId().toString(), tag.getName(),
                "", tag.getCreationDate().toString());
    }
}
