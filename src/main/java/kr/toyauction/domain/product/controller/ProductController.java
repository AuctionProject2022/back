package kr.toyauction.domain.product.controller;

import kr.toyauction.domain.product.property.ProductPath;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

    @GetMapping(ProductPath.PRODUCTS + "/{productId}")
    public String getProduct(@PathVariable final Long productId) {

        String result = "{\n" +
                "  \"success\": \"true\",\n" +
                "  \"data\": {\n" +
                "    \"productId\": 1,\n" +
                "    \"images\": [\n" +
                "      {\n" +
                "        \"imageId\": 1,\n" +
                "        \"imageUrl\": \"https://example.com/IMG00001.png\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"imageId\": 2,\n" +
                "        \"imageUrl\": \"https://example.com/IMG00002.png\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"thumbnailImage\": {\n" +
                "      \"imageId\": 2,\n" +
                "      \"imageUrl\": \"https://example.com/IMG00002.png\"\n" +
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

    @DeleteMapping(ProductPath.PRODUCTS + "/{productId}")
    public String deleteProduct(@PathVariable final Long productId) {
        String result = "{\n" +
                "  \"success\": \"true\"\n" +
                "}";

        return result;
    }

    @PostMapping(ProductPath.PRODUCTS)
    public String postProduct() {
        String result = "{\n" +
                        "  \"success\": \"true\",\n" +
                        "  \"data\": {\n" +
                        "    \"productId\": 1,\n" +
                        "    \"createDatetime\": \"2022-06-19 21:48:55\",\n" +
                        "    \"updateDatetime\": \"2022-06-19 21:48:55\",\n" +
                        "    \"enabled\": \"true\"\n" +
                        "  }\n" +
                        "}";

        return result;
    }

    @PostMapping(ProductPath.PRODUCTS + "/bids")
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

    @GetMapping(ProductPath.PRODUCTS + "/autocomplete")
    public String getAutoComplete(@RequestParam String prductName){
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