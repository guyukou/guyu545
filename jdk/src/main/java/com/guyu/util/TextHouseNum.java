package com.guyu.util;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Getter
@ToString
public class TextHouseNum {

    private final String building;
    private final String unit;
    private final String houseNo;
    private final String buildingUnit;
    private final String unitUnit;
    private final String houseNoUnit;

    public TextHouseNum(String building, String unit, String houseNo, String buildingUnit, String unitUnit, String houseNoUnit) {
        this.building = StringUtils.isBlank(building) ? "" : building;
        this.unit = StringUtils.isBlank(unit) ? "" : unit;
        this.houseNo = StringUtils.isBlank(houseNo) ? "" : houseNo;

        this.buildingUnit = StringUtils.isBlank(buildingUnit) ? "" : buildingUnit;
        this.unitUnit = StringUtils.isBlank(unitUnit) ? "" : unitUnit;
        this.houseNoUnit = StringUtils.isBlank(houseNoUnit) ? "" : houseNoUnit;
    }


    public String getHouseTextNo() {
        if (StringUtils.isBlank(building) && StringUtils.isBlank(unit) && StringUtils.isBlank(houseNo)) {
            return "";
        }
        return String.format("%s|%s_%s|%s_%s|%s", building, buildingUnit, unit, unitUnit,  houseNo, houseNoUnit);
    }
}
