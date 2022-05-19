package com.ibm.academia.restapi.items.modelo.entidades;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class Producto implements Serializable
{
    private Long id;
    private String nombre;
    private Double precio;
    private String usuarioCreacion;
    private Date fechaCReacion;

    private static final long serialVersionUID = 2807773820680507250L;
}
