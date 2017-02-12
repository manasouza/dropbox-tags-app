package br.com.mls.dbtag.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by manasses on 2/11/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TagNotFoundException extends RuntimeException {

    private final String tagName;

    public TagNotFoundException(String tagName) {
        super();
        this.tagName = tagName;
    }

    @Override
    public String getMessage() {
        // TODO: i18n
        return "Tag not found: " + tagName;
    }
}
