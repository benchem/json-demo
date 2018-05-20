package team.benchem.demo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import team.benchem.demo.json.entity.FastjsonTestBean;

import java.io.IOException;

public class FastjsonTest {

    static FastjsonTestBean testBean;

    @BeforeClass
    public static void beforeClass(){
        testBean = new FastjsonTestBean();
        testBean.setStrProperty1("1111111");
        testBean.setStrProperty2("2222222");
        testBean.setStrProperty3("3333333");
        testBean.setValue1(true);
        testBean.setValue2(true);
    }

    @Test
    public void test_ignore_case1() {

        String jsonStr = JSON.toJSONString(testBean);
        System.out.println(jsonStr);
        JSONObject jsonObj = JSONObject.parseObject(jsonStr);
        Assert.assertTrue("ignore field", !jsonObj.containsKey("strProperty3"));

    }

    @Test
    public void test_boolean_case1() {

        String jsonStr = JSON.toJSONString(testBean);
        System.out.println(jsonStr);
        JSONObject jsonObj = JSONObject.parseObject(jsonStr);
        Assert.assertTrue((Boolean) jsonObj.get("isValue2"));

    }

    @Test
    public void test_boolean_case2() {

        String jsonStr = JSON.toJSONString(testBean);
        System.out.println(jsonStr);
        FastjsonTestBean cloneBean = JSONObject.parseObject(jsonStr, FastjsonTestBean.class);
        Assert.assertTrue(cloneBean.getValue2());

    }

    @Test
    public void test_date_case1() {
        String jsonStr = JSON.toJSONString(testBean);
        System.out.println(jsonStr);
        FastjsonTestBean cloneBean = JSONObject.parseObject(jsonStr, FastjsonTestBean.class);
        Assert.assertTrue("unix time / date format",
        Math.abs(cloneBean.getDateProperty1().getTime() - cloneBean.getDateProperty2().getTime()) < 1000
        );
    }

}
