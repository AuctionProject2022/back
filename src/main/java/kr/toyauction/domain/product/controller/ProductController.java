package kr.toyauction.domain.product.controller;

import kr.toyauction.domain.product.dto.ProductGetRequest;
import kr.toyauction.domain.product.dto.ProductPostRequest;
import kr.toyauction.domain.product.dto.ProductPostResponse;
import kr.toyauction.domain.product.entity.ListType;
import kr.toyauction.domain.product.entity.Product;
import kr.toyauction.domain.product.service.ProductService;
import kr.toyauction.global.dto.SuccessResponse;
import kr.toyauction.global.dto.SuccessResponseHelper;
import kr.toyauction.global.property.Url;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping(Url.PRODUCT)
	public String getProducts(@RequestParam("listType") ListType listType, final Pageable pageable, final ProductGetRequest request){
		String result = "{\n" +
				"  \"success\": \"true\",\n" +
				"  \"data\": {\n" +
				"    \"content\": [\n" +
				"      {\n" +
				"        \"productId\": 1,\n" +
				"        \"thumbnailImage\": {\n" +
				"          \"imageId\": 2,\n" +
				"          \"imageUrl\": \"https://example.com/IMG00002.png\"\n" +
				"        },\n" +
				"        \"productName\": \"Nike Air Zoom Iorem lorem lorem Pegasus 36 Miami\",\n" +
				"        \"maxBidPrice\": 40000,\n" +
				"        \"minBidPrice\": 10000,\n" +
				"        \"rightPrice\": 38000,\n" +
				"        \"startSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
				"        \"endSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
				"        \"unitPrice\": 1000,\n" +
				"        \"purchaseTime\": {\n" +
				"          \"code\": \"PT_01\",\n" +
				"          \"name\": \"6개월 이내\"\n" +
				"        },\n" +
				"        \"deliveryOption\": {\n" +
				"          \"code\": \"DO_01\",\n" +
				"          \"name\": \"직거래\"\n" +
				"        },\n" +
				"        \"isExchange\": {\n" +
				"          \"code\": \"EC_01\",\n" +
				"          \"name\": \"교환 불가\"\n" +
				"        },\n" +
				"        \"productCondition\": \"new\",\n" +
				"        \"detail\": \"The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience.\",\n" +
				"        \"bidCount\": 3,\n" +
				"        \"registerMemberId\": 1,\n" +
				"        \"productSttus\": {\n" +
				"          \"code\": \"ST_01\",\n" +
				"          \"name\": \"경매완료\"\n" +
				"        },\n" +
				"        \"createDatetime\": \"2022-06-19 21:48:55\",\n" +
				"        \"updateDatetime\": \"2022-06-19 21:48:55\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"productId\": 2,\n" +
				"        \"thumbnailImage\": {\n" +
				"          \"imageId\": 3,\n" +
				"          \"imageUrl\": \"https://example.com/IMG00003.png\"\n" +
				"        },\n" +
				"        \"productName\": \"아디다스 Air Zoom Iorem lorem lorem Pegasus 36 Miami\",\n" +
				"        \"maxBidPrice\": 50000,\n" +
				"        \"minBidPrice\": 10000,\n" +
				"        \"rightPrice\": 38000,\n" +
				"        \"startSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
				"        \"endSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
				"        \"unitPrice\": 1000,\n" +
				"        \"purchaseTime\": {\n" +
				"          \"code\": \"PT_01\",\n" +
				"          \"name\": \"6개월 이내\"\n" +
				"        },\n" +
				"        \"deliveryOption\": {\n" +
				"          \"code\": \"DO_01\",\n" +
				"          \"name\": \"직거래\"\n" +
				"        },\n" +
				"        \"isExchange\": {\n" +
				"          \"code\": \"EC_01\",\n" +
				"          \"name\": \"교환 불가\"\n" +
				"        },\n" +
				"        \"productCondition\": \"new\",\n" +
				"        \"detail\": \"The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience.\",\n" +
				"        \"bidCount\": 3,\n" +
				"        \"registerMemberId\": 2,\n" +
				"        \"productSttus\": {\n" +
				"          \"code\": \"ST_01\",\n" +
				"          \"name\": \"판매종료\"\n" +
				"        },\n" +
				"        \"createDatetime\": \"2022-06-19 21:48:55\",\n" +
				"        \"updateDatetime\": \"2022-06-19 21:48:55\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"productId\": 3,\n" +
				"        \"thumbnailImage\": {\n" +
				"          \"imageId\": 4,\n" +
				"          \"imageUrl\": \"https://example.com/IMG00004.png\"\n" +
				"        },\n" +
				"        \"productName\": \"이케아 램프\",\n" +
				"        \"maxBidPrice\": 70000,\n" +
				"        \"minBidPrice\": 10000,\n" +
				"        \"rightPrice\": 38000,\n" +
				"        \"startSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
				"        \"endSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
				"        \"unitPrice\": 1000,\n" +
				"        \"purchaseTime\": {\n" +
				"          \"code\": \"PT_01\",\n" +
				"          \"name\": \"6개월 이내\"\n" +
				"        },\n" +
				"        \"deliveryOption\": {\n" +
				"          \"code\": \"DO_01\",\n" +
				"          \"name\": \"직거래\"\n" +
				"        },\n" +
				"        \"isExchange\": {\n" +
				"          \"code\": \"EC_01\",\n" +
				"          \"name\": \"교환 불가\"\n" +
				"        },\n" +
				"        \"productCondition\": \"new\",\n" +
				"        \"detail\": \"The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience.\",\n" +
				"        \"bidCount\": 10,\n" +
				"        \"registerMemberId\": 2,\n" +
				"        \"productSttus\": {\n" +
				"          \"code\": \"ST_01\",\n" +
				"          \"name\": \"판매중\"\n" +
				"        },\n" +
				"        \"createDatetime\": \"2022-06-19 21:48:55\",\n" +
				"        \"updateDatetime\": \"2022-06-19 21:48:55\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"productId\": 4,\n" +
				"        \"thumbnailImage\": {\n" +
				"          \"imageId\": 5,\n" +
				"          \"imageUrl\": \"https://example.com/IMG00005.png\"\n" +
				"        },\n" +
				"        \"productName\": \"포켓몬 스티커\",\n" +
				"        \"maxBidPrice\": 2000,\n" +
				"        \"minBidPrice\": 1000,\n" +
				"        \"rightPrice\": 38000,\n" +
				"        \"startSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
				"        \"endSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
				"        \"unitPrice\": 1000,\n" +
				"        \"purchaseTime\": {\n" +
				"          \"code\": \"PT_01\",\n" +
				"          \"name\": \"6개월 이내\"\n" +
				"        },\n" +
				"        \"deliveryOption\": {\n" +
				"          \"code\": \"DO_01\",\n" +
				"          \"name\": \"직거래\"\n" +
				"        },\n" +
				"        \"isExchange\": {\n" +
				"          \"code\": \"EC_01\",\n" +
				"          \"name\": \"교환 불가\"\n" +
				"        },\n" +
				"        \"productCondition\": \"new\",\n" +
				"        \"detail\": \"The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience.\",\n" +
				"        \"bidCount\": 10,\n" +
				"        \"registerMemberId\": 4,\n" +
				"        \"productSttus\": {\n" +
				"          \"code\": \"ST_01\",\n" +
				"          \"name\": \"판매중\"\n" +
				"        },\n" +
				"        \"createDatetime\": \"2022-06-19 21:48:55\",\n" +
				"        \"updateDatetime\": \"2022-06-19 21:48:55\"\n" +
				"      }\n" +
				"    ],\n" +
				"    \"pageable\": {\n" +
				"      \"sort\": {\n" +
				"        \"sorted\": false,\n" +
				"        \"unsorted\": true,\n" +
				"        \"empty\": true\n" +
				"      },\n" +
				"      \"pageSize\": 6,\n" +
				"      \"pageNumber\": 2,\n" +
				"      \"offset\": 11,\n" +
				"      \"paged\": false,\n" +
				"      \"unpaged\": false\n" +
				"    },\n" +
				"    \"number\": 2,\n" +
				"    \"sort\": {\n" +
				"      \"sorted\": false,\n" +
				"      \"unsorted\": true,\n" +
				"      \"empty\": true\n" +
				"    },\n" +
				"    \"first\": false,\n" +
				"    \"last\": false,\n" +
				"    \"numberOfElements\": 5,\n" +
				"    \"size\": 15,\n" +
				"    \"empty\": false\n" +
				"  }\n" +
				"}";

		return result;
	}

	@GetMapping(value = Url.PRODUCT + "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getProduct(@PathVariable final Long productId) {

		String result = "{\n" +
				"  \"success\": \"true\",\n" +
				"  \"data\": {\n" +
				"    \"productId\": 1,\n" +
				"    \"images\": [\n" +
				"      {\n" +
				"        \"fileId\": 1,\n" +
				"        \"fileType\": \"PRODUCT_IMAGE\",\n" +
				"        \"url\": \"https://example.com/IMG00001.png\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"fileId\": 2,\n" +
				"        \"fileType\": \"PRODUCT_IMAGE\",\n" +
				"        \"url\": \"https://example.com/IMG00002.png\"\n" +
				"      }\n" +
				"    ],\n" +
				"    \"thumbnailImage\": {\n" +
				"      \"fileId\": 2,\n" +
				"      \"fileType\": \"PRODUCT_IMAGE\",\n" +
				"      \"url\": \"https://example.com/IMG00002.png\"\n" +
				"    },\n" +
				"    \"productName\": \"Nike Air Zoom Iorem lorem lorem Pegasus 36 Miami\",\n" +
				"    \"maxBidPrice\": 40000,\n" +
				"    \"minBidPrice\": 10000,\n" +
				"    \"rightPrice\": 38000,\n" +
				"    \"startSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
				"    \"endSaleDateTime\": \"2022-06-19 21:48:55\",\n" +
				"    \"unitPrice\": 1000,\n" +
				"    \"purchaseTime\": {\n" +
				"      \"code\": \"PT_01\",\n" +
				"      \"name\": \"6개월 이내\"\n" +
				"    },\n" +
				"    \"deliveryOption\": {\n" +
				"      \"code\": \"DO_01\",\n" +
				"      \"name\": \"직거래\"\n" +
				"    },\n" +
				"    \"isExchange\": {\n" +
				"      \"code\": \"EC_01\",\n" +
				"      \"name\": \"교환 불가\"\n" +
				"    },\n" +
				"    \"productCondition\": \"new\",\n" +
				"    \"detail\": \"The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience. The nike Air max 270 React ENG combines a full-lengh React foam midsole with a 270 Max air unit for unrivaled comfor and striking visul experience.\",\n" +
				"    \"bidCount\": 3,\n" +
				"    \"bids\": [\n" +
				"      {\n" +
				"        \"bidId\": 1,\n" +
				"        \"bidSeq\": 1,\n" +
				"        \"bidPrice\": 30000,\n" +
				"        \"bidDateTime\": \"2022-06-19 21:48:55\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"bidId\": 2,\n" +
				"        \"bidSeq\": 2,\n" +
				"        \"bidPrice\": 10000,\n" +
				"        \"bidDateTime\": \"2022-06-19 21:48:55\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"bidId\": 3,\n" +
				"        \"bidSeq\": 3,\n" +
				"        \"bidPrice\": 40000,\n" +
				"        \"bidDateTime\": \"2022-06-19 21:48:55\"\n" +
				"      }\n" +
				"    ],\n" +
				"    \"registerMemberId\": 1,\n" +
				"    \"productSttus\": {\n" +
				"      \"code\": \"ST_01\",\n" +
				"      \"name\": \"판매중\"\n" +
				"    },\n" +
				"    \"createDatetime\": \"2022-06-19 21:48:55\",\n" +
				"    \"updateDatetime\": \"2022-06-19 21:48:55\"\n" +
				"  }\n" +
				"}";

		return result;
	}

	@DeleteMapping(value = Url.PRODUCT  + "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteProduct(@PathVariable final Long productId) {
		String result = "{\n" +
				"  \"success\": \"true\"\n" +
				"}";

		return result;
	}

	@PostMapping(value = Url.PRODUCT , produces = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponse<ProductPostResponse> postProduct(@Validated @RequestBody final ProductPostRequest request) {
		Product product = productService.registerProduct(request);
		return SuccessResponseHelper.success(new ProductPostResponse(product));
	}

	@PostMapping(value = Url.PRODUCT  + "/bids", produces = MediaType.APPLICATION_JSON_VALUE)
	public String postBid() {
		String result = "{\n" +
				"  \"success\": \"true\",\n" +
				"  \"data\": {\n" +
				"    \"bidId\": 1,\n" +
				"    \"createDatetime\": \"2022-06-19 21:48:55\",\n" +
				"    \"updateDatetime\": \"2022-06-19 21:48:55\"\n" +
				"  }\n" +
				"}";
		return result;
	}

	@GetMapping(value = Url.PRODUCT  + "/autocomplete", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAutoComplete(@RequestParam String prductName) {
		String result = "{\n" +
				"  \"success\": \"true\",\n" +
				"  \"data\": {\n" +
				"    \"size\": \"10\",\n" +
				"    \"content\": [\n" +
				"      {\n" +
				"        \"productId\": 1,\n" +
				"        \"productName\": \"Nike Air Zoom Iorem lorem lorem Pegasus 36 Miami\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"productId\": 2,\n" +
				"        \"productName\": \"Zoom Iorem Pegasus 75 Nike Air\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"productId\": 3,\n" +
				"        \"productName\": \"Zoom Nike Iorem Pegasus 75  Air\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"productId\": 4,\n" +
				"        \"productName\": \"Zoom Iorem Pegasus 75 Air Nike\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"productId\": 5,\n" +
				"        \"productName\": \"Zoom Iorem Pegasus 75  Air Nike Iorem Pegasus\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"productId\": 6,\n" +
				"        \"productName\": \"나이키 에어 Nike Air\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"productId\": 7,\n" +
				"        \"productName\": \"줌 나이키 Zoom Iorem Pegasus 75 Nike Air\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"productId\": 8,\n" +
				"        \"productName\": \"Zoom Iorem Pegasus 75 Nike Air 나이키\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"productId\": 9,\n" +
				"        \"productName\": \"Zoom 나이키 에어 Iorem Pegasus 75 Nike Air\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"productId\": 10,\n" +
				"        \"productName\": \"Nike 나이키 에어\"\n" +
				"      }\n" +
				"    ]\n" +
				"  }\n" +
				"}";

		return result;
	}
}