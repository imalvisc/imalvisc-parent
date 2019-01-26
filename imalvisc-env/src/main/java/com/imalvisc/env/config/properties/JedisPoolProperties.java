package com.imalvisc.env.config.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class JedisPoolProperties {

    private int maxActive;
    private int maxWait;
    private int maxIdle;
    private int minIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean testWhileIdle;

}
