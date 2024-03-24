package com.example.demo;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.dto.RecordObject;
import com.example.demo.enums.StdResConstants;
import com.example.demo.models.TestTableRepoImpl;
import com.google.gson.Gson;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
	@Autowired
	private TestTableRepoImpl testTableRepoImpl;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	RecordObject mockRequest = new RecordObject();

	@BeforeEach
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		testTableRepoImpl.createWithoutExist();
	}

	@Test
	void healthTest() throws Exception {

		mockMvc
				.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void testInsert() throws Exception {
		Gson gson = new Gson();
		String json = gson.toJson(mockRequest
				.setStatus("testingData")
				.setMessage("testingData"));
		mockMvc.perform(post("/insert")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isOk());
	}

}
