package tr.com.trackago.server.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import tr.com.trackago.server.config.ServerExceptionHandler;
import tr.com.trackago.server.dto.TrackAgoRequest;
import tr.com.trackago.server.dto.domain.ProductDTO;
import tr.com.trackago.server.dto.request.ProductRequest;
import tr.com.trackago.server.dto.request.ProductsByCategoryRequest;
import tr.com.trackago.server.service.ProductService;
import tr.com.trackago.taaspect.annotations.TrackAgoRequestMapping;
import tr.com.trackago.taaspect.annotations.TrackAgoRestController;
import tr.com.trackago.tadto.TrackAgoResponse;
import tr.com.trackago.taexception.TrackAgoException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Api(tags = "Product Services")
@TrackAgoRestController(path = "/product")
public class ProductController extends ServerExceptionHandler {


    @Autowired
    ProductService productService;

    @TrackAgoRequestMapping(path = "/health")
    TrackAgoResponse<String> health(@Valid @RequestBody TrackAgoRequest<String> test, HttpServletRequest request) throws TrackAgoException {
        return TrackAgoResponse.<String>builder()
                .body("OK")
                .success()
                .buildInstance();
    }

    @TrackAgoRequestMapping(path = "/add")
    TrackAgoResponse<ProductDTO> add(@Valid @RequestBody TrackAgoRequest<ProductRequest> input, HttpServletRequest request) throws TrackAgoException {
        ProductDTO output = productService.save(new ProductDTO(input.getBody()));
        return TrackAgoResponse.<ProductDTO>builder()
                .body(output)
                .success()
                .buildInstance();
    }


    @TrackAgoRequestMapping(path = "/getAllProductsByCategory")
    TrackAgoResponse<List<ProductDTO>> all(@Valid @RequestBody TrackAgoRequest<ProductsByCategoryRequest> input, HttpServletRequest request) throws TrackAgoException {
        List<ProductDTO> output = productService.getAllByCategory(input.getBody().getCategoryId());
        return TrackAgoResponse.<List<ProductDTO>>builder()
                .body(output)
                .success()
                .buildInstance();
    }

}
