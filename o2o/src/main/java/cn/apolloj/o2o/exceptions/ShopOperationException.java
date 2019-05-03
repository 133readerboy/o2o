package cn.apolloj.o2o.exceptions;

/**
 * shop操作业务异常类
 * @author spark
 * @version 1.0
 * @date 2019/5/3 14:03
 **/
public class ShopOperationException extends RuntimeException {

    private static final long serialVersionUID = 3208393089157501003L;

    public ShopOperationException(String message) {
        super(message);
    }
}

