package tr.com.trackago.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import tr.com.trackago.server.base.entity.BaseEntity;
import tr.com.trackago.server.common.FloorEnum;
import tr.com.trackago.server.common.FrontEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FLAT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flat extends BaseEntity {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flatId;

    @Column(name = "door_number", nullable = false, length = 5)
    private String doorNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "block_id")
    private Block block;

    @Column(name = "floor")
    @Enumerated(EnumType.STRING)
    private FloorEnum floor;

    @Column(name = "front")
    @Enumerated(EnumType.STRING)
    private FrontEnum front;

    @Column(name = "number_of_rooms")
    private String numberOfRooms;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "added_time")
    private Date createDate;

}
