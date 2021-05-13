package br.espm.poo.backend.service;

import br.espm.poo.backend.datatype.ProductBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class ProductService {
    private static Map<UUID, ProductBean> products = new HashMap<>();

    static {
        ProductBean p1 = new ProductBean(UUID.randomUUID(), "Caneta", 2.5);
        ProductBean p2 = new ProductBean(UUID.randomUUID(), "Borracha", 3.5);
        ProductBean p3 = new ProductBean(UUID.randomUUID(), "Quadro branco", 60);
        ProductBean p4 = new ProductBean(UUID.randomUUID(), "Apagador", 10);
        ProductBean p5 = new ProductBean(UUID.randomUUID(), "Grafite 0.7", 5.7);

        products.put(p1.getId(), p1);
        products.put(p2.getId(), p2);
        products.put(p3.getId(), p3);
        products.put(p4.getId(), p4);
        products.put(p5.getId(), p5);
    }

    public Map<UUID, ProductBean> listAll() { return products; }

    public ProductBean findById(UUID id) {
        for(Map.Entry<UUID, ProductBean> product:products.entrySet()) {
            if(product.getValue().getId().equals(id)){
                return product.getValue();
            }
        }
        return null;
    }

    public ProductBean updatePrice(UUID id, double newPrice) {
        if(products.get(id) != null) {
            ProductBean product = products.get(id);
            ProductBean newProduct = new ProductBean(product.getId(), product.getName(), newPrice);

            products.replace(id, product, newProduct);
            return newProduct;
        }
        return null;
    }

    public void create(ProductBean product) {
        if(product.getId() == null) {
            product.setId(UUID.randomUUID());
        }
        if(product.getPrice() == 0) {
            product.setPrice(15);
        }
        products.put(product.getId(), product);
    }

    public void delete(UUID id) { products.remove(id); }
}
