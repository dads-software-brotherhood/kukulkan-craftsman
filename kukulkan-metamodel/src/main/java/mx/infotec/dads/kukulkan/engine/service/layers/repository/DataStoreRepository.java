package mx.infotec.dads.kukulkan.engine.service.layers.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.infotec.dads.kukulkan.engine.domain.core.DataStore;

/**
 * DataStoreRepository
 * 
 * @author Daniel Cortes Pichardo
 *
 */
@Repository
public interface DataStoreRepository extends MongoRepository<DataStore, String> {

}
