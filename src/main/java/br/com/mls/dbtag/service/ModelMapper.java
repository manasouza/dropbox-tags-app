package br.com.mls.dbtag.service;

import br.com.mls.dbtag.model.DropboxTag;
import br.com.mls.dbtag.repository.entity.DropboxTagEntity;

/**
 * Created by manasses on 2/20/17.
 */
public class ModelMapper {

    public static DropboxTagEntity toEntity(DropboxTag dropboxTag) {
        return new DropboxTagEntity(dropboxTag.getTag().getName(),
                                    dropboxTag.getFile().getName());
    }

    public static DropboxTag toModel(DropboxTagEntity dropboxTagEntity) {
        return new DropboxTag(dropboxTagEntity.getTagName(), dropboxTagEntity.getFileName());
    }
}
