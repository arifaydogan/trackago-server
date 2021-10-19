package tr.com.trackago.server.dto;

import lombok.Getter;
import lombok.Setter;
import tr.com.trackago.tadto.TrackAgoBaseRequest;

import javax.validation.Valid;

@Getter
@Setter
public class TrackAgoRequest<T> extends TrackAgoBaseRequest {

    @Valid
    private T body;
}
