package tr.com.trackago.server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.trackago.tadto.BaseDTO;
import tr.com.trackago.tavalidator.annotations.Required;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SiteRequest extends BaseDTO {

    private String name;
    @Required
    private Long  categoryId;
    private String unit;
    private String desc;

}
