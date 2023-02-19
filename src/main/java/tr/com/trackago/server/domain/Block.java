package tr.com.trackago.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import tr.com.trackago.server.base.entity.BaseEntity;
import tr.com.trackago.server.common.UnitEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BLOCK")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Block extends BaseEntity {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blockId;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "site_id")
    private Site site;

    @Column(name = "number_of_floors")
    private int numberOfFloors;

    @Column(name = "electric_no")
    private String electricNo;

    @Column(name = "water_meter")
    private String waterMeter;

    @Column(name = "gas_meter")
    private String gasMeter;

    @Column(name = "internet_subs")
    private String internetSubs;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createDate;

}
