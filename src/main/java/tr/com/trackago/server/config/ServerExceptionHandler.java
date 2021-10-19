package tr.com.trackago.server.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import tr.com.trackago.taaspect.data.TrackAgoLogData;
import tr.com.trackago.tadto.TrackAgoResponse;
import tr.com.trackago.taexception.TrackAgoAuthException;
import tr.com.trackago.taexception.TrackAgoBusinessException;
import tr.com.trackago.taexception.handler.TrackAgoExceptionHandler;
import tr.com.trackago.talogging.TrackAgoLogger;
import tr.com.trackago.talogging.TrackAgoLoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

public class ServerExceptionHandler extends TrackAgoExceptionHandler {

    TrackAgoLogger LOGGER = TrackAgoLoggerFactory.getLogger(ServerExceptionHandler.class);

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(TrackAgoBusinessException.class)
    public TrackAgoResponse<String> handleTrackAgoBusinessExceptions(TrackAgoBusinessException ex, HttpServletRequest request) throws JsonProcessingException {
        TrackAgoResponse<String> response = super.handleTrackAgoBusinessExceptions(ex);
        exceptionLog(request, response, ex.getMessage());
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalAccessException.class)
    public TrackAgoResponse<String> handleIllegalAccessExceptions(IllegalAccessException ex, HttpServletRequest request) throws JsonProcessingException {
        TrackAgoResponse<String> response = super.handleIllegalAccessExceptions(ex);
        exceptionLog(request, response, ex.getMessage());
        return response;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(TrackAgoAuthException.class)
    public TrackAgoResponse<String> handleAuthenticationExceptions(TrackAgoAuthException ex, HttpServletRequest request) throws JsonProcessingException {
        TrackAgoResponse<String> response = super.handleAuthenticationExceptions(ex);
        exceptionLog(request, response, ex.getMessage());
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvocationTargetException.class)
    public TrackAgoResponse<String> handleInvocationTargetExceptions(InvocationTargetException ex, HttpServletRequest request) throws JsonProcessingException {
        TrackAgoResponse<String> response = super.handleInvocationTargetExceptions(ex);
        exceptionLog(request, response, ex.getMessage());
        return response;

    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(RemoteException.class)
    public TrackAgoResponse<String> handleRemoteExceptions(RemoteException ex, HttpServletRequest request) throws JsonProcessingException {
        TrackAgoResponse<String> response = super.handleRemoteExceptions(ex);
        exceptionLog(request, response, ex.getMessage());
        return response;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JsonProcessingException.class)
    public TrackAgoResponse<String> handleJsonProcessingException(JsonProcessingException ex, HttpServletRequest request) throws JsonProcessingException {
        TrackAgoResponse<String> response = super.handleJsonProcessingException(ex);
        exceptionLog(request, response, ex.getMessage());
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public TrackAgoResponse<String> handleOtherExceptions(Exception ex, HttpServletRequest request) throws JsonProcessingException {
        TrackAgoResponse<String> response = super.handleOtherExceptions(ex);
        exceptionLog(request, response, ex.getMessage());
        return response;
    }


    @Override
    public void sendNotification(String exceptionTitle, String responseStr, String exceptionStackTrace) {
        //hataları bildirmek için mail atılabilir.
    }

    private void exceptionLog(HttpServletRequest request, TrackAgoResponse<String> response, String exceptionMessage) throws JsonProcessingException {
        TrackAgoLogData logData = (TrackAgoLogData) request.getAttribute("trackAgoLogData");
        logData.setException(true);
        logData.setExceptionMessage(exceptionMessage);
        logData.setResponse(objectMapperInstance().writeValueAsString(response));
        LOGGER.info(logData.toString());
    }
}
