/*
 *  
 * The MIT License (MIT)
 * Copyright (c) 2017 KUKULKAN
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mx.infotec.dads.mongo.web.rest;

import java.util.List;
import java.util.Optional;

import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import mx.infotec.dads.mongo.web.rest.util.HeaderUtil;
import mx.infotec.dads.mongo.web.rest.util.PaginationUtil;

import mx.infotec.dads.mongo.domain.Direccion;
import mx.infotec.dads.mongo.service.DireccionService;
/**
 * 
 * @author KUKULKAN
 * @kukulkanGenerated 2017-12-14T19:33:36Z
 */

@RestController
@RequestMapping("/api")
public class DireccionResource {

    private static final Logger log = LoggerFactory.getLogger(DireccionResource.class);
    
    private static final String ENTITY_NAME = "direccion";

    @Autowired
    private DireccionService service;
    
    /**
     * GET  /direccions : recupera todos los direccions.
     *
     * @param pageable información de paginación
     * @return El objeto ResponseEntity con estado de 200 (OK) y la lista de direccions en el cuerpo del mensaje
     */
    @GetMapping("/direccions")
    @Timed
    public ResponseEntity<List<Direccion>> getAllDireccion(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Direccion");
        Page<Direccion> page = service.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/direccions");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /direccions/:id : recupera por "id" de Direccion.
     *
     * @param id el id del Direccion que se desea recuperar
     * @return El objeto ResponseEntity con el estado de 200 (OK) y dentro del cuerpo del mensaje el Direccion, o con estado de 404 (Not Found)
     */
    @GetMapping("/direccions/{id}")
    @Timed
    public ResponseEntity<Direccion> getDireccion(@PathVariable String id) {
        log.debug("REST request to get Direccion : {}", id);
        Direccion direccion = service.findById(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(direccion));
    }

    /**
     * POST  /direccions : Create a new usuario.
     *
     * @param direccion el direccion que se desea crear
     * @return El objeto ResponseEntity con estado 201 (Created) y en el cuerpo un nuevo direccion, o con estado 400 (Bad Request) si el usuario ya tiene un ID
     * @throws URISyntaxException Si la sintaxis de la URI no es correcta
     */
    @PostMapping("/direccions")
    @Timed
    public ResponseEntity<Direccion> createDireccion(@Valid @RequestBody Direccion direccion) throws URISyntaxException {
        log.debug("REST request to save Direccion : {}", direccion);
        if (direccion.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new direccion cannot already have an ID")).body(null);
        }
        Direccion result = service.save(direccion);
        return ResponseEntity.created(new URI("/api/direccions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    /**
     * PUT  /direccions : Actualiza un Direccion existente.
     *
     * @param direccion el direccion que se desea actualizar
     * @return el objeto ResponseEntity con estado de 200 (OK) y en el cuerpo de la respuesta el Direccion actualizado,
     * o con estatus de 400 (Bad Request) si el direccion no es valido,
     * o con estatus de 500 (Internal Server Error) si el direccion no se puede actualizar
     * @throws URISyntaxException si la sintaxis de la URI no es correcta
     */
    @PutMapping("/direccions")
    @Timed
    public ResponseEntity<Direccion> updateDireccion(@Valid @RequestBody Direccion direccion) throws URISyntaxException {
        log.debug("REST request to update Direccion : {}", direccion);
        if (direccion.getId() == null) {
            return createDireccion(direccion);
        }
        Direccion result = service.save(direccion);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, direccion.getId().toString()))
            .body(result);
    }


    /**
     * DELETE  /direccions/:id : borrar el Direccion con "id".
     *
     * @param id el id del Direccion que se desea borrar
     * @return el objeto ResponseEntity con estatus 200 (OK)
     */
    @DeleteMapping("/direccions/{id}")
    @Timed
    public ResponseEntity<Void> deleteDireccion(@PathVariable String id) {
        log.debug("REST request to delete Direccion : {}", id);
        service.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/direccions?query=:query : buscar por el direccion correspondiente
     * to the query.
     *
     * @param query el query para el direccion que se desea buscar
     * @param pageable información de la paginación
     * @return el resultado de la busqueda
     */
    @GetMapping("/_search/direccions")
    @Timed
    public ResponseEntity<List<Direccion>> searchDireccion(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of Direccion for query {}", query);
        Page<Direccion> page = service.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/direccions");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
}