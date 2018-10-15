package com.banxue.projects.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


@TableName("bx_lex_experience_center")
public class ExperienceCenter extends Model<ExperienceCenter> {

    private static final long serialVersionUID = 1L;

    /**
     * 增长id
     */
    @TableId(value = "center_id", type = IdType.AUTO)
    private Integer centerId;

    /**
     * 体验中心编号
     */
    @TableField("center_no")
    private String centerNo;

    /**
     * 体验中心名称
     */
    @TableField("center_name")
    private String centerName;
    
    /**
     * 体验中心地区
     */
    @TableField("center_area")
    private String centerArea;
    
    /**
     * 体验中心地区
     */
    @TableField("center_state")
    private Integer centerState;
    

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 是否删除，1删除，0正常
     */
    @TableField("is_del")
    private Integer isDel;

    /**
     * 备注
     */
    private String remark;

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return centerId;
	}

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public String getCenterNo() {
		return centerNo;
	}

	public void setCenterNo(String centerNo) {
		this.centerNo = centerNo;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterArea() {
		return centerArea;
	}

	public void setCenterArea(String centerArea) {
		this.centerArea = centerArea;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getCenterState() {
		return centerState;
	}

	public void setCenterState(Integer centerState) {
		this.centerState = centerState;
	}

	@Override
	public String toString() {
		return "ExperienceCenter [centerId=" + centerId + ", centerNo=" + centerNo + ", centerName=" + centerName
				+ ", centerArea=" + centerArea + ", centerState=" + centerState + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", isDel=" + isDel + ", remark=" + remark + "]";
	}

}
