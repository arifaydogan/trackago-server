package tr.com.trackago.server.converter;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tr.com.trackago.server.domain.Payment;
import tr.com.trackago.server.dto.domain.PaymentDTO;
import tr.com.trackago.taconverter.TrackAgoConverter;

@Mapper(componentModel = "spring")
public interface PaymentConverter extends TrackAgoConverter<Payment, PaymentDTO> {

    @Override
    PaymentDTO entityToDto(Payment entityObject);

    @Override
    @InheritInverseConfiguration
    Payment dtoToEntity(PaymentDTO dtoObject);
}