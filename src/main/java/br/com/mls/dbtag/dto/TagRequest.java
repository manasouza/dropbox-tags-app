package br.com.mls.dbtag.dto;

import lombok.Getter;

import java.util.List;

/**
 * Created by manasses on 2/8/17.
 */
@Getter
public class TagRequest {

    private List<TagDTO> tags;
}
