package until;


import sun.misc.BASE64Encoder;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Base64Convert {

    public static String GetImageStr(String path)
    {
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        //待处理的图片
        String imgFile = path;
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try
        {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        //返回Base64编码过的字节数组字符串
        return encoder.encode(data);
    }

    public static void main(String[] srgs){
        String str = GetImageStr("D:\\JSP新\\orderSystem\\web\\image\\mn.jpg");
        System.out.println(str);

    }
}


