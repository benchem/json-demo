package team.benchem.demo.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import team.benchem.demo.json.entity.JacksonTestBean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JacksonTest {

    static JacksonTestBean jacksonTestBean;

    @BeforeClass
    public static void beforeClass(){
        jacksonTestBean = new JacksonTestBean();
        jacksonTestBean.setStrProperty1("1111111");
        jacksonTestBean.setStrProperty2("2222222");
        jacksonTestBean.setStrProperty3("3333333");
        jacksonTestBean.setValue1(true);
        jacksonTestBean.setValue2(true);
    }

    @Test
    public void test_ignore_case1() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(jacksonTestBean);
        System.out.println(jsonStr);
        Map<String, Object> mapObj = objectMapper.readValue(jsonStr, HashMap.class);
        Assert.assertTrue("ignore field", !mapObj.containsKey("strProperty3"));

    }

    @Test
    public void test_boolean_case1() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(jacksonTestBean);
        System.out.println(jsonStr);
        Map<String, Object> mapObj = objectMapper.readValue(jsonStr, HashMap.class);

        Assert.assertTrue((Boolean) mapObj.get("isValue2"));
    }

    @Test
    public void test_boolean_case2() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(jacksonTestBean);
        System.out.println(jsonStr);
        JacksonTestBean cloneBean = objectMapper.readValue(jsonStr, JacksonTestBean.class);

        Assert.assertTrue(cloneBean.getValue2());
    }

    @Test
    public void test_date_case1() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(jacksonTestBean);
        System.out.println(jsonStr);
        JacksonTestBean cloneBean = objectMapper.readValue(jsonStr, JacksonTestBean.class);

        Assert.assertTrue("unix time / date format",
        Math.abs(cloneBean.getDateProperty1().getTime() - cloneBean.getDateProperty2().getTime()) < 1000
        );
    }

}
