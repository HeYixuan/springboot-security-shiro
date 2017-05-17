package org.springframe.domain;

import javax.persistence.*;
import org.springframe.common.core.SerializableModel;

@Table(name = "system_resources")
public class SystemResources extends SerializableModel {
    /**
     * 编号
     */
    @Id
    private Integer id;

    /**
     * 上级资源 父节点ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 动作:按钮,菜单
     */
    private String action;

    /**
     * 资源链接地址
     */
    private String url;

    /**
     * 权限键值对
     */
    private String authc;

    /**
     * 资源描述
     */
    private String descritpion;

    /**
     * 样式
     */
    private String clazz;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取上级资源 父节点ID
     *
     * @return parent_id - 上级资源 父节点ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级资源 父节点ID
     *
     * @param parentId 上级资源 父节点ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取资源名称
     *
     * @return name - 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源名称
     *
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取动作:按钮,菜单
     *
     * @return action - 动作:按钮,菜单
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置动作:按钮,菜单
     *
     * @param action 动作:按钮,菜单
     */
    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    /**
     * 获取资源链接地址
     *
     * @return url - 资源链接地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置资源链接地址
     *
     * @param url 资源链接地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取权限键值对
     *
     * @return authc - 权限键值对
     */
    public String getAuthc() {
        return authc;
    }

    /**
     * 设置权限键值对
     *
     * @param authc 权限键值对
     */
    public void setAuthc(String authc) {
        this.authc = authc == null ? null : authc.trim();
    }

    /**
     * 获取资源描述
     *
     * @return descritpion - 资源描述
     */
    public String getDescritpion() {
        return descritpion;
    }

    /**
     * 设置资源描述
     *
     * @param descritpion 资源描述
     */
    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion == null ? null : descritpion.trim();
    }

    /**
     * 获取样式
     *
     * @return clazz - 样式
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * 设置样式
     *
     * @param clazz 样式
     */
    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
    }
}