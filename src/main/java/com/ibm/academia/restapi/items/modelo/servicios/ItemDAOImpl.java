package com.ibm.academia.restapi.items.modelo.servicios;

import com.ibm.academia.restapi.items.modelo.entidades.Articulo;
import com.ibm.academia.restapi.items.modelo.entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemDAOImpl implements ItemDAO
{
    @Autowired
    private RestTemplate clienteRest;


    @Override
    public List<Articulo> buscarTodosArticulos() {

        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/api/v1/rest-productos/producto/listar", Producto[].class));
        return productos
                .stream()
                .map(p -> new Articulo(p,1))
                .collect(Collectors.toList());
    }

    @Override
    public Articulo buscarArticuloPorId(Long id, Integer cantidad) {

        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        Producto producto = clienteRest.getForObject("http://localhost:8001/api/v1/rest-productos/producto/ver-detalle/productoId/(Id)", Producto.class, pathVariables);
        return new Articulo(producto, cantidad);

    }
}



