package model.web_api_response;

import com.google.gson.JsonObject;
import lombok.Data;

@Data
public class WebApiResponse {

    private boolean isSuccess;

    private Object content;

    private String errorMessage;

    public WebApiResponse(boolean isSuccess, Object content, String errorMessage) {
        this.isSuccess = isSuccess;
        this.content = content;
        this.errorMessage = errorMessage;
    }
}
