package io.springmvc.springmvcmaster.model;

import io.springmvc.springmvcmaster.controller.ItemController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
@ExtendWith(RestDocumentationExtension.class)
public class ItemControllerTest {
      @Autowired
      private WebApplicationContext webApplicationContext;
      private MockMvc mockMvc;

      @BeforeEach
      void setUp(RestDocumentationContextProvider restDocumentationContextProvider) {
            this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                        .apply(documentationConfiguration(restDocumentationContextProvider)) // REST Docs 구성 추가
                        .alwaysDo(print()) // 콘솔에 요청/응답 출력
                        .build();

      }


      @Test
      void submit_form_should_return_model() throws Exception {
            mockMvc.perform(RestDocumentationRequestBuilders.post("/item")
                                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .param("price", "500000")
                                    .param("discount", "5000"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.item.price").value("500000"))
                        .andExpect(jsonPath("$.item.discount").value("5000"))
                        .andDo(print())
                        .andDo(MockMvcRestDocumentation.document("item-model")); // 명시적으로 문서화
      }


}
