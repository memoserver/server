package com.memo.server;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;

import java.io.*;
import java.net.URL;
import java.util.Date;


public class HelloOSS {
    public static String bucketName = "memorandum";
    private static String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
    private static String accessKeyId = "LTAIJPaivcoBCU9v";
    private static String accessKeySecret = "umP1Ao6jMPVjriz2NtBbyE7fSQAT9k";
    OSSClient ossClient;

    public void openOss() {
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    public void clossOss() {
        ossClient.shutdown();
    }

    public void deleteObject(String key) {
        ossClient.deleteObject(bucketName, key);
    }

    //上传
    public void uploadImageFile(File image, String Path) {
        ossClient.putObject(bucketName, Path, image);
        System.out.println("Object：" + Path + "存入OSS成功。");
    }

    //URL
    public String getUrl(String key) {
        // 设置URL过期时间为10年 3600l* 1000*24*365*10

        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }

    //只使用文本
    public StringBuilder downloadImage(String key) throws IOException {
        OSSObject ossObject = ossClient.getObject(bucketName, key);
        InputStream inputStream = ossObject.getObjectContent();
        StringBuilder objectContent = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            objectContent.append(line);
        }
        inputStream.close();
        System.out.println("Object：" + key + "的内容是：" + objectContent);
        return objectContent;
    }
}
