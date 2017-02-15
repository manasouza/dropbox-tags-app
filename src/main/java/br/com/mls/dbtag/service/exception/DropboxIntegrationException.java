package br.com.mls.dbtag.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by manasses on 2/14/17.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DropboxIntegrationException extends RuntimeException {
}
