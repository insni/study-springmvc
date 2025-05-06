package io.springmvc.springmvcmaster.model;

import io.springmvc.springmvcmaster.controller.MyController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MyController.class) // 테스트할 컨트롤러 지정
@ExtendWith(RestDocumentationExtension.class) // RestDocumentationExtension 추가
class MyControllerTest {

      @Autowired
      private WebApplicationContext context;

      private MockMvc mockMvc;

      @BeforeEach
      void setUp(RestDocumentationContextProvider restDocumentation) {
            // RestDocumentationContextProvider를 사용하여 MockMvc 초기화
            this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                        .apply(documentationConfiguration(restDocumentation)) // REST Docs 구성 추가
                        .alwaysDo(print()) // 콘솔에 요청/응답 출력
                        .build();
      }

      @Test
      void submit_form_should_return_model() throws Exception {
            mockMvc.perform(RestDocumentationRequestBuilders.post("/submit")
                                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .param("price", "1234567")
                                    .param("date", "2024-05-04"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.submitReq.price").value("1234567"))
                        .andExpect(jsonPath("$.submitReq.date").value("2024-05-04"))
                        .andDo(print())
                        .andDo(MockMvcRestDocumentation.document("submit-my-model")); // 명시적으로 문서화
      }
}