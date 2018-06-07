/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juanma
 */
@Entity
@Table(name = "tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tag.findAll", query = "SELECT t FROM Tag t")
    , @NamedQuery(name = "Tag.findByNombreTag", query = "SELECT t FROM Tag t WHERE t.nombreTag = :nombreTag")})
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "nombre_Tag")
    private String nombreTag;
    @JoinColumn(name = "id_noticia", referencedColumnName = "id_noticia")
    @ManyToOne(optional = false)
    private Noticia idNoticia;

    public Tag() {
    }

    public Tag(String nombreTag) {
        this.nombreTag = nombreTag;
    }

    public String getNombreTag() {
        return nombreTag;
    }

    public void setNombreTag(String nombreTag) {
        this.nombreTag = nombreTag;
    }

    public Noticia getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Noticia idNoticia) {
        this.idNoticia = idNoticia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreTag != null ? nombreTag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) object;
        if ((this.nombreTag == null && other.nombreTag != null) || (this.nombreTag != null && !this.nombreTag.equals(other.nombreTag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tag[ nombreTag=" + nombreTag + " ]";
    }
    
}
