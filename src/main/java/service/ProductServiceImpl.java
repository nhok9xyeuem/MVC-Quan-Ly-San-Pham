package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone", 23000000, "iphone 11 the he moi nhat ", "apple"));
        products.put(2, new Product(2, "samsung", 22000000, "samsung not 10 the he moi nhat ", "samsung"));
        products.put(3, new Product(3, "huawei", 3333333, "p30 pro the he moi nhat ", "huawei"));
        products.put(4, new Product(4, "oppo", 3000000, "f11 pro the he moi nhat ", "oppo"));
        products.put(5, new Product(5, "nokia", 99999999, "nokia 1280 huyen thoai ", "nokia"));
        products.put(6, new Product(6, "MI", 23001111, "MI not 7  ", "Tau khua"));

    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }


}
