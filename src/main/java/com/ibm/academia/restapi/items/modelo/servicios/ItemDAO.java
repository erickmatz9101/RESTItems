package com.ibm.academia.restapi.items.modelo.servicios;

import com.ibm.academia.restapi.items.modelo.entidades.Articulo;

import java.util.List;

public interface ItemDAO
{
     List<Articulo>buscarTodosArticulos();
     Articulo buscarArticuloPorId(Long id, Integer cantidad);


}
