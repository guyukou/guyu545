package com.example.springboot;

import com.example.springboot.util.ObjectMapperUtils;
import lombok.Data;

@Data
public class TopCenterCommonConfig {
    /**
     * 置顶福利中心整体区域标题："置顶福利中心"
     */
    private String title;
    /**
     * 投放建议区域标题："投放建议"
     */
    private String suggestionTitle;
    /**
     * 促销活动区域标题："促销活动"
     */
    private String activityTitle;
    /**
     * 最终展示文案模板
     */
    private String textTemplate;

    public static void main(String[] args){
        TopCenterCommonConfig config = new TopCenterCommonConfig();
        config.title = "置顶福利中心";
        config.suggestionTitle = "投放建议";
        config.activityTitle = "促销活动";
        config.textTemplate = "【<title>】<text><jumpHint>";
        System.out.println(ObjectMapperUtils.toJSON(config));
    }
}
