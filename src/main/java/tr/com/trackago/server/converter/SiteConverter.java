package tr.com.trackago.server.converter;

import org.mapstruct.*;
import tr.com.trackago.server.domain.Site;
import tr.com.trackago.server.dto.domain.SiteDTO;
import tr.com.trackago.taconverter.TrackAgoConverter;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BlockConverter.class})
public interface SiteConverter extends TrackAgoConverter<Site, SiteDTO> {

    @Override
    @Named("toDto")
    @Mappings({@Mapping(source = "description", target = "desc")
    })
    SiteDTO entityToDto(Site entityObject);

    @Override
    @InheritInverseConfiguration
    Site dtoToEntity(SiteDTO dtoObject);


    @IterableMapping(qualifiedByName = "toDto")
    List<SiteDTO> map(List<Site> products);

}
