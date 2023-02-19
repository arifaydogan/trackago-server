package tr.com.trackago.server.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMethod;
import tr.com.trackago.server.config.ServerExceptionHandler;
import tr.com.trackago.taaspect.annotations.TrackAgoRequestMapping;
import tr.com.trackago.taaspect.annotations.TrackAgoRestController;
import tr.com.trackago.tadto.TrackAgoResponse;
import tr.com.trackago.taexception.TrackAgoException;

@Api(tags = "")
@TrackAgoRestController(path = "/")
public class BaseController extends ServerExceptionHandler {

    @TrackAgoRequestMapping(path = "",method = RequestMethod.GET)
    TrackAgoResponse<String> hello() throws TrackAgoException {
        return TrackAgoResponse.<String>builder()
                .body("Welcome TrackAgo")
                .success()
                .buildInstance();
    }

}
