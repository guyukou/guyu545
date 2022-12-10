package com.garry.multidatasourcemybatisplus.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("supplier_log")
public class SupplierLogPO {
    private long id;
    private int callTimes;
}
