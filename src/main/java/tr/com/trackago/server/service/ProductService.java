package tr.com.trackago.server.service;

import tr.com.trackago.server.base.service.TrackAgoAbstractService;
import tr.com.trackago.server.domain.Product;
import tr.com.trackago.server.dto.domain.ProductDTO;

import java.util.List;

public interface ProductService extends TrackAgoAbstractService<Product, ProductDTO> {

    List<ProductDTO> getAllByCategory(Long category);

}
