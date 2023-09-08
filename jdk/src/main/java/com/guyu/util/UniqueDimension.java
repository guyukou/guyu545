package com.guyu.util;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * 这里是对房号/公司ID维度的一个封装
 */
@Getter
@ToString
public class UniqueDimension {

    private final Long houseNumberId;
    private final Long companyId;
    private final Long communityId;
    private final Long houseTypeId;

    /**
     * 对于企业来源的可能是文本房号、并没有房号ID
     */
    private final TextHouseNum houseText;

    private final Boolean openRequireHouse;


    public UniqueDimension(Long houseNumberId, Long companyId, TextHouseNum houseText, Long communityId, Long houseTypeId) {
        this(houseNumberId, companyId, houseText, communityId, houseTypeId, null);
    }
    public UniqueDimension(Long houseNumberId, Long companyId, TextHouseNum houseText, Long communityId, Long houseTypeId, Boolean openRequireHouse) {
        this.houseNumberId = Optional.ofNullable(houseNumberId).orElse(0L);
        this.companyId = Optional.ofNullable(companyId).orElse(0L);
        this.communityId = Optional.ofNullable(communityId).orElse(0L);
        this.houseTypeId = Optional.ofNullable(houseTypeId).orElse(0L);
        this.houseText = Optional.ofNullable(houseText).orElse(new TextHouseNum("", "", "", "", "", ""));
        this.openRequireHouse = openRequireHouse;
    }


    /**
     * 返回基于当前房号/公司/文本房号得到唯一ID
     * 也就对应着原有的fingerPrintId、没有太大改变的话直接返回原有的fingerPrintId也可以
     *
     * @return
     */
    public String getUniqId() {
        FingerprintTypeEnum fingerprintType = getFingerprintType();
        switch (fingerprintType) {
            case HOUSE_ID:
                return getUniqHouseId();
            case HOUSE_TEXT:
                return getUniqHouseText();
            case HOUSE_TYPE:
                return getUniqHouseTypeId();
            case NONE:
                return "";
            default:
                throw new RuntimeException("未知的唯一性类型");
        }
    }


    public String getCompanyUniqId() {
        FingerprintTypeEnum fingerprintType = getFingerprintType();
        switch (fingerprintType) {
            case HOUSE_ID:
                return getCompanyUniqHouseId();
            case HOUSE_TEXT:
                return getCompanyUniqHouseText();
            case HOUSE_TYPE:
                return getCompanyUniqHouseTypeId();
            case NONE:
                return "";
            default:
                throw new RuntimeException("未知的唯一性类型");
        }
    }
    /**
     * 是否有文本房号、如果有房号ID的、即使你有文本房号也不认为你有
     * 我们认为必须、楼栋、单元、户室号、任一填了一个了都是填了、
     * 还必须有小区ID
     * 对于新房来说、填了户型ID就等于我们的房号ID
     *
     * @return
     */
    public boolean hasTextHouseNumber() {
        return ParamsCheckUtils.validString(houseText.getHouseTextNo())
                && ParamsCheckUtils.validIdLong(communityId);
    }

    /**
     * 获取唯一性类型
     *
     * @return
     */
    private FingerprintTypeEnum getFingerprintType() {
        if (ParamsCheckUtils.validIdLong(houseNumberId) && (openRequireHouse == null || openRequireHouse)) {
            return FingerprintTypeEnum.HOUSE_ID;
        }

        if (ParamsCheckUtils.validIdLong(houseTypeId) && ParamsCheckUtils.validIdLong(communityId)) {
            return FingerprintTypeEnum.HOUSE_TYPE;
        }

        if (ParamsCheckUtils.validString(houseText.getHouseTextNo()) && ParamsCheckUtils.validIdLong(communityId)) {
            return FingerprintTypeEnum.HOUSE_TEXT;
        }
        return FingerprintTypeEnum.NONE;
    }

    /**
     * 磐石房号类型
     *
     * @return
     */
    private String getUniqHouseId() {
        if (!ParamsCheckUtils.validIdLong(houseNumberId)) {
            return "";
        }
        return MD5Utils.MD5(String.format("%d_%d", FingerprintTypeEnum.HOUSE_ID.getValue(), houseNumberId));
    }

    /**
     * 文本类型
     * 这里需要根据楼栋户号文本从新
     * @return
     */
    private String getUniqHouseText() {
        if (StringUtils.isEmpty(houseText.getHouseTextNo())) {
            return "";
        }
        return MD5Utils.MD5(String.format("%d_%s", FingerprintTypeEnum.HOUSE_TEXT.getValue(), houseText.getHouseTextNo()));
    }

    /**
     * 磐石户型类型
     *
     * @return
     */
    private String getUniqHouseTypeId() {
        if (ParamsCheckUtils.validIdLong(houseTypeId) && ParamsCheckUtils.validIdLong(communityId)) {
            return MD5Utils.MD5(String.format("%d_%d_%d", FingerprintTypeEnum.HOUSE_TYPE.getValue(), houseTypeId, communityId));
        }
        return "";
    }

    /**
     * 磐石房号类型
     *
     * @return
     */
    private String getCompanyUniqHouseId() {
        if (!ParamsCheckUtils.validIdLong(houseNumberId)) {
            return "";
        }
        return MD5Utils.MD5(String.format("%d_%d_%d", companyId, FingerprintTypeEnum.HOUSE_ID.getValue(), houseNumberId));
    }

    /**
     * 文本类型
     * 这里需要根据楼栋户号文本从新
     * @return
     */
    private String getCompanyUniqHouseText() {
        if (StringUtils.isEmpty(houseText.getHouseTextNo())) {
            return "";
        }
        return MD5Utils.MD5(String.format("%d_%d_%s",  companyId, FingerprintTypeEnum.HOUSE_TEXT.getValue(), houseText.getHouseTextNo()));
    }


    public static void main(String[] args) {

        printFingerPrintId(new UniqueDimension(null, 65414L, new TextHouseNum("7", "2", "101", "1", "5", "1"), 102467568L, 0L));
        printFingerPrintId(new UniqueDimension(551347665L, 65414L, new TextHouseNum("7", "2", "101", "1", "5", "1"), 102467568L, 0L));
        printFingerPrintId(new UniqueDimension(6535492L, 2614L, new TextHouseNum("11", "2", "502", "1", "5", "1"), 104817890L, 0L));
        printFingerPrintId(new UniqueDimension(0L, 2614L, new TextHouseNum("11", "2", "502", "1", "5", "1"), 100459258L, 0L));
    }


    private static void printFingerPrintId(UniqueDimension uniqueDimension) {
        System.out.println(uniqueDimension.getUniqId());
    }
    /**
     * 磐石户型类型
     *
     * @return
     */
    private String getCompanyUniqHouseTypeId() {
        if (ParamsCheckUtils.validIdLong(houseTypeId) && ParamsCheckUtils.validIdLong(communityId)) {
            return MD5Utils.MD5(String.format("%d_%d_%d_%d", companyId, FingerprintTypeEnum.HOUSE_TYPE.getValue(), houseTypeId, communityId));
        }
        return "";
    }
}
