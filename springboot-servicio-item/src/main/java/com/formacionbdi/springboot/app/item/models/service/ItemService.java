package com.formacionbdi.springboot.app.item.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.item.models.Item;

/**
 * ItemService
 */
public interface ItemService {

  public List<Item> findAll();

  public Item findById(Long id, Integer cantidad);
}
