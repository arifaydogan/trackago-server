package tr.com.trackago.server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.trackago.server.dto.domain.CategoryDTO;
import tr.com.trackago.tadto.BaseDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest extends BaseDTO {

    private String name;
    private String desc;


}
