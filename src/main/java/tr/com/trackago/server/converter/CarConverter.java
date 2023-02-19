package tr.com.trackago.server.converter;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import tr.com.trackago.server.domain.Car;
import tr.com.trackago.server.dto.domain.CarDTO;
import tr.com.trackago.taconverter.TrackAgoConverter;

@Mapper(componentModel = "spring")
public interface CarConverter extends TrackAgoConverter<Car, CarDTO> {

    @Override
    CarDTO entityToDto(Car entityObject);

    @Override
    @InheritInverseConfiguration
    Car dtoToEntity(CarDTO dtoObject);
}