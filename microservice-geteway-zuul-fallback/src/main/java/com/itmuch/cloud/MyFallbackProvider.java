package com.itmuch.cloud;

import com.netflix.hystrix.exception.HystrixTimeoutException;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class MyFallbackProvider implements FallbackProvider {

    //表明是为哪个微服务提供回退， * 表示所有微服务提供回退
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        if (cause instanceof HystrixTimeoutException) {
            return response(HttpStatus.GATEWAY_TIMEOUT);
        } else {
            return this.fallbackResponse();
        }
    }


    private ClientHttpResponse response(final HttpStatus status)
    {
        return  new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return status;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return status.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return status.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("服务不可用，请稍后再试.".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers=new HttpHeaders();
                MediaType mediaType=new MediaType("application","json", Charset.forName("UTF-8"));
                headers.setContentType(mediaType);
                return  headers;
            }
        };
    }
}
