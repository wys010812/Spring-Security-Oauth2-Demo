package cn.codepure.springsecurityoauth2demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder pwd;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 1. 从数据库查询账号是否存在 模拟查询
        if (!"admin".equals(s)) {
            throw new UsernameNotFoundException("账号不存在");
        }
        // 2. 根据用户取出数据库中密码 模拟查询
        String password = pwd.encode("123456");
        // 3. 返回一个User对象 包含用户名，从数据库中取到的密码（加密过后）权限列表
        return new User(s, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
