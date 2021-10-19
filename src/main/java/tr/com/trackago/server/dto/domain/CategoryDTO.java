package tr.com.trackago.server.dto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.trackago.server.dto.request.CategoryRequest;
import tr.com.trackago.tadto.BaseDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO extends BaseDTO {

    private Long catId;
    private String name;
    private String desc;

    public CategoryDTO(CategoryRequest request) {
        this.name = request.getName();
        this.desc = request.getDesc();
    }

}
