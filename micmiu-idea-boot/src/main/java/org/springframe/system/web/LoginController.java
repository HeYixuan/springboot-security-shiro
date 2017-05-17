package org.springframe.system.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: HeYixuan
 * @create: 2017-05-12 12:25
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping({"/","index"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, RedirectAttributes redirect) throws Exception {
        String username = WebUtils.getCleanParam(request, "username");
        String password = WebUtils.getCleanParam(request, "password");
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject currentUser = SecurityUtils.getSubject();
        // logger.info("为了验证登录用户而封装的token为" +
        // ReflectionToStringBuilder.toString(token,
        // ToStringStyle.MULTI_LINE_STYLE));
        try {
            logger.info("对用户[" + username + "]进行登录验证..验证开始");
            currentUser.login(token);
            // 验证是否登录成功
			/*
			 * if (currentUser.isAuthenticated()) { logger.info("对用户[" +
			 * username + "]进行登录验证..验证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)"); return
			 * "redirect:/"; } else { token.clear();
			 * redirect.addFlashAttribute("msg", "wpcap"); return
			 * "redirect:/login"; }
			 */
        } catch (UnknownAccountException uae) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
            redirect.addFlashAttribute("msg", "未知账户");
            return "redirect:/login";
            // map.put("msg", "未知账户");
        } catch (ExpiredCredentialsException ece) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,帐号已过期");
            redirect.addFlashAttribute("msg", "帐号已过期");
            return "redirect:/login";
            // map.put("msg", "账号已过期");
        } catch (IncorrectCredentialsException ice) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
            redirect.addFlashAttribute("msg", "密码错误");
            return "redirect:/login";
            // map.put("msg", "密码错误");
        } catch (UnauthorizedException ue) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,没有相应的授权");
            redirect.addFlashAttribute("msg", "没有相应的授权");
            return "redirect:/login";
            // map.put("msg", "没有相应的授权");
        } catch (LockedAccountException lae) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
            redirect.addFlashAttribute("msg", "账户已锁定");
            return "redirect:/login";
            // map.put("msg", "账户已锁定");
        } catch (DisabledAccountException dae) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,帐号已被禁用");
            redirect.addFlashAttribute("msg", "帐号已禁用");
            return "redirect:/login";
            // map.put("msg", "账户被禁用");
        } catch (ExcessiveAttemptsException eae) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
            redirect.addFlashAttribute("msg", "密码输入次数过多");
            return "redirect:/login";
            // map.put("msg", "错误次数过多");
        } catch (AuthenticationException ae) {
            // 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下", ae);
            redirect.addFlashAttribute("msg", "系统错误,请联系管理员");
            ae.printStackTrace();
            return "redirect:/login";
            // map.put("msg", "用户名或密码不正确");
        } /*
			 * catch (AuthenticationException e) { e.printStackTrace();
			 * rediect.addFlashAttribute("errorText", "您的账号或密码输入错误!"); return
			 * "redirect:/login"; }
			 */
        return "redirect:/";
    }




    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes ){
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("msg", "您已安全退出");
        return "redirect:/login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String unauthorizedUrl() {
        return "403";
    }

    @RequestMapping(value = "/extra_lock1", method = RequestMethod.GET)
    public String extra_lock1(){
        return "extra_lock1";
    }

    @RequestMapping(value = "/extra_lock2", method = RequestMethod.GET)
    public String extra_lock2(){
        return "extra_lock2";
    }
}
