package tr.com.trackago.server.dto.domain;

import lombok.*;
import tr.com.trackago.tadto.BaseDTO;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResidentDTO extends BaseDTO {

    private Long residentId;

    private FlatDTO flat;

    private String name;

    private String surname;

    private String tckn;

    private String phone;

    private boolean isContactPerson;

    private boolean isProprietor;

    private boolean active;

    private Date createDate;
}
