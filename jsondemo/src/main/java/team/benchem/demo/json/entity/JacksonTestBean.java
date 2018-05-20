package team.benchem.demo.json.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class JacksonTestBean {

    private  String rowId;

    private String strProperty1;

    private String strProperty2;

    private String strProperty3;

    private Date dateProperty1;

    private Date dateProperty2;

    private Boolean isValue1;

    private Boolean isValue2;

    public JacksonTestBean() {
        rowId = UUID.randomUUID().toString();

        Calendar calendar = Calendar.getInstance();
        dateProperty1 = dateProperty2 = calendar.getTime();
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getStrProperty1() {
        return strProperty1;
    }

    public void setStrProperty1(String strProperty1) {
        this.strProperty1 = strProperty1;
    }

    public String getStrProperty2() {
        return strProperty2;
    }

    public void setStrProperty2(String strProperty2) {
        this.strProperty2 = strProperty2;
    }

    @JsonIgnore  //strProperty3 在做JSON序列化时会跳过
    public String getStrProperty3() {
        return strProperty3;
    }

    public void setStrProperty3(String strProperty3) {
        this.strProperty3 = strProperty3;
    }

    //默认序列化Date会变成 unit_time
    public Date getDateProperty1() {
        return dateProperty1;
    }

    public void setDateProperty1(Date dateProperty1) {
        this.dateProperty1 = dateProperty1;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getDateProperty2() {
        return dateProperty2;
    }

    public void setDateProperty2(Date dateProperty2) {
        this.dateProperty2 = dateProperty2;
    }

    //默认序列化字段会变成 value1
    public Boolean getValue1() {
        return isValue1;
    }

    public void setValue1(Boolean value1) {
        isValue1 = value1;
    }

    @JsonProperty("isValue2") //调整序列化名称
    public Boolean getValue2() {
        return isValue2;
    }

    public void setValue2(Boolean value2) {
        isValue2 = value2;
    }
}
