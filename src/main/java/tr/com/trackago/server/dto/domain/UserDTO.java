package tr.com.trackago.server.dto.domain;

import lombok.*;
import tr.com.trackago.server.common.RoleEnum;
import tr.com.trackago.tadto.BaseDTO;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO extends BaseDTO {

    private Long userId;

    private ResidentDTO resident;

    private String password;

    private RoleEnum role;

    private Date createDate;

    private Date updatedDate;
}
