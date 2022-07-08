package kr.toyauction.domain.member.dto;

import kr.toyauction.domain.member.entity.Member;
import kr.toyauction.domain.member.enums.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class GoogleRequest {
    private final Map<String, Object> attributes;
    private final String nameAttributeKey;
    private final String name;
    private final String email;
    private final String picture;

    @Builder
    public GoogleRequest(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture){
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static GoogleRequest of(String registrationId, String userNameAttributeName, Map<String, Object> attributes){
        return ofGoole(userNameAttributeName, attributes);
    }

    private static GoogleRequest ofGoole(String userNameAttributeName, Map<String, Object> attributes){
        return GoogleRequest.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public Map<String, Object> convertToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", nameAttributeKey);
        map.put("key", nameAttributeKey);
        map.put("name", name);
        map.put("email", email);
        map.put("picture", picture);

        return map;
    }
}
