package tr.com.trackago.server.converter;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tr.com.trackago.server.domain.Resident;
import tr.com.trackago.server.dto.domain.ResidentDTO;
import tr.com.trackago.taconverter.TrackAgoConverter;

@Mapper(componentModel = "spring")
public interface ResidentConverter extends TrackAgoConverter<Resident, ResidentDTO> {

    @Override
    ResidentDTO entityToDto(Resident entityObject);

    @Override
    @InheritInverseConfiguration
    Resident dtoToEntity(ResidentDTO dtoObject);
}