/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juanma
 */
@Entity
@Table(name = "noticia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Noticia.findAll", query = "SELECT n FROM Noticia n")
    , @NamedQuery(name = "Noticia.findByIdNoticia", query = "SELECT n FROM Noticia n WHERE n.idNoticia = :idNoticia")
    , @NamedQuery(name = "Noticia.findByFechaNoticia", query = "SELECT n FROM Noticia n WHERE n.fechaNoticia = :fechaNoticia")
    , @NamedQuery(name = "Noticia.findByLocalizacion", query = "SELECT n FROM Noticia n WHERE n.localizacion = :localizacion")
    , @NamedQuery(name = "Noticia.findByImagen", query = "SELECT n FROM Noticia n WHERE n.imagen = :imagen")})
public class Noticia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_noticia")
    private Integer idNoticia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "titulo_noticia")
    private String tituloNoticia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "subtitulo_noticia")
    private String subtituloNoticia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "cuerpo_noticia")
    private String cuerpoNoticia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_noticia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNoticia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "localizacion")
    private String localizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "imagen")
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNoticia")
    private Collection<Tag> tagCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNoticia")
    private Collection<Comentario> comentarioCollection;
    @JoinColumn(name = "id_historia", referencedColumnName = "id_historia")
    @ManyToOne
    private Historia idHistoria;
    @JoinColumn(name = "nombre_categoria", referencedColumnName = "nombre_categoria")
    @ManyToOne
    private Categoria nombreCategoria;
    @JoinColumn(name = "nombre_usuario", referencedColumnName = "nombre_usuario")
    @ManyToOne
    private Usuario nombreUsuario;

    public Noticia() {
    }

    public Noticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }

    public Noticia(Integer idNoticia, String tituloNoticia, String subtituloNoticia, String cuerpoNoticia, Date fechaNoticia, String localizacion, String imagen) {
        this.idNoticia = idNoticia;
        this.tituloNoticia = tituloNoticia;
        this.subtituloNoticia = subtituloNoticia;
        this.cuerpoNoticia = cuerpoNoticia;
        this.fechaNoticia = fechaNoticia;
        this.localizacion = localizacion;
        this.imagen = imagen;
    }

    public Integer getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getTituloNoticia() {
        return tituloNoticia;
    }

    public void setTituloNoticia(String tituloNoticia) {
        this.tituloNoticia = tituloNoticia;
    }

    public String getSubtituloNoticia() {
        return subtituloNoticia;
    }

    public void setSubtituloNoticia(String subtituloNoticia) {
        this.subtituloNoticia = subtituloNoticia;
    }

    public String getCuerpoNoticia() {
        return cuerpoNoticia;
    }

    public void setCuerpoNoticia(String cuerpoNoticia) {
        this.cuerpoNoticia = cuerpoNoticia;
    }

    public Date getFechaNoticia() {
        return fechaNoticia;
    }

    public void setFechaNoticia(Date fechaNoticia) {
        this.fechaNoticia = fechaNoticia;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @XmlTransient
    public Collection<Tag> getTagCollection() {
        return tagCollection;
    }

    public void setTagCollection(Collection<Tag> tagCollection) {
        this.tagCollection = tagCollection;
    }

    @XmlTransient
    public Collection<Comentario> getComentarioCollection() {
        return comentarioCollection;
    }

    public void setComentarioCollection(Collection<Comentario> comentarioCollection) {
        this.comentarioCollection = comentarioCollection;
    }

    public Historia getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Historia idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Categoria getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(Categoria nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Usuario getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(Usuario nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNoticia != null ? idNoticia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Noticia)) {
            return false;
        }
        Noticia other = (Noticia) object;
        if ((this.idNoticia == null && other.idNoticia != null) || (this.idNoticia != null && !this.idNoticia.equals(other.idNoticia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Noticia[ idNoticia=" + idNoticia + " ]";
    }
    
}
