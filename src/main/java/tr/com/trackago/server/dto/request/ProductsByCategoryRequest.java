package tr.com.trackago.server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.trackago.tadto.BaseDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsByCategoryRequest extends BaseDTO {

    private Long categoryId;

}
