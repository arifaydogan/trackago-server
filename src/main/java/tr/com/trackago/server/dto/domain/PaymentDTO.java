package tr.com.trackago.server.dto.domain;

import lombok.*;
import tr.com.trackago.server.common.PaymenTypeEnum;
import tr.com.trackago.tadto.BaseDTO;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO extends BaseDTO {

    private Long paymentId;

    private FlatDTO flat;

    private PaymenTypeEnum type;

    private Date dueDate;

    private Date paymentDate;

    private String month;

    private int year;

    private String description;

    private Date createDate;

    private Date updatedDate;
}
