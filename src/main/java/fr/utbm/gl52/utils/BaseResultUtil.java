package fr.utbm.gl52.utils;
import fr.utbm.gl52.entity.ResultEntity;


public class BaseResultUtil {



        /**return successful object
         * @param data
         * @return
         */
        public static ResultEntity resSuccess(Object data){
            ResultEntity result = new ResultEntity();
            result.setStatus(10000);
            result.setSuccess(true);
            result.setData(data);
            return result;
        }

    /**
         * return failed object
         * @param data
         * @return
         */
        public static ResultEntity resFailed(Object data){
            ResultEntity result = new ResultEntity();
            result.setStatus(10001);
            result.setSuccess(false);
            result.setData(data);
            return result;
        }

        /**
         * 304 error
         * @param data
         * @return
         */
        public static ResultEntity resNetError(Object data){
            ResultEntity result = new ResultEntity();
            result.setStatus(304);
            result.setSuccess(false);
            result.setData(data);
            return result;
        }



}
