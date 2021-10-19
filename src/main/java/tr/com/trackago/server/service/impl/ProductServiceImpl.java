package tr.com.trackago.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.trackago.server.base.dao.TrackAgoBaseDao;
import tr.com.trackago.server.base.service.impl.TrackAgoAbstractServiceImpl;
import tr.com.trackago.server.converter.ProductConverter;
import tr.com.trackago.server.dao.ProductDAO;
import tr.com.trackago.server.domain.Product;
import tr.com.trackago.server.dto.domain.ProductDTO;
import tr.com.trackago.server.service.ProductService;
import tr.com.trackago.taconverter.TrackAgoConverter;
import tr.com.trackago.taexception.TrackAgoBusinessException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl extends TrackAgoAbstractServiceImpl<Product, ProductDTO> implements ProductService {


    ProductDAO dao;
    ProductConverter converter;

    @Autowired
    public ProductServiceImpl(ProductDAO dao, ProductConverter converter) {
        this.dao = dao;
        this.converter = converter;
    }

    @Override
    protected TrackAgoBaseDao getDao() {
        return dao;
    }

    @Override
    protected TrackAgoConverter getConverter() {
        return converter;
    }

    @Override
    protected void preInsertValid(ProductDTO productDTO) throws TrackAgoBusinessException {
        Optional<Product> existingProduct = dao.getByCategory_IdAndName(productDTO.getCategory().getCatId(), productDTO.getName());
        if (existingProduct.isPresent())
            throw new TrackAgoBusinessException("This Product already exist in the Category", this.getClass().getSimpleName(), "preInsert");
    }

    @Override
    protected void preUpdateValid(ProductDTO productDTO) throws TrackAgoBusinessException {

    }

    @Override
    protected void preDeleteValid(ProductDTO productDTO) throws TrackAgoBusinessException {

    }

    @Override
    protected void validate(ProductDTO productDTO) throws TrackAgoBusinessException {

    }


    @Override
    public List<ProductDTO> getAllByCategory(Long category) {
        return toListDto(dao.getAllByCategory_Id(category));
    }
}
