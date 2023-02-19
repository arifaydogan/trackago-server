package tr.com.trackago.server.dto.domain;

import lombok.*;
import tr.com.trackago.server.common.CityEnum;
import tr.com.trackago.tadto.BaseDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SiteDTO extends BaseDTO {

    private Long siteId;

    private String name;

    private String desc;

    private String adress;

    private String blockOfBuilding;

    private String parcel;

    private Double area;

    private CityEnum city;

    private String district;

    private String neighbourhood;

    private String street;

    private String number;
}
