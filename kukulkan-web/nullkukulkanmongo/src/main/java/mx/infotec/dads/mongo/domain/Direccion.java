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
package mx.infotec.dads.mongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;
/**
 * The Direccion
 * 
 * @author KUKULKAN
 *
 */
@Document(collection = "DIRECCION")
public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la llave primaria id
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @Id
    private String id;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @NotNull
    @Size(min = 3, max = 50)	    
    @Pattern(regexp = "direccion")
    @Field("nombre")
    private String nombre;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @NotNull
    @Min(value = 12)
    @Max(value = 23)
    @Field("edad")
    private Integer edad;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @NotNull
    @Min(value = 13)
    @Max(value = 23)
    @Field("numeroCredencial")
    private Long numeroCredencial;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @NotNull
    @DecimalMin(value = "15")
    @DecimalMax(value = "23")
    @Field("sueldo")
    private BigDecimal sueldo;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @NotNull
    @DecimalMin(value = "12")
    @DecimalMax(value = "23")
    @Field("impuesto")
    private Float impuesto;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @NotNull
    @DecimalMin(value = "11")
    @DecimalMax(value = "23")
    @Field("impuestoDetalle")
    private Double impuestoDetalle;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @NotNull
    @Field("activo")
    private boolean activo;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @NotNull
    @Field("fechaLocalDate")
    private LocalDate fechaLocalDate;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @NotNull
    @Field("fechaZoneDateTime")
    private ZonedDateTime fechaZoneDateTime;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @NotNull
    @Size(min = 5, max = 5000000)
    @Field("imagen")
    private byte[] imagen;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @Field("imagenContentType")
    private String imagenContentType;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @NotNull
    @Size(min = 78, max = 5000000)
    @Field("imagenAnyBlob")
    private byte[] imagenAnyBlob;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @Field("imagenAnyBlobContentType")
    private String imagenAnyBlobContentType;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @NotNull
    @Size(min = 21, max = 5000000)
    @Field("imagenBlob")
    private byte[] imagenBlob;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @Field("imagenBlobContentType")
    private String imagenBlobContentType;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @NotNull
    @Size(min = 3, max = 5000000)
    @Field("desc")
    private String desc;
	
    /**
     * Este campo fue generado automaticamente por KUKULKAN 
     * Este campo corresponde a la tabla DIRECCION
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @NotNull
    @Field("instante")
    private Instant instante;
	
    /**
     * Este constructor fue generado automáticamente por KUKULKAN
     * 
     */
    public Direccion() {

    }
    
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la llave primaria DIRECCION.id
     *
     * @return el valor de id
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public String getId() {
        return id;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la llave primaria. DIRECCION.id
     *
     * @return el valor de area_conocimiento.id
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.nombre
     *
     * @return el valor de nombre
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.nombre
     *
     * @return el valor de Nombre
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.edad
     *
     * @return el valor de edad
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.edad
     *
     * @return el valor de Edad
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.numeroCredencial
     *
     * @return el valor de numeroCredencial
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public Long getNumeroCredencial() {
        return numeroCredencial;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.numeroCredencial
     *
     * @return el valor de NumeroCredencial
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setNumeroCredencial(Long numeroCredencial) {
        this.numeroCredencial = numeroCredencial;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.sueldo
     *
     * @return el valor de sueldo
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public BigDecimal getSueldo() {
        return sueldo;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.sueldo
     *
     * @return el valor de Sueldo
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.impuesto
     *
     * @return el valor de impuesto
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public Float getImpuesto() {
        return impuesto;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.impuesto
     *
     * @return el valor de Impuesto
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setImpuesto(Float impuesto) {
        this.impuesto = impuesto;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.impuestoDetalle
     *
     * @return el valor de impuestoDetalle
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public Double getImpuestoDetalle() {
        return impuestoDetalle;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.impuestoDetalle
     *
     * @return el valor de ImpuestoDetalle
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setImpuestoDetalle(Double impuestoDetalle) {
        this.impuestoDetalle = impuestoDetalle;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.activo
     *
     * @return el valor de activo
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public boolean getActivo() {
        return activo;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.activo
     *
     * @return el valor de Activo
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.fechaLocalDate
     *
     * @return el valor de fechaLocalDate
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public LocalDate getFechaLocalDate() {
        return fechaLocalDate;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.fechaLocalDate
     *
     * @return el valor de FechaLocalDate
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setFechaLocalDate(LocalDate fechaLocalDate) {
        this.fechaLocalDate = fechaLocalDate;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.fechaZoneDateTime
     *
     * @return el valor de fechaZoneDateTime
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public ZonedDateTime getFechaZoneDateTime() {
        return fechaZoneDateTime;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.fechaZoneDateTime
     *
     * @return el valor de FechaZoneDateTime
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setFechaZoneDateTime(ZonedDateTime fechaZoneDateTime) {
        this.fechaZoneDateTime = fechaZoneDateTime;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.imagen
     *
     * @return el valor de imagen
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.imagen
     *
     * @return el valor de Imagen
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.imagenContentType
     *
     * @return el valor de imagenContentType
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public String getImagenContentType() {
        return imagenContentType;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.imagenContentType
     *
     * @return el valor de ImagenContentType
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setImagenContentType(String imagenContentType) {
        this.imagenContentType = imagenContentType;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.imagenAnyBlob
     *
     * @return el valor de imagenAnyBlob
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public byte[] getImagenAnyBlob() {
        return imagenAnyBlob;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.imagenAnyBlob
     *
     * @return el valor de ImagenAnyBlob
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setImagenAnyBlob(byte[] imagenAnyBlob) {
        this.imagenAnyBlob = imagenAnyBlob;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.imagenAnyBlobContentType
     *
     * @return el valor de imagenAnyBlobContentType
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public String getImagenAnyBlobContentType() {
        return imagenAnyBlobContentType;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.imagenAnyBlobContentType
     *
     * @return el valor de ImagenAnyBlobContentType
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setImagenAnyBlobContentType(String imagenAnyBlobContentType) {
        this.imagenAnyBlobContentType = imagenAnyBlobContentType;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.imagenBlob
     *
     * @return el valor de imagenBlob
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public byte[] getImagenBlob() {
        return imagenBlob;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.imagenBlob
     *
     * @return el valor de ImagenBlob
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setImagenBlob(byte[] imagenBlob) {
        this.imagenBlob = imagenBlob;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.imagenBlobContentType
     *
     * @return el valor de imagenBlobContentType
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public String getImagenBlobContentType() {
        return imagenBlobContentType;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.imagenBlobContentType
     *
     * @return el valor de ImagenBlobContentType
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setImagenBlobContentType(String imagenBlobContentType) {
        this.imagenBlobContentType = imagenBlobContentType;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.desc
     *
     * @return el valor de desc
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.desc
     *
     * @return el valor de Desc
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método GETTER fue generado para la propiedad DIRECCION.instante
     *
     * @return el valor de instante
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public Instant getInstante() {
        return instante;
    }

    /**
     * Este método fue generado automaticamente por KUKULKAN 
     * Este método SETTER fue generado para la propiedad. DIRECCION.instante
     *
     * @return el valor de Instante
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    public void setInstante(Instant instante) {
        this.instante = instante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Direccion entity = (Direccion) o;
        if (entity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), entity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    /**
     * Este método fue generado automaticamente por KUKULKAN
     *
     * @return el valor de representado por la entidad Direccion
     *
     * @kukulkanGenerated 2017-12-14T19:33:36Z
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append(", numeroCredencial=").append(numeroCredencial);
        sb.append(", sueldo=").append(sueldo);
        sb.append(", impuesto=").append(impuesto);
        sb.append(", impuestoDetalle=").append(impuestoDetalle);
        sb.append(", activo=").append(activo);
        sb.append(", fechaLocalDate=").append(fechaLocalDate);
        sb.append(", fechaZoneDateTime=").append(fechaZoneDateTime);
        sb.append(", imagen=").append(imagen);
        sb.append(", imagenContentType=").append(imagenContentType);
        sb.append(", imagenAnyBlob=").append(imagenAnyBlob);
        sb.append(", imagenAnyBlobContentType=").append(imagenAnyBlobContentType);
        sb.append(", imagenBlob=").append(imagenBlob);
        sb.append(", imagenBlobContentType=").append(imagenBlobContentType);
        sb.append(", desc=").append(desc);
        sb.append(", instante=").append(instante);
        sb.append("]");
        return sb.toString();
    }
}
