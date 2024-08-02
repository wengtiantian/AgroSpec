package com.ruoyi.framework.config;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.nio.charset.Charset;

/**
 * @BelongsProject: SocialService
 * @BelongsPackage: com.ruoyi.common.core.redis
 * @Author: wang
 * @CreateTime: 2024-06-11 16:08
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class RedisKeySerializer implements RedisSerializer<String>
{
    @Autowired
    private RuoYiConfig config;

    private final Charset charset;

    public RedisKeySerializer()
    {
        this(Charset.forName("UTF8"));
    }

    public RedisKeySerializer(Charset charset)
    {
        Assert.notNull(charset, "字符集不允许为NULL");
        this.charset = charset;
    }

    @Override
    public byte[] serialize(String string) throws SerializationException
    {
        // 通过项目名称ruoyi.name来定义Redis前缀，用于区分项目缓存
        if (StringUtils.isNotEmpty(config.getName()))
        {
            return new StringBuilder(config.getName()).append(":").append(string).toString().getBytes(charset);
        }
        return string.getBytes(charset);
    }

    @Override
    public String deserialize(byte[] bytes) throws SerializationException
    {
        return (bytes == null ? null : new String(bytes, charset));
    }
}