package kr.toyauction.domain.bid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.toyauction.domain.bid.property.BidPath;;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BidController {
    @PostMapping(BidPath.BIDS)
    public String postProduct() {
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
}
