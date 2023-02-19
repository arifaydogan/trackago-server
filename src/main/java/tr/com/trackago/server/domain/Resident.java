package tr.com.trackago.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import tr.com.trackago.server.base.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RESIDENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resident extends BaseEntity {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long residentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "flat_id")
    private Flat flat;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "surname", nullable = false, length = 200)
    private String surname;

    @Column(name = "tckn", nullable = false, length = 11)
    private String tckn;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "contact_person", nullable = false)
    private boolean isContactPerson;

    @Column(name = "proprietor", nullable = false)
    private boolean isProprietor;

    @Column(name = "active", nullable = false)
    private boolean active;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createDate;

}
