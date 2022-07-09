package kr.toyauction.domain.product.controller;

import kr.toyauction.domain.product.property.ProductPath;
import kr.toyauction.global.property.TestProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith({RestDocumentationExtension.class})
class ProductControllerTest {

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.apply(
						documentationConfiguration(restDocumentation)
								.uris()
								.withScheme(TestProperty.SPRING_REST_DOCS_SERVER_SCHEME)
								.withHost(TestProperty.SPRING_REST_DOCS_SERVER_HOST)
								.withPort(TestProperty.SPRING_REST_DOCS_SERVER_PORT))
				.build();
	}

	@Test
	void getProduct() throws Exception {
		mockMvc.perform(get(ProductPath.PRODUCTS + "/5")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andDo(document("get-product",
						responseHeaders(
								headerWithName(HttpHeaders.CONTENT_TYPE).description("Content Type")
						),
						relaxedResponseFields(
								fieldWithPath("data.productId").description("상품 고유번호"),
								fieldWithPath("data.images[].fileId").description("상품 이미지 파일번호"),
								fieldWithPath("data.images[].fileType").description("상품 이미지 파일타입"),
								fieldWithPath("data.images[].url").description("상품 이미지 경로"),
								fieldWithPath("data.thumbnailImage.fileId").description("상품 썸네일 이미지 파일번호"),
								fieldWithPath("data.thumbnailImage.fileType").description("상품 썸네일 이미지 파일타입"),
								fieldWithPath("data.thumbnailImage.url").description("상품 썸네일 이미지 경로"),
								fieldWithPath("data.productName").description("상품 이름"),
								fieldWithPath("data.maxBidPrice").description("즉시 구매가"),
								fieldWithPath("data.minBidPrice").description("최초 입찰 시작가"),
								fieldWithPath("data.rightPrice").description("현재 입찰가"),
								fieldWithPath("data.startSaleDateTime").description("판매 시작 기간"),
								fieldWithPath("data.endSaleDateTime").description("판매 종료 기간"),
								fieldWithPath("data.unitPrice").description("입찰 단위"),
								fieldWithPath("data.purchaseTime.code").description("구매 시간 코드"),
								fieldWithPath("data.purchaseTime.name").description("구매 시간 내용"),
								fieldWithPath("data.deliveryOption.code").description("배송 옵션 코드"),
								fieldWithPath("data.deliveryOption.name").description("배송 옵션 내용"),
								fieldWithPath("data.isExchange.code").description("교환가능 코드"),
								fieldWithPath("data.isExchange.name").description("교환가능 내용"),
								fieldWithPath("data.productCondition").description("상품 상태"),
								fieldWithPath("data.detail").description("상품 내용"),
								fieldWithPath("data.bidCount").description("총 입찰 수"),
								fieldWithPath("data.bids[].bidId").description("입찰 번호"),
								fieldWithPath("data.bids[].bidSeq").description("입찰 순서"),
								fieldWithPath("data.bids[].bidPrice").description("입찰 금액"),
								fieldWithPath("data.bids[].bidDateTime").description("입찰 시간"),
								fieldWithPath("data.registerMemberId").description("등록자 회원번호"),
								fieldWithPath("data.productSttus.code").description("판매 상태 코드"),
								fieldWithPath("data.productSttus.name").description("판매 상태 이름"),
								fieldWithPath("data.createDatetime").description("등록일"),
								fieldWithPath("data.updateDatetime").description("수정일")
						)
				));
	}
}