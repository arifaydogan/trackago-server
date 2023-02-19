package tr.com.trackago.server.converter;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import tr.com.trackago.server.domain.User;
import tr.com.trackago.server.dto.domain.UserDTO;
import tr.com.trackago.taconverter.TrackAgoConverter;

@Mapper(componentModel = "spring")
public interface UserConverter extends TrackAgoConverter<User, UserDTO> {

    @Override
    UserDTO entityToDto(User entityObject);

    @Override
    @InheritInverseConfiguration
    User dtoToEntity(UserDTO dtoObject);
}