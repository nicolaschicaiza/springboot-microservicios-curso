package com.formacionbdi.springboot.app.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * SpringbootServicioZuulServerApplication
 */
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class SpringbootServicioZuulServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootServicioZuulServerApplication.class, args);
  }

}
