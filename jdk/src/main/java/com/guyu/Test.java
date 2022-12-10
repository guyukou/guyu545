package com.guyu;

import lombok.Data;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.*;

public class Test {
    @Data
    private static class ImMsgCardDto {
        private String bizId = "kaohexiaoxitixing";
        private List<String> uids = Arrays.asList("123","456","3123");
        private String senderId = "120";
        private String type = "text";
        private Integer msgType = 3;
        private String extra = "";
        private String cardInfo = "{\"msg\":\"asdf\"}";
        private Long timestamp = System.currentTimeMillis();
        private String bizKey;

    }
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            objects.add(0, 1);
        }
        System.out.println(objects);
    }
    public static String formatOneAndW(Double d) {
        if (d == null) {
            return null;
        }
        if (d < 1.0) {
            return convertDecimal(Math.round(d * 10) / 10., 1);
        }
        if (d > 99999) {
            return convertDecimal(Math.round(d / 100) / 100.0, 2)+ "w";
        }
        return String.valueOf(Math.round(d));
    }
    public static String formatRate(Double d) {
        if (d == null) {
            return "";
        }
        int exact = Math.toIntExact(Math.round(d * 100));
        return String.valueOf(exact);
    }
    public static String convertDecimal(Double num, int len) {
        if (num == null) {
            return "0";
        }
        double result = Double.parseDouble(String.format("%." + len + "f", num));
        double tmp = Math.abs(result);
        if (tmp > (long) tmp) {
            // 有小数保留小数
            return String.valueOf(result);
        }
        // 没有小数
        return String.valueOf((long)result);
    }
    public String calSign(ImMsgCardDto msgCardDto) {
        String sep1 = "=";
        String sep2 = "&";
        Map<String, String> signMap = new HashMap();
        signMap.put("bizId", msgCardDto.getBizId());
//        signMap.put("uids", StringUtils.join(msgCardDto.getUids(), ","));
        signMap.put("type", msgCardDto.getType());
        signMap.put("extra", msgCardDto.getExtra());
        signMap.put("cardInfo", msgCardDto.getCardInfo());
        List<String> signKeys = new ArrayList(signMap.keySet());
        Collections.sort(signKeys);
        String salt = "80658e3769fd16f4bd4e39c7d40f7e2e";

        StringBuilder calFields = new StringBuilder();
        Iterator var8 = signKeys.iterator();

        String md5;
        while(var8.hasNext()) {
            md5 = (String)var8.next();
            calFields.append(md5).append(sep1).append((String)signMap.get(md5)).append(sep2);
        }

        calFields.deleteCharAt(calFields.length() - 1);
        String origin = calFields.toString() + salt;
        md5 = getMD5(origin);
        System.out.format("origin: %s, md5: %s\n", origin, md5);
        return md5;
    }

    private String getMD5(String origin) {
        return DigestUtils.md5Hex(origin);
    }
}
