package cn.edu.seu.eye.web.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.http.Cookie;
import java.util.HashMap;

public class TestUtil {

    public static <T> T DeserializeObject(byte[] value, T t) {
        if (value == null) {
            return t;
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            HashMap<String, T> result = mapper.readValue(value,  new TypeReference<HashMap<String, T>>(){});
            t = result.get("data");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static byte[] postEntity(MockMvc mockMvc, Cookie mockCookie, Object entity, String uri) {
        try {
            String jsonStr = new ObjectMapper().writeValueAsString(entity);
            ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(uri, "json")
                    .characterEncoding("UTF-8")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonStr.getBytes()).cookie(mockCookie));
            MvcResult result = actions.andReturn();
            byte[] jsonByte = result.getResponse().getContentAsByteArray();
            return jsonByte;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
