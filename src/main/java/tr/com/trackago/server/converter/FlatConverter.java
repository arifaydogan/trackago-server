package tr.com.trackago.server.converter;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tr.com.trackago.server.domain.Flat;
import tr.com.trackago.server.dto.domain.FlatDTO;
import tr.com.trackago.taconverter.TrackAgoConverter;

@Mapper(componentModel = "spring")
public interface FlatConverter extends TrackAgoConverter<Flat, FlatDTO> {

    @Override
    FlatDTO entityToDto(Flat entityObject);

    @Override
    @InheritInverseConfiguration
    Flat dtoToEntity(FlatDTO dtoObject);
}