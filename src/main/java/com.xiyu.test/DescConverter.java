package com.xiyu.test;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

public class DescConverter implements Converter<Desc> {
    public Class supportJavaTypeKey() {
        return Desc.class;
    }

    public CellDataTypeEnum supportExcelTypeKey() {
        return null;
    }

    public Desc convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }

    public CellData convertToExcelData(Desc desc, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData(desc.toString());
    }
}
