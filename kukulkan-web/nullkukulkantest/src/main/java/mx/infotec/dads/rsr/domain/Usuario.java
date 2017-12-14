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
package mx.infotec.dads.rsr.domain;

import java.lang.Long;
import java.math.BigInteger;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * The Usuario
 * 
 * @author KUKULKAN
 *
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la llave primaria id
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Id
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize=100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "ACTIVO")
    private Boolean activo;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "EDAD")
    private Integer edad;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "FECHA_LOCAL_DATE")
    private LocalDate fechaLocalDate;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "FECHA_ZONE_DATE_TIME")
    private ZonedDateTime fechaZoneDateTime;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "IMAGEN")
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] imagen;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "IMAGEN_ANY_BLOB")
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] imagenAnyBlob;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "IMAGEN_ANY_BLOB_CONTENT_TYPE")
    private String imagenAnyBlobContentType;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "IMAGEN_BLOB")
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] imagenBlob;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "IMAGEN_BLOB_CONTENT_TYPE")
    private String imagenBlobContentType;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "IMAGEN_CONTENT_TYPE")
    private String imagenContentType;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "IMPUESTO")
    private Double impuesto;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "IMPUESTO_DETALLE")
    private Double impuestoDetalle;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "INSTANTE")
    private ZonedDateTime instante;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "JHI_DESC")
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String jhiDesc;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @NotNull
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "NUMERO_CREDENCIAL")
    private BigInteger numeroCredencial;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla USUARIO
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Column(name = "SUELDO")
    private Double sueldo;
	
    /**
     * Este constructor fue generado automáticamente por KUKULKAN
     * 
     */
    public Usuario() {

    }
    
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la llave primaria USUARIO.id
     *
     * @return el valor de id
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public Long getId() {
        return id;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la llave primaria. USUARIO.id
     *
     * @return el valor de area_conocimiento.id
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.ACTIVO
     *
     * @return el valor de activo
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.activo
     *
     * @return el valor de Activo
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.EDAD
     *
     * @return el valor de edad
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.edad
     *
     * @return el valor de Edad
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.FECHA_LOCAL_DATE
     *
     * @return el valor de fechaLocalDate
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public LocalDate getFechaLocalDate() {
        return fechaLocalDate;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.fechaLocalDate
     *
     * @return el valor de FechaLocalDate
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setFechaLocalDate(LocalDate fechaLocalDate) {
        this.fechaLocalDate = fechaLocalDate;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.FECHA_ZONE_DATE_TIME
     *
     * @return el valor de fechaZoneDateTime
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public ZonedDateTime getFechaZoneDateTime() {
        return fechaZoneDateTime;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.fechaZoneDateTime
     *
     * @return el valor de FechaZoneDateTime
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setFechaZoneDateTime(ZonedDateTime fechaZoneDateTime) {
        this.fechaZoneDateTime = fechaZoneDateTime;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.IMAGEN
     *
     * @return el valor de imagen
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.imagen
     *
     * @return el valor de Imagen
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.IMAGEN_ANY_BLOB
     *
     * @return el valor de imagenAnyBlob
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public byte[] getImagenAnyBlob() {
        return imagenAnyBlob;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.imagenAnyBlob
     *
     * @return el valor de ImagenAnyBlob
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setImagenAnyBlob(byte[] imagenAnyBlob) {
        this.imagenAnyBlob = imagenAnyBlob;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.IMAGEN_ANY_BLOB_CONTENT_TYPE
     *
     * @return el valor de imagenAnyBlobContentType
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public String getImagenAnyBlobContentType() {
        return imagenAnyBlobContentType;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.imagenAnyBlobContentType
     *
     * @return el valor de ImagenAnyBlobContentType
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setImagenAnyBlobContentType(String imagenAnyBlobContentType) {
        this.imagenAnyBlobContentType = imagenAnyBlobContentType;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.IMAGEN_BLOB
     *
     * @return el valor de imagenBlob
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public byte[] getImagenBlob() {
        return imagenBlob;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.imagenBlob
     *
     * @return el valor de ImagenBlob
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setImagenBlob(byte[] imagenBlob) {
        this.imagenBlob = imagenBlob;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.IMAGEN_BLOB_CONTENT_TYPE
     *
     * @return el valor de imagenBlobContentType
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public String getImagenBlobContentType() {
        return imagenBlobContentType;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.imagenBlobContentType
     *
     * @return el valor de ImagenBlobContentType
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setImagenBlobContentType(String imagenBlobContentType) {
        this.imagenBlobContentType = imagenBlobContentType;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.IMAGEN_CONTENT_TYPE
     *
     * @return el valor de imagenContentType
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public String getImagenContentType() {
        return imagenContentType;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.imagenContentType
     *
     * @return el valor de ImagenContentType
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setImagenContentType(String imagenContentType) {
        this.imagenContentType = imagenContentType;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.IMPUESTO
     *
     * @return el valor de impuesto
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public Double getImpuesto() {
        return impuesto;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.impuesto
     *
     * @return el valor de Impuesto
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.IMPUESTO_DETALLE
     *
     * @return el valor de impuestoDetalle
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public Double getImpuestoDetalle() {
        return impuestoDetalle;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.impuestoDetalle
     *
     * @return el valor de ImpuestoDetalle
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setImpuestoDetalle(Double impuestoDetalle) {
        this.impuestoDetalle = impuestoDetalle;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.INSTANTE
     *
     * @return el valor de instante
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public ZonedDateTime getInstante() {
        return instante;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.instante
     *
     * @return el valor de Instante
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setInstante(ZonedDateTime instante) {
        this.instante = instante;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.JHI_DESC
     *
     * @return el valor de jhiDesc
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public String getJhiDesc() {
        return jhiDesc;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.jhiDesc
     *
     * @return el valor de JhiDesc
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setJhiDesc(String jhiDesc) {
        this.jhiDesc = jhiDesc;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.NOMBRE
     *
     * @return el valor de nombre
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.nombre
     *
     * @return el valor de Nombre
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.NUMERO_CREDENCIAL
     *
     * @return el valor de numeroCredencial
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public BigInteger getNumeroCredencial() {
        return numeroCredencial;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.numeroCredencial
     *
     * @return el valor de NumeroCredencial
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setNumeroCredencial(BigInteger numeroCredencial) {
        this.numeroCredencial = numeroCredencial;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad USUARIO.SUELDO
     *
     * @return el valor de sueldo
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public Double getSueldo() {
        return sueldo;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. USUARIO.sueldo
     *
     * @return el valor de Sueldo
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN
     *
     * @return el valor de representado por la entidad Usuario
     *
     * @kukulkanGenerated 2017-12-14T19:33:32Z
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", activo=").append(activo);
        sb.append(", edad=").append(edad);
        sb.append(", fechaLocalDate=").append(fechaLocalDate);
        sb.append(", fechaZoneDateTime=").append(fechaZoneDateTime);
        sb.append(", imagen=").append(imagen);
        sb.append(", imagenAnyBlob=").append(imagenAnyBlob);
        sb.append(", imagenAnyBlobContentType=").append(imagenAnyBlobContentType);
        sb.append(", imagenBlob=").append(imagenBlob);
        sb.append(", imagenBlobContentType=").append(imagenBlobContentType);
        sb.append(", imagenContentType=").append(imagenContentType);
        sb.append(", impuesto=").append(impuesto);
        sb.append(", impuestoDetalle=").append(impuestoDetalle);
        sb.append(", instante=").append(instante);
        sb.append(", jhiDesc=").append(jhiDesc);
        sb.append(", nombre=").append(nombre);
        sb.append(", numeroCredencial=").append(numeroCredencial);
        sb.append(", sueldo=").append(sueldo);
        sb.append("]");
        return sb.toString();
    }
}
