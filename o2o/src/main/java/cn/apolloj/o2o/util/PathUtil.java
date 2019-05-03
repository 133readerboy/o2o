package cn.apolloj.o2o.util;

/**
 * 提供根路径
 *
 * @author spark
 * @version 1.0
 * @date 2019/5/3 10:23
 **/
public class PathUtil {
    private static String separator = System.getProperty("file.separator");

    /**
     * 返回项目图片的根路径
     * 兼容Windows、Mac OS Linux Unix等系统
     * @return
     */
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        //防止图片在项目重启时被删除，此处可以选择上传到图片服务器
        if (os.toLowerCase().startsWith("win")) {
            basePath = "F:/projectdev/image/";
        }else {
            basePath = "/home/apolloj/image/";
        }
        basePath = basePath.replace("/",separator);
        return basePath;
    }

    /**
     * 根据不同的业务需求返回图片路径
     * @param shopId
     * @return
     */
    public static String getShopImagePath(Long shopId){
        String imgPath = "upload/item/shop"+shopId+"/";
        return imgPath.replace("/", separator);
    }
}
