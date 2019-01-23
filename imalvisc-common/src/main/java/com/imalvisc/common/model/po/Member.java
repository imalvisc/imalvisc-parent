package com.imalvisc.common.model.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Member {

    private String id;

    private String name;

    private String password;

}
