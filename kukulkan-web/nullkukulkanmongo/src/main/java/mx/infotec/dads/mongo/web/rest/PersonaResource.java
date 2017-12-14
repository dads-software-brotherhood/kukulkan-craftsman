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

import mx.infotec.dads.mongo.domain.Persona;
import mx.infotec.dads.mongo.service.PersonaService;
/**
 * 
 * @author KUKULKAN
 * @kukulkanGenerated 2017-12-14T19:33:36Z
 */

@RestController
@RequestMapping("/api")
public class PersonaResource {

    private static final Logger log = LoggerFactory.getLogger(PersonaResource.class);
    
    private static final String ENTITY_NAME = "persona";

    @Autowired
    private PersonaService service;
    
    /**
     * GET  /personas : recupera todos los personas.
     *
     * @param pageable información de paginación
     * @return El objeto ResponseEntity con estado de 200 (OK) y la lista de personas en el cuerpo del mensaje
     */
    @GetMapping("/personas")
    @Timed
    public ResponseEntity<List<Persona>> getAllPersona(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Persona");
        Page<Persona> page = service.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/personas");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /personas/:id : recupera por "id" de Persona.
     *
     * @param id el id del Persona que se desea recuperar
     * @return El objeto ResponseEntity con el estado de 200 (OK) y dentro del cuerpo del mensaje el Persona, o con estado de 404 (Not Found)
     */
    @GetMapping("/personas/{id}")
    @Timed
    public ResponseEntity<Persona> getPersona(@PathVariable String id) {
        log.debug("REST request to get Persona : {}", id);
        Persona persona = service.findById(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(persona));
    }

    /**
     * POST  /personas : Create a new usuario.
     *
     * @param persona el persona que se desea crear
     * @return El objeto ResponseEntity con estado 201 (Created) y en el cuerpo un nuevo persona, o con estado 400 (Bad Request) si el usuario ya tiene un ID
     * @throws URISyntaxException Si la sintaxis de la URI no es correcta
     */
    @PostMapping("/personas")
    @Timed
    public ResponseEntity<Persona> createPersona(@Valid @RequestBody Persona persona) throws URISyntaxException {
        log.debug("REST request to save Persona : {}", persona);
        if (persona.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new persona cannot already have an ID")).body(null);
        }
        Persona result = service.save(persona);
        return ResponseEntity.created(new URI("/api/personas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    /**
     * PUT  /personas : Actualiza un Persona existente.
     *
     * @param persona el persona que se desea actualizar
     * @return el objeto ResponseEntity con estado de 200 (OK) y en el cuerpo de la respuesta el Persona actualizado,
     * o con estatus de 400 (Bad Request) si el persona no es valido,
     * o con estatus de 500 (Internal Server Error) si el persona no se puede actualizar
     * @throws URISyntaxException si la sintaxis de la URI no es correcta
     */
    @PutMapping("/personas")
    @Timed
    public ResponseEntity<Persona> updatePersona(@Valid @RequestBody Persona persona) throws URISyntaxException {
        log.debug("REST request to update Persona : {}", persona);
        if (persona.getId() == null) {
            return createPersona(persona);
        }
        Persona result = service.save(persona);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, persona.getId().toString()))
            .body(result);
    }


    /**
     * DELETE  /personas/:id : borrar el Persona con "id".
     *
     * @param id el id del Persona que se desea borrar
     * @return el objeto ResponseEntity con estatus 200 (OK)
     */
    @DeleteMapping("/personas/{id}")
    @Timed
    public ResponseEntity<Void> deletePersona(@PathVariable String id) {
        log.debug("REST request to delete Persona : {}", id);
        service.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/personas?query=:query : buscar por el persona correspondiente
     * to the query.
     *
     * @param query el query para el persona que se desea buscar
     * @param pageable información de la paginación
     * @return el resultado de la busqueda
     */
    @GetMapping("/_search/personas")
    @Timed
    public ResponseEntity<List<Persona>> searchPersona(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of Persona for query {}", query);
        Page<Persona> page = service.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/personas");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
}