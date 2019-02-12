package com.imalvisc.api.auth.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class AuthTokenVO {

    //短token，用于访问API接口
    private String accessToken;

    //长token，用于刷新短token
    private String refreshToken;

}
