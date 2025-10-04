package com.ruoyi.utils;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.utils.http.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class SQApiClient {
    private static final Logger log = LoggerFactory.getLogger(SQApiClient.class);
    
    private static final String REVIEW_API_URL = "http://47.92.95.129:9898/api/v1/sq/ReviewProcess";
    private static final String BUSINESS_API_URL = "http://47.92.95.129:9898/api/v1/sq/SQbusiness";

    public SQResponse analyzeReview(String content) {
        try {
            // URL编码评论内容
            String encodedContent = URLEncoder.encode(content, StandardCharsets.UTF_8.toString());
            String url = REVIEW_API_URL + "?current_review=" + encodedContent;
            
            log.info("Calling review analysis API with URL: {}", url);
            
            // 设置请求头
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Accept", "application/json");
            
            // 发送请求
            String response = HttpUtils.sendGetWithHeaders(url, headers);
            
            if (response == null || response.trim().isEmpty()) {
                log.error("Empty response from review analysis API");
                return createErrorResponse("Empty response from API");
            }
            
            log.info("Received response from API: {}", response);
            return JSON.parseObject(response, SQResponse.class);
        } catch (Exception e) {
            log.error("调用评论分析API失败: {}", e.getMessage(), e);
            return createErrorResponse("API调用失败: " + e.getMessage());
        }
    }

    public SQResponse getServiceQuality(Long servicerId) {
        try {
            String url = BUSINESS_API_URL + "?servicer_id=" + servicerId;
            log.info("开始调用服务主体评分API - URL: {}", url);
            
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Accept", "application/json");
            
            // 记录请求信息
            log.info("请求头: {}", headers);
            
            String response = HttpUtils.sendGetWithHeaders(url, headers);
            log.info("API原始响应: {}", response);
            
            if (response == null || response.trim().isEmpty()) {
                log.error("API返回空响应 - servicer_id: {}", servicerId);
                return createErrorResponse("Empty response from API");
            }
            
            SQResponse sqResponse = JSON.parseObject(response, SQResponse.class);
            log.info("解析后的响应: code={}, msg={}, data={}", 
                    sqResponse.getCode(), 
                    sqResponse.getMsg(), 
                    sqResponse.getData());
            
            return sqResponse;
        } catch (Exception e) {
            log.error("API调用异常 - servicer_id: {}, error: {}", servicerId, e.getMessage(), e);
            return createErrorResponse("API调用失败: " + e.getMessage());
        }
    }

    private SQResponse createErrorResponse(String message) {
        SQResponse response = new SQResponse();
        response.setCode(500);
        response.setMsg(message);
        return response;
    }
}