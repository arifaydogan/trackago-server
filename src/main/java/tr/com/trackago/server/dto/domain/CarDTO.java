package tr.com.trackago.server.dto.domain;

import lombok.*;
import tr.com.trackago.server.common.CarBrandsEnum;
import tr.com.trackago.server.common.ColorEnum;
import tr.com.trackago.tadto.BaseDTO;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDTO extends BaseDTO {

    private Long carId;

    private FlatDTO flat;

    private String plate;

    private CarBrandsEnum brand;

    private String model;

    private ColorEnum color;

    private boolean isGuest;

    private String phone;

    private Date createDate;
}
