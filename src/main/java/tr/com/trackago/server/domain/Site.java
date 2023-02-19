package tr.com.trackago.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.trackago.server.base.entity.BaseEntity;
import tr.com.trackago.server.common.CityEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SITE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Site extends BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long siteId;

    @NotNull
    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "adress", length = 500)
    private String adress;

    @Column(name = "block_of_building")
    private String blockOfBuilding;

    @Column(name = "parcel")
    private String parcel;

    @Column(name = "area")
    private Double area;

    @Column(name = "city")
    @Enumerated(EnumType.STRING)
    private CityEnum city;

    @Column(name = "district")
    private String district;

    @Column(name = "neighbourhood")
    private String neighbourhood;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

}
