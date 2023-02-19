package tr.com.trackago.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import tr.com.trackago.server.base.entity.BaseEntity;
import tr.com.trackago.server.common.CarBrandsEnum;
import tr.com.trackago.server.common.ColorEnum;
import tr.com.trackago.server.common.FloorEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CAR")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "flat_id")
    private Flat flat;

    @Column(name = "plate", nullable = false, length = 15)
    private String plate;

    @Column(name = "brand")
    @Enumerated(EnumType.STRING)
    private CarBrandsEnum brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private ColorEnum color;

    @Column(name = "guest", nullable = false)
    private boolean isGuest;

    @Column(name = "phone", nullable = false)
    private String phone;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createDate;

}
