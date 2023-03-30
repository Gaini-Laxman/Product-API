package com.klinnovations.productservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klinnovations.model.Product;
import com.klinnovations.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	public ProductRepository prrepo;

	public List<Product> findAll() {
		return prrepo.findAll();

	}

	public Product findByName(String pname) {
		return prrepo.findByPname(pname).orElseThrow(() -> new RuntimeException("Product Not Found"));
	}

	public Product saveProduct(Product p) {
		return prrepo.save(p);
	}

	public Product updateProduct(int pid, Product pr) {
		Product existing = prrepo.findById(pid)
				.orElseThrow(() -> new RuntimeException("No Product available with ID :: +pid"));

		if (pr.getPname() != null)
			existing.setPname(pr.getPname());
		if (pr.getPrice() != null)
			existing.setPrice(pr.getPrice());
		if (pr.getQuantity() != null)
			existing.setQuantity(pr.getQuantity());

		return prrepo.save(existing);

	}

	public String deleteProduct(int pid) {
		Product existing = prrepo.findById(pid)
				.orElseThrow(() -> new RuntimeException("No Product available with ID :: +pid"));
		prrepo.deleteById(pid);
		return "Product Deleted";

	}

}
