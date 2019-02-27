package top.choviwu.io.files.core.files;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public class JsonToExcel {

    @SuppressWarnings("unchecked")
    // 创建excel文件函数
    // src为待保存的文件路径,json为待保存的json数据
    public static JSONObject createExcel(String src, JSONObject json) {

        // 用来反馈函数调用结果
        JSONObject result = new JSONObject();
        try {
            // 新建文件
            File file = new File(src);
            file.createNewFile();

            // 创建工作薄
            OutputStream outputStream = new FileOutputStream(file);
            WritableWorkbook writableWorkbook = Workbook.createWorkbook(outputStream);
            // 创建新的一页
            WritableSheet sheet = writableWorkbook.createSheet("First sheet", 0);

            // 得到data对应的JSONArray
            JSONArray jsonArray = json.getJSONArray("data");
            Label label; // 单元格对象
            // 列数计数
            int column = 0;


            // 将第一行信息加到页中。如：姓名、年龄、性别
            JSONObject first = jsonArray.getJSONObject(0);
            Iterator<String> iterator = first.keys(); // 得到第一项的key集合
            while (iterator.hasNext()) { // 遍历key集合
                String key = (String) iterator.next(); // 得到key
                label = new Label(column++, 0, key); // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
                sheet.addCell(label); // 将单元格加到页
            }


            // 遍历jsonArray
            for (int i = 0; i < jsonArray.size(); i++) {
                // 得到数组的每项
                JSONObject item = jsonArray.getJSONObject(i);
                // 得到key集合
                iterator = item.keys();
                // 从第0列开始放
                column = 0;
                while (iterator.hasNext()) {
                    // 得到key
                    String key = iterator.next();
                    // 得到key对应的value
                    String value = item.getString(key);
                    // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
                    label = new Label(column++, (i + 1), value);
                    // 将单元格加到页
                    sheet.addCell(label);
                }
            }
            writableWorkbook.write(); // 加入到文件中
            writableWorkbook.close(); // 关闭文件，释放资源
        } catch (Exception e) {
            // 将调用该函数的结果返回
            result.put("msg", "fail");
            // 将调用该函数失败的原因返回
            result.put("data", e.getMessage());
            result.put("code",-1);
            return result;
        }


        result.put("msg", "success");
        return result;
    }

    public static void print(String data,File file){
        print(data, file.getPath());
    }

    public static void print(String data,String path){
        System.out.println(data);
        JSONObject jsonObject = JSONObject.fromObject(data);
        // 将函数调用的结果返回给result
        // 保存路径要改！！！！
        JSONObject result = createExcel(path, jsonObject);
        // 输出结果
        System.out.println(result);
    }
}
