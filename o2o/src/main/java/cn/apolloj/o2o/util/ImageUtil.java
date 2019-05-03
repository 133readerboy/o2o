package cn.apolloj.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 改变源图片大小
 * 添加水印
 * 压缩源图片
 * @author spark
 * @version 1.0
 * @date 2019/5/3 10:10
 **/
public class ImageUtil {
    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageUtil.class);

    private static String basePath = ImageUtil.class.getClass()
            .getResource("/")
            .getPath();

    private static final SimpleDateFormat S_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();

    /**
     * 将CommonsMultipartFile 装换成 File
     * @param cFile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile){
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IOException e) {
            LOGGER.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }
    /**
     * 处理缩略图，并返回目标图片(新生成)相对值路径
     * @param thumbnailInputStream
     * @param fileName
     * @param targetAddr
     * @return 新生成图片的相对值路径
     */
    public static String generateThumbnails(InputStream thumbnailInputStream, String fileName, String targetAddr){
        String realFileName = getRandomFileName();
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        LOGGER.debug("current relativeAddr is: "+ relativeAddr);
        LOGGER.debug("current basePath:"+ basePath);
        File destFile = new File(PathUtil.getImgBasePath()+relativeAddr);
        LOGGER.debug("current complete addr is : " + PathUtil.getImgBasePath()+relativeAddr);
        LOGGER.debug("水印图片的位置: "+basePath + "watermark.jpg");
        try {
            Thumbnails.of(thumbnailInputStream)
                    .size(200, 200)
                    .watermark(
                            Positions.BOTTOM_RIGHT,
                            ImageIO.read(
                                    new File(
                                            basePath+ "watermark.jpg")),
                                            0.25f)
                    .outputQuality(0.8f).
                    toFile(destFile);
        }catch (IOException e){
            LOGGER.info(e.toString());
            e.printStackTrace();
        }
        return relativeAddr;
    }


    /**
     * 创建目标路径所设计的目录，即
     * /home/work/aplloj/xxx.jpg
     * 那么/home/work/aplloj这三个目录都需要被创建出来
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath()+targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     * .jpg .png .gif等
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名(当前年月日分钟秒钟+五位随机数)
     * @return
     */
    public static String getRandomFileName() {
        //获取随机的五位数 10000 < ranNum < 99999
        int ranNum = r.nextInt(89999)+10000;
        String nowTimestr = S_DATE_FORMAT.format(new Date());
        return nowTimestr + ranNum;
    }

    public static void main(String[] args) throws IOException {

        Thumbnails.of(new File("E:/I love you.jpg"))
                .size(200, 200)
        .watermark(
                Positions.BOTTOM_RIGHT
                , ImageIO.read(new File(basePath +"/watermark.jpg"))
                , 0.25f)
        .outputQuality(0.8f)
        .toFile("E:/111.jpg");
    }

}
