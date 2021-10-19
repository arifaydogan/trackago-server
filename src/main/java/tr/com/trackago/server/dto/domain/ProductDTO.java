package tr.com.trackago.server.dto.domain;

import lombok.*;
import tr.com.trackago.server.dto.request.ProductRequest;
import tr.com.trackago.tadto.BaseDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO extends BaseDTO {

    private Long id;
    private String name;
    private CategoryDTO category;
    private String unit;
    private String desc;

    public ProductDTO(ProductRequest request) {
        this.category = request.getCategory();
        this.name = request.getName();
        this.desc = request.getDesc();
        this.unit = request.getUnit();
    }


}
