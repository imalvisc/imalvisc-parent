package com.imalvisc.common.model.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Member implements Serializable {

    private String id;

    private String name;

    private String password;

}
