package tr.com.trackago.server.converter;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tr.com.trackago.server.domain.Category;
import tr.com.trackago.server.dto.domain.CategoryDTO;
import tr.com.trackago.taconverter.TrackAgoConverter;

@Mapper(componentModel = "spring")
public interface CategoryConverter extends TrackAgoConverter<Category, CategoryDTO> {


    @Override
    @Mappings({
            @Mapping(source = "description", target = "desc"),
            @Mapping(source = "id", target = "catId")
    })
    CategoryDTO entityToDto(Category entityObject);

    @Override
    @InheritInverseConfiguration
    Category dtoToEntity(CategoryDTO dtoObject);
}
