package br.com.mls.dbtag.repository;

import br.com.mls.dbtag.repository.entity.DropboxTagEntity;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by manasses on 2/14/17.
 */
@Repository
public interface DropboxTagRepository extends SolrCrudRepository<DropboxTagEntity, String> {

}
