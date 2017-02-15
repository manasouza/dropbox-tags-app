package br.com.mls.dbtag.service;

import com.dropbox.core.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Created by manasses on 2/14/17.
 */
@Component
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource(value = "file:${external.config.file}", ignoreResourceNotFound = false)
})
@Slf4j
public class DropboxIntegration {

    @Value("${dropbox.key}")
    private String dropboxKey;

    @Value("${dropbox.secret}")
    private String dropboxSecret;

    @Getter
    private DbxClient client;

    public void authenticate() throws DbxException, IOException {
        log.info("Dropbox Authentication process...");
        DbxAppInfo appInfo = new DbxAppInfo(this.dropboxKey, this.dropboxSecret);

        DbxRequestConfig config = new DbxRequestConfig("dbtag", Locale.getDefault().toString());
        DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);

        // Have the user sign in and authorize your app.
        String authorizeUrl = webAuth.start();
        log.info("1. Go to: " + authorizeUrl);
        log.info("2. Click \"Allow\" (you might have to log in first)");
        log.info("3. Copy the authorization code then paste here");
        String code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();

        // This will fail if the user enters an invalid authorization code.
        DbxAuthFinish authFinish = webAuth.finish(code);
        String accessToken = authFinish.accessToken;

        client = new DbxClient(config, accessToken);

        log.info("Linked account: " + client.getAccountInfo().displayName);
    }

    public String isAuthenticated() {
        // TODO: store auth token at Solr
        // TODO: create mechanism to validate if token is expired
        return this.client.getAccessToken();
    }

}
