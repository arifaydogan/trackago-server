package tr.com.trackago.server.converter;

import org.mapstruct.*;
import tr.com.trackago.server.domain.Product;
import tr.com.trackago.server.dto.domain.ProductDTO;
import tr.com.trackago.taconverter.TrackAgoConverter;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryConverter.class})
public interface ProductConverter extends TrackAgoConverter<Product, ProductDTO> {

    @Override
    @Named("toDto")
    @Mappings({@Mapping(source = "description", target = "desc")
    })
    ProductDTO entityToDto(Product entityObject);

    @Override
    @InheritInverseConfiguration
    Product dtoToEntity(ProductDTO dtoObject);


    @IterableMapping(qualifiedByName = "toDto")
    List<ProductDTO> map(List<Product> products);

}
