package tr.com.trackago.server.converter;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tr.com.trackago.server.domain.Block;
import tr.com.trackago.server.dto.domain.BlockDTO;
import tr.com.trackago.taconverter.TrackAgoConverter;

@Mapper(componentModel = "spring")
public interface BlockConverter extends TrackAgoConverter<Block, BlockDTO> {


    @Override
    @Mappings({
            @Mapping(source = "site.siteId", target = "siteId"),
            @Mapping(source = "electricNo", target = "electricSubs")
    })
    BlockDTO entityToDto(Block entityObject);

    @Override
    @InheritInverseConfiguration
    Block dtoToEntity(BlockDTO dtoObject);
}
