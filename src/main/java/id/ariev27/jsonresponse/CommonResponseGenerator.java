package id.ariev27.jsonresponse;

import java.util.UUID;

public class CommonResponseGenerator {

    public <T> CommonResponse<T> generateCommonResponse(String code, String message) {
        CommonResponse<T> resp = new CommonResponse<T>();
        resp.setRequestId(generateRequestId());
        resp.setCode(code);
        resp.setMessage(message);
        return resp;
    }

    public <T> CommonResponse<T> generateCommonResponse(String code, String message, T data) {
        CommonResponse<T> resp = new CommonResponse<T>();
        resp.setRequestId(generateRequestId());
        resp.setCode(code);
        resp.setMessage(message);
        resp.setData(data);
        return resp;
    }

    private String generateRequestId() {
        return UUID.randomUUID().toString();
    }
}
