package br.com.mls.dbtag.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by manasses on 2/8/17.
 */

@Data
@AllArgsConstructor
public class TagResponse {

    private List<TagDTO> tags;
}
