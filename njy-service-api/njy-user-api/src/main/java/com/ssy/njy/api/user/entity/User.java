package com.ssy.njy.api.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ssy.njy.common.util.DateUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户实体类
 *
 * @author: mqxu
 * @date: 2021-07-26
 **/
@Data
@TableName("njy_user")
public class User {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 账号
     */
    @ApiModelProperty(value = "用户账号")
    private String account;

    /**
     * 密码
     */
    @ApiModelProperty(value = "用户密码")
    private String password;
    /**
     * 昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String name;
    /**
     * 真名
     */
    @ApiModelProperty(value = "用户真实姓名")
    private String realName;
    /**
     * 头像
     */
    @ApiModelProperty(value = "用户头像")
    private String avatar;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "用户邮箱")
    private String email;
    /**
     * 手机
     */
    @ApiModelProperty(value = "用户手机")
    private String phone;
    /**
     * 生日
     */
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATE)
    @JsonFormat(pattern = DateUtil.PATTERN_DATE)
    @ApiModelProperty(value = "用户生日")
    private LocalDate birthday;
    /**
     * 性别
     */
    @ApiModelProperty(value = "用户性别")
    private Integer gender;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    /**
     * 状态[1:正常]
     */
    @ApiModelProperty(value = "业务状态")
    private Integer status;

    /**
     * 状态[0:未删除,1:删除]
     */
    @TableLogic
    @ApiModelProperty(value = "是否已删除")
    private Integer isDeleted;

}
