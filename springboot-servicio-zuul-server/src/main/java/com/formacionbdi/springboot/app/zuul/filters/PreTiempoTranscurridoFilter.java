package com.formacionbdi.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.org.slf4j.internal.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * PerTiempoTranscurridoFilter
 */
@Component
public class PreTiempoTranscurridoFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(PreTiempoTranscurridoFilter.class);

  @Override
  public boolean shouldFilter() {
    // Este método permite validar, si se va a ejecutar el filtro o no,
    // por lo tanto, se puede realizar una validación cualquiera
    // para ejecutar el filtro. Si retorna "true" ejecuta el filtro.
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    // Aquí se resuelve la lógica del filtro

    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();

    log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));

    Long tiempoInicio = System.currentTimeMillis();
    request.setAttribute("timepoInicio", tiempoInicio);
    return null;
  }

  @Override
  public String filterType() {
    // Se define el tipo de filtro a través de un String
    // con las palabras clave "pre", "post" y "route"
    return "pre";
  }

  @Override
  public int filterOrder() {
    // Se define el orden de ejecución del filtro
    return 1;
  }

}
