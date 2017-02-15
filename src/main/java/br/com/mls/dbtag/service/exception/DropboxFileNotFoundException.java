package br.com.mls.dbtag.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by manasses on 2/14/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DropboxFileNotFoundException extends RuntimeException {

    private final String fileName;

    public DropboxFileNotFoundException(String name) {
        super();
        this.fileName = name;
    }

    @Override
    public String getMessage() {
        // TODO: i18n
        return "Dropbox file not found: " + this.fileName;
    }
}
