package fr.utbm.gl52.utils;
import fr.utbm.gl52.entity.ResultEntity;


public class BaseResultUtil {



        /**return successful object
         * @param data
         * @return
         */
        public static ResultEntity resSuccess(String message,Object data){
            ResultEntity result = new ResultEntity();
            result.setMessage(message);
            result.setSuccess(true);
            result.setData(data);
            return result;
        }

    /**
         * return failed object
         * @param data
         * @return
         */
        public static ResultEntity resFailed(String message,Object data){
            ResultEntity result = new ResultEntity();
            result.setMessage(message);
            result.setSuccess(false);
            result.setData(data);
            return result;
        }

        /**
         * 304 error
         * @param data
         * @return
         */
        public static ResultEntity resNetError(String message,Object data){
            ResultEntity result = new ResultEntity();
           // result.setStatus(304);
            result.setMessage(message);
            result.setSuccess(false);
            result.setData(data);
            return result;
        }



}
