package fr.utbm.gl52.entity;


import lombok.Data;
import java.io.Serializable;
@Data
public class ResultEntity implements Serializable{
    private Long id;
    /**
     * return result
     */
    private boolean isSuccess;
    /**
     * return code
     */
    private int status;
    /**
     * return data
     */
    private Object data;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isSuccess() {
        return isSuccess;
    }
    public void setSuccess(boolean success) {
        isSuccess = success;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
