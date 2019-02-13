package com.imalvisc.api.auth.utils;

import com.imalvisc.api.auth.core.auth.AuthToken;
import com.imalvisc.api.auth.model.vo.AuthTokenVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {

    public static AuthTokenVO login(AuthToken authToken) {
        Subject subject = currSubject();
        subject.login(authToken);
        return null;
    }

    public static Subject currSubject() {
        return SecurityUtils.getSubject();
    }

}
