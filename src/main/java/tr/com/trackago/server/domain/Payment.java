package tr.com.trackago.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import tr.com.trackago.server.base.entity.BaseEntity;
import tr.com.trackago.server.common.CarBrandsEnum;
import tr.com.trackago.server.common.ColorEnum;
import tr.com.trackago.server.common.PaymenTypeEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PAYMENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends BaseEntity {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "flat_id")
    private Flat flat;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PaymenTypeEnum type;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "due_date")
    private Date dueDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "month", nullable = false)
    private String month;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

}
