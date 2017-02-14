/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package br.com.mls.dbtag.facade;

import br.com.mls.dbtag.dto.TagDTO;
import br.com.mls.dbtag.dto.TagRequest;
import br.com.mls.dbtag.dto.TagResponse;
import br.com.mls.dbtag.model.Tag;
import br.com.mls.dbtag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/tags", method = RequestMethod.GET)
    public List<TagDTO> getTags(@RequestParam Optional<String> commaSeparatedTags, @RequestParam Optional<String> searchCriteria) {
        String tags = null;
        String criteria = null;
        if (commaSeparatedTags.isPresent()) {
            tags = commaSeparatedTags.get();
        }
        if (searchCriteria.isPresent()) {
            criteria = searchCriteria.get();
        }
        List<Tag> tagsList = tagService.getTags(tags, criteria);
        List<TagDTO> tagsDTO = ModelMapper.toFacade(tagsList);
        return tagsDTO;
    }

    @RequestMapping(value = "/tags/{name}", method = RequestMethod.GET)
    public TagDTO getTagByName(@PathVariable String name) {
        Tag tag = tagService.getTagByName(name);
        TagDTO tagDTO = ModelMapper.toFacade(tag);
        return tagDTO;
    }

    @RequestMapping(value = "/tags", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TagResponse createTags(@RequestBody TagRequest request) {
        List<Tag> tags = ModelMapper.toModel(request.getTags());
        tagService.createTags(tags);
        // TODO: design response for post: could have other data like date and ID
        return new TagResponse(new TagDTO("name"));
    }

    @RequestMapping(value = "/tags/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeTag(@PathVariable String name) {
        tagService.removeTags(new Tag(name));
    }

    @ExceptionHandler({NullPointerException.class})
    void handleIllegalArgumentException(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ("POST".equals(request.getMethod())) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), "Evaluate your request body");
        }
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
