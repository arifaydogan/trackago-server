package tr.com.trackago.server.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import tr.com.trackago.server.config.ServerExceptionHandler;
import tr.com.trackago.server.dto.TrackAgoRequest;
import tr.com.trackago.server.dto.domain.CategoryDTO;
import tr.com.trackago.server.dto.request.CategoryRequest;
import tr.com.trackago.server.service.CategoryService;
import tr.com.trackago.taaspect.annotations.TrackAgoRequestMapping;
import tr.com.trackago.taaspect.annotations.TrackAgoRestController;
import tr.com.trackago.tadto.TrackAgoResponse;
import tr.com.trackago.taexception.TrackAgoException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = "Category Services")
@TrackAgoRestController(path = "/category")
public class CategoryController extends ServerExceptionHandler {


    @Autowired
    CategoryService categoryService;

    @TrackAgoRequestMapping(path = "/health")
    TrackAgoResponse<String> health(@Valid @RequestBody TrackAgoRequest<String> test, HttpServletRequest request) throws TrackAgoException {
        return TrackAgoResponse.<String>builder()
                .body("OK")
                .success()
                .buildInstance();
    }

    @TrackAgoRequestMapping(path = "/add")
    TrackAgoResponse<CategoryDTO> add(@Valid @RequestBody TrackAgoRequest<CategoryRequest> input, HttpServletRequest request) throws TrackAgoException {
        CategoryDTO output = categoryService.save(new CategoryDTO(input.getBody()));
        return TrackAgoResponse.<CategoryDTO>builder()
                .body(output)
                .success()
                .buildInstance();
    }


}
