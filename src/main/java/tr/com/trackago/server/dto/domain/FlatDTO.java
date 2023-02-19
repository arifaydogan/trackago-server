package tr.com.trackago.server.dto.domain;

import lombok.*;
import tr.com.trackago.server.common.FloorEnum;
import tr.com.trackago.server.common.FrontEnum;
import tr.com.trackago.tadto.BaseDTO;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlatDTO extends BaseDTO {

    private Long flatId;

    private String doorNumber;

    private BlockDTO block;

    private FloorEnum floor;

    private FrontEnum front;

    private String numberOfRooms;

    private Date createDate;
}
