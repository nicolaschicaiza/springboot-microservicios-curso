package com.formacionbdi.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * PerTiempoTranscurridoFilter
 */
@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);

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

    log.info("Entrando a Post filter");

    Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
    Long tiempoFinal = System.currentTimeMillis();
    Long tiempoTranscurrido = tiempoFinal - tiempoInicio;

    log.info(String.format("Tiempo transcurrido en segundos %s seg", tiempoTranscurrido.doubleValue() / 1000.00));
    log.info(String.format("Tiempo transcurrido en miliseg %s ms", tiempoTranscurrido));
    return null;
  }

  @Override
  public String filterType() {
    // Se define el tipo de filtro a través de un String
    // con las palabras clave "pre", "post", "route" y "error"
    return "post";
  }

  @Override
  public int filterOrder() {
    // Se define el orden de ejecución del filtro
    return 1;
  }

}
