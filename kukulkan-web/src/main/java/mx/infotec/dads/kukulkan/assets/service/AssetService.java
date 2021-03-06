package mx.infotec.dads.kukulkan.assets.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.infotec.dads.kukulkan.assets.service.dto.AssetDTO;

/**
 * Service Interface for managing Asset.
 */
public interface AssetService {

    /**
     * Save a asset.
     *
     * @param assetDTO the entity to save
     * @return the persisted entity
     */
    AssetDTO save(AssetDTO assetDTO);

    /**
     *  Get all the assets.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<AssetDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" asset.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    AssetDTO findOne(String id);

    /**
     *  Delete the "id" asset.
     *
     *  @param id the id of the entity
     */
    void delete(String id);
}
