package com.example.springboot.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.util.IoUtils;
import lombok.Data;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author guyu06
 * @date 2022/9/2 2:10 下午
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

    @PostMapping("/importDicts2")
    @ResponseBody
    public void importDicts(MultipartFile file, HttpServletResponse response) throws IOException {
        System.out.println(file);
    }
    @GetMapping("/download")
    public void download(HttpServletResponse response, @NotNull @Valid Integer id) throws Exception {
        System.out.println("id: " + id);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), AssessReportDictExcelError.class).sheet().doWrite(new ArrayList<>());
    }

    @GetMapping("/downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("考核字段导入模板.xls");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + URLEncoder.encode("考核字段导入模板.xls"));
        response.getOutputStream().write(IoUtils.toByteArray(classPathResource.getInputStream()));
    }


    public static void main(String[] args) {
//        String fileName = "/Users/anjuke/Downloads/test.xlsx";
//        EasyExcel.write(fileName, DemoData.class)
//                .sheet("模板")
//                .includeColumnFieldNames(Collections.singleton("doubleData"))
//                .doWrite(() -> {
//                    // 分页查询数据
//                    return data();
//                });
    }

    private static List<DemoData> data() {
//        List<DemoData> list = ListUtils.newArrayList();
//        for (int i = 0; i < 10; i++) {
//            DemoData data = new DemoData();
//            data.setString("字符串" + i);
//            data.setDate(new Date());
//            data.setDoubleData(0.56);
//            list.add(data);
//        }
//        return list;
        return null;
    }
    @Data
    private static class AssessReportDictExcelError {
        @ColumnWidth(15)
        @ExcelProperty("端口(平台)")
        private String site;
        @ColumnWidth(15)
        @ExcelProperty("业务线")
        private String bizType;
        @ColumnWidth(20)
        @ExcelProperty("字段名称(中文)")
        private String name;
        @ColumnWidth(20)
        @ExcelProperty("字段属性(英文)，以_conf结尾")
        private String value;
        @ColumnWidth(50)
        @ExcelProperty("上级字段名")
        private String parentName;
    }

    @Data
    public static class DemoData {
        @ExcelProperty("字符串标题")
        private String string;
        @ExcelProperty("日期标题")
        private Date date;
        @ExcelProperty("数字标题")
        private Double doubleData;
        /**
         * 忽略这个字段
         */
        @ExcelIgnore
        private String ignore;
    }
}
