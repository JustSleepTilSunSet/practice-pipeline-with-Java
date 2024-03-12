package com.example.demo;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.dto.RecordObject;
import com.example.demo.enums.StdResConstants;
import com.example.demo.vo.StdResponse;
import com.google.gson.Gson;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@MockBean
	StdResponse dictMock;

	RecordObject mockRequest = new RecordObject();

	@BeforeEach
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void healthTest() throws Exception {
		when(dictMock.getSuccess("Health")).thenReturn(new StdResponse().getSuccess("Health"));

		mockMvc
				.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				// .andExpect(MockMvcResultMatchers.jsonPath("$.a").value(StdResConstants.API_SUCCESS));
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value(StdResConstants.API_SUCCESS));
	}

	@Test
	void testMethodShouldThrowException() throws Exception {
		// StdResponse dictMock = mock(StdResponse.class);
		// when(dictMock.getSuccess("Testing success")).thenReturn(new
		// StdResponse().setMessage("My fail"));
		// StdResponse result = dictMock.getSuccess("Testing success");
		// assertEquals("My fail", result.getMessage());

		when(dictMock.getSuccess("Health")).thenThrow(new Exception("Testing runtime error."));
		mockMvc
				.perform(get("/"))
				.andDo(print())
				.andExpect(status().isBadRequest());
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

	@AfterEach
	public void resetMocks() {
		reset(dictMock);
	}
}
