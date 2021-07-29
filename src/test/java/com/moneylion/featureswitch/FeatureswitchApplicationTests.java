package com.moneylion.featureswitch;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FeatureswitchApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void setup() {}
	
	@Test
	public void getCanAccessTest() throws Exception {
		mockMvc.perform(get("/feature").param("email", "maria@sample.com")
				.param("featureName", "Main"))
				.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void updateFeatureTest() throws Exception {
		
		String jSonRequest = "{\n" + "\"featureName\": \"Content\", \r\n" +
		"	\"email\": \"james@sample.com\", \r\n" +
		"	\"enable\": true" + "\n}";
		
		mockMvc.perform(post("/feature").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jSonRequest).accept(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print()).andExpect(status().isOk());
	}
	

}
