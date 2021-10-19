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
public class ProductRequest extends BaseDTO {

    private String name;
    private CategoryDTO category;
    private String unit;
    private String desc;

}
