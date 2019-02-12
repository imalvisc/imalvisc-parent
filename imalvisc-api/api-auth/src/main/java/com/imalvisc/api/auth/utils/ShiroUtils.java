package com.imalvisc.api.auth.utils;

import com.imalvisc.api.auth.core.auth.Auth;
import com.imalvisc.api.auth.model.vo.AuthTokenVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {

    public static AuthTokenVO login(Auth auth) {
        Subject subject = currSubject();
        subject.login(auth);
        return null;
    }

    public static Subject currSubject() {
        return SecurityUtils.getSubject();
    }

}
