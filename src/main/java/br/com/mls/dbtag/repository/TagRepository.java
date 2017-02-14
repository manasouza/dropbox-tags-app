package br.com.mls.dbtag.repository;

import br.com.mls.dbtag.model.Tag;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by manasses on 2/13/17.
 */
@Repository
public interface TagRepository extends SolrCrudRepository<Tag, String> {

    Tag findByName(String name);
}
