package tr.com.trackago.server.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import tr.com.trackago.server.config.ServerExceptionHandler;
import tr.com.trackago.server.dto.TrackAgoRequest;
import tr.com.trackago.server.dto.domain.BlockDTO;
import tr.com.trackago.server.dto.request.BlockRequest;
import tr.com.trackago.server.service.BlockService;
import tr.com.trackago.taaspect.annotations.TrackAgoRequestMapping;
import tr.com.trackago.taaspect.annotations.TrackAgoRestController;
import tr.com.trackago.tadto.TrackAgoResponse;
import tr.com.trackago.taexception.TrackAgoException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = "Block Services")
@TrackAgoRestController(path = "/block")
public class BlockController extends ServerExceptionHandler {


    @Autowired
    BlockService blockService;

    @TrackAgoRequestMapping(path = "/health")
    TrackAgoResponse<String> health(@Valid @RequestBody TrackAgoRequest<String> test, HttpServletRequest request) throws TrackAgoException {
        return TrackAgoResponse.<String>builder()
                .body("OK")
                .success()
                .buildInstance();
    }

    @TrackAgoRequestMapping(path = "/add")
    TrackAgoResponse<BlockDTO> add(@Valid @RequestBody TrackAgoRequest<BlockRequest> input, HttpServletRequest request) throws TrackAgoException {
        BlockDTO output = blockService.save(new BlockDTO(input.getBody()));
        return TrackAgoResponse.<BlockDTO>builder()
                .body(output)
                .success()
                .buildInstance();
    }


}
