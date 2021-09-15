package com.example.springboot2.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// 秒杀商品

@Entity
@Table(name = "ay_user_kill_product")

public class AyUserKillProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //指定主键的生成策略。有如下四个值 id是主键
    // TABLE：使用表保存id值
    // IDENTITY：由数据库自动生成
    // SEQUENCR ：根据底层数据库的序列来生成主键，条件是数据库支持序列
    // AUTO：主键由程序控制

    private Integer id;
    /**
     * 商品id
     */
    private Integer productId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 状态，-1：无效；0：成功；1：已付款'
      */
    private Integer state;
    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
