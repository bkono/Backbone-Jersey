package com.xebia.data;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xebia.representation.Product;

public class Products {

	static Map<Long, Product> products = Maps.newHashMap();
	
	public static List<Product> get() {
		for (Product product : products.values())
			product.getLinks().clear();
		
		return Lists.newArrayList(products.values());
	}
	
	public static Product get(long id) {
		Product product = products.get(id);
		product.getLinks().clear();
		return product;
	}
	
	static long productCount = 0;
	
	public static void put(Product product) {
		product.setId(productCount++);
		products.put(product.getId(), product);
	}

	public static void delete(long id) {
		products.remove(id);
	}
}