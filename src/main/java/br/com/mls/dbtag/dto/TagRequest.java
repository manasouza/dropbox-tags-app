package br.com.mls.dbtag.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by manasses on 2/8/17.
 */
@Getter
public class TagRequest {

    @JsonProperty
    private List<TagDTO> tags;
}
