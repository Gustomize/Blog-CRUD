package com.gsilva.blog.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "tbl_post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "post_seq", sequenceName = "post_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    private long id;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Autor é uma informação obrigatória.")
    private String autor;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Título é uma informação obrigatória.")
    private String titulo;

    @Column(nullable = false, length = 2000)
    @NotBlank(message = "Texto é uma informação obrigatória.")
    private String texto;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Data é uma informação obrigatória.")
    private Date data;

    public long getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Post [id=" + getId() + ", autor=" + getAutor() + ", titulo=" + getTitulo() + ", texto=" + getTexto()
                + ", data=" + getData() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((texto == null) ? 0 : texto.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (id != post.id) return false;
        if (!autor.equals(post.autor)) return false;
        return titulo.equals(post.titulo);
    }
}
