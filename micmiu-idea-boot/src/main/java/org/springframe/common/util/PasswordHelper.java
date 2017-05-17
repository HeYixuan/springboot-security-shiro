package org.springframe.common.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframe.domain.SystemUser;

/**
 * Created by Administrator on 2016/12/22.
 */
public class PasswordHelper {

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private static String algorithmName = "md5";
    private static int hashIterations = 2;

    public static String salt(){
        return randomNumberGenerator.nextBytes().toHex();
    }

    public static String encryptPassword(String salt,String username,String password) {
        System.err.println("salt:"+ salt);
        String newPassword = new SimpleHash(
                algorithmName,
                password,
                ByteSource.Util.bytes(username + salt),
                hashIterations).toHex();
        return newPassword;
    }

/*
    public static void encryptPassword(SystemUser dto) {
        dto.setEmail(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName,
                dto.getPassword(),
                ByteSource.Util.bytes(dto.getCredentialsSalt()),
                hashIterations).toHex();
        dto.setPassword(newPassword);
    }
*/

    public static String encryptPassword(SystemUser systemUser){
        String newPassword = new SimpleHash(
                algorithmName,
                systemUser.getPassword(),
                ByteSource.Util.bytes(systemUser.getCredentialsSalt()),
                hashIterations).toHex();
        return newPassword;
    }

    public static void main(String [] args){
        SystemUser systemUser = new SystemUser();
        systemUser.setId(1);
        systemUser.setUsername("admin");
        systemUser.setPassword("admin");
        systemUser.setEmail("15517551511@126.com");

        String newPass = encryptPassword(systemUser);
        System.err.println("编号："+systemUser.getId());
        System.err.println("用户名："+systemUser.getUsername());
        System.err.println("邮箱："+ systemUser.getEmail());
        System.err.println("密码："+systemUser.getPassword());
        System.err.println("新密码："+newPass);

    }
}
