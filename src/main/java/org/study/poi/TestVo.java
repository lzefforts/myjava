package org.study.poi;

import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

import java.io.Serializable;

/**
 *  导出vo
 * @author ArnoldLee
 * @date 2019/5/4
 */
@Data
@ExcelTarget("testVo")
public class TestVo implements Serializable {
    private static final long serialVersionUID = -4644464602538788600L;

    @Excel(name="主键", orderNum = "0")
    private Long id;

    @Excel(name="姓名", orderNum = "1")
    private String name;

    @Excel(name="年龄", orderNum = "2")
    private Integer age;

    @Excel(name="地址", orderNum = "3")
    private String address;



}
