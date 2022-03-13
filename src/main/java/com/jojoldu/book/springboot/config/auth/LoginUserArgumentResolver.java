package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver
{
    private final HttpSession httpSession;

    // MD) 컨트롤러 메서드 파라미터 지원 여부 판단
    @Override
    public boolean supportsParameter(MethodParameter parameter)
    {
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());

        // mk) 파라미터 == '@loginUser' && 파라미터 타입 == SessionUser.class
        return isLoginUserAnnotation && isUserClass;
    }

    // MD) 파라미터로 전달할 객체 생성
    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory)
            throws Exception
    {
        //mk) 세션에서 객체 가져오기
        return httpSession.getAttribute("user");
    }
}
