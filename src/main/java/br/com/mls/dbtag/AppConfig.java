package br.com.mls.dbtag;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * Created by manasses on 2/13/17.
 */
@Configuration
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource(value = "file:${external.config.file}", ignoreResourceNotFound = false)
})
public class AppConfig {

    @Value("${solr.protocol}")
    private String solrProtocol;

    @Value("${solr.host}")
    private String solrHost;

    @Value("${solr.port}")
    private String solrPort;

    @Value("${solr.path}")
    private String solrPath;

    @Value("${dropbox.key}")
    private String dropboxKey;

}
