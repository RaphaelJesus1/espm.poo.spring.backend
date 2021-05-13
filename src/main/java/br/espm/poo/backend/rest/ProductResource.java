package br.espm.poo.backend.rest;

import br.espm.poo.backend.datatype.ProductBean;
import br.espm.poo.backend.service.ProductService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/products")
    public Map<UUID, ProductBean> listAll() {
        return productService.listAll();
    }

    @GetMapping(path="/products/{id}")
    public ProductBean findById(@PathVariable UUID id) {
        return productService.findById(id);
    }

    @PostMapping(path="/products")
    public void create(@RequestBody ProductBean product) {
        productService.create(product);
    }

    @PatchMapping(path = "/products/newprice/{id}/{price}")
    public ProductBean update(@PathVariable UUID id, @PathVariable double price) {
        return productService.updatePrice(id, price);
    }

    @DeleteMapping(path = "/products/{id}")
    public void delete(@PathVariable UUID id) {
        productService.delete(id);
    }
}
