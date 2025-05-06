package io.springmvc.springmvcmaster.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;



import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(RestDocumentationExtension.class) // REST Docs와 JUnit 5 통합

@WebMvcTest(KoreanFormatParseController.class)
@Import(ConversionController.class)
 class KoreanFormatParseControllerRestDocsTest {
      @Autowired
      private WebApplicationContext webApplicationContext;
      @Autowired
      private MockMvc mockMvc;
      @BeforeEach
      void setUp(RestDocumentationContextProvider restDocumentation) {
            this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                        .apply(documentationConfiguration(restDocumentation)) // REST Docs 설정 적용
                        .build();
      }

      @Test
      void format_currency_to_string() throws Exception {
            mockMvc.perform(RestDocumentationRequestBuilders.get("/format")
                                    .param("param", "1234567"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.convert").value("₩1,234,567")) // 예상값 수정
                        .andDo(document("currency-format")) // REST docs 활성화
                        .andDo(print());
      }

      @Test
      void parse_currency_string_to_number() throws Exception {
            mockMvc.perform(RestDocumentationRequestBuilders.get("/parse")
                                    .param("param", "₩1,234,567.00"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.convert").value("1234567")) // 예상값 그대로
                        .andDo(document("currency-parse"))
                        .andDo(print());
      }
}
