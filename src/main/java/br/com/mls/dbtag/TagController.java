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
package br.com.mls.dbtag;

import br.com.mls.dbtag.dto.TagDTO;
import br.com.mls.dbtag.dto.TagRequest;
import br.com.mls.dbtag.dto.TagResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TagController {

    @Value("${welcome}")
    private String welcome;

    @RequestMapping(value = "/tags", method = RequestMethod.GET)
    public String getTags(@RequestParam Optional tags, @RequestParam Optional criteria) {
        return "Reply: " + welcome + ", tags: " + tags + ", criteria: " + criteria;
    }

    @RequestMapping(value = "/tags/{name}", method = RequestMethod.GET)
    public String getTags(@PathVariable String name) {
        return "Reply: " + name;
    }

    @RequestMapping(value = "/tags", method = RequestMethod.POST)
    public TagResponse createTags(TagRequest request) {
        return new TagResponse(new TagDTO("name"));
    }

    @RequestMapping(value = "/tags/{name}", method = RequestMethod.DELETE)
    public void removeTag(@PathVariable String name) {

    }
}
