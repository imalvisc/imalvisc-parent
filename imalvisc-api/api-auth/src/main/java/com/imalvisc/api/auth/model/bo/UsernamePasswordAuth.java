package com.imalvisc.api.auth.model.bo;

import com.imalvisc.api.auth.core.auth.Auth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class UsernamePasswordAuth implements Auth {

    private String username;

    private String password;

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return password;
    }

}
