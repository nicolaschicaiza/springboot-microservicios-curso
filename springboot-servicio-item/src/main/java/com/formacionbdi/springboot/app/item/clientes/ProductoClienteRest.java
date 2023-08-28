package com.formacionbdi.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.springboot.app.item.models.Producto;

/**
 * ProductoClienteRest
 */
@FeignClient(name = "servicio-productos") // , url = "localhost:8001", desacoplar ubicación fisica
public interface ProductoClienteRest {

  @GetMapping("/listar")
  public List<Producto> listar();

  @GetMapping("/ver/{id}")
  public Producto detalle(@PathVariable Long id);

}
