package org.springframe.domain;

import javax.persistence.*;
import org.springframe.common.core.SerializableModel;

@Table(name = "system_role_resource")
public class SystemRoleResource extends SerializableModel {
    @Id
    @Column(name = "system_resource_id")
    private Integer systemResourceId;

    @Id
    @Column(name = "system_role_id")
    private Integer systemRoleId;

    /**
     * @return system_resource_id
     */
    public Integer getSystemResourceId() {
        return systemResourceId;
    }

    /**
     * @param systemResourceId
     */
    public void setSystemResourceId(Integer systemResourceId) {
        this.systemResourceId = systemResourceId;
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