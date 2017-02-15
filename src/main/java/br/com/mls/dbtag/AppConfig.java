package br.com.mls.dbtag;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import javax.annotation.PostConstruct;

/**
 * Created by manasses on 2/13/17.
 */
@Configuration
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource(value = "file:${external.config.file}", ignoreResourceNotFound = false)
})
@EnableSolrRepositories("br.com.mls.dbtag.repository")
public class AppConfig {

    private String solrBaseUri;

    @Value("${solr.protocol}")
    private String solrProtocol;

    @Value("${solr.host}")
    private String solrHost;

    @Value("${solr.port}")
    private String solrPort;

    @Value("${solr.path}")
    private String solrPath;

    @PostConstruct
    public void init() {
        solrBaseUri = String.format("%s://%s:%s/%s", solrProtocol, solrHost, solrPort, solrPath);
    }

    @Bean
    public SolrClient solrClient() {
        return new HttpSolrClient(solrBaseUri);
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient solrClient) {
        return new SolrTemplate(solrClient);
    }
}
