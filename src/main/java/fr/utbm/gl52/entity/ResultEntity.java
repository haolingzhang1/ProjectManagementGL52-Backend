package fr.utbm.gl52.entity;


import lombok.Data;
import java.io.Serializable;
@Data
public class ResultEntity implements Serializable{
   // private Long id;
    /**
     * return result
     */
    private boolean isSuccess;

    /**
     * return message
     */
    private String message;
    /**
     * return code
     */
   // private int status;
    /**
     * return data
     */
    private Object data;

    public boolean isSuccess() {
        return isSuccess;
    }
    public void setSuccess(boolean success) {
        isSuccess = success;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
