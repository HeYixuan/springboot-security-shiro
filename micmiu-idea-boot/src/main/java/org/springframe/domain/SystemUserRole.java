package org.springframe.domain;

import javax.persistence.*;
import org.springframe.common.core.SerializableModel;

@Table(name = "system_user_role")
public class SystemUserRole extends SerializableModel {
    @Id
    @Column(name = "system_user_id")
    private Integer systemUserId;

    @Id
    @Column(name = "system_role_id")
    private Integer systemRoleId;

    /**
     * @return system_user_id
     */
    public Integer getSystemUserId() {
        return systemUserId;
    }

    /**
     * @param systemUserId
     */
    public void setSystemUserId(Integer systemUserId) {
        this.systemUserId = systemUserId;
    }

    /**
     * @return system_role_id
     */
    public Integer getSystemRoleId() {
        return systemRoleId;
    }

    /**
     * @param systemRoleId
     */
    public void setSystemRoleId(Integer systemRoleId) {
        this.systemRoleId = systemRoleId;
    }
}