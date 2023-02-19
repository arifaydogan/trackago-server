package tr.com.trackago.server.dto.domain;

import lombok.*;
import tr.com.trackago.server.dto.request.BlockRequest;
import tr.com.trackago.tadto.BaseDTO;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlockDTO extends BaseDTO {

    private Long blockId;

    private String name;

    private Long siteId;

    private int numberOfFloors;

    private String electricSubs;

    private String waterMeter;

    private String gasMeter;

    private String internetSubs;

    private Date createDate;

    public BlockDTO(BlockRequest request) {
        this.name = request.getName();
    }


}
