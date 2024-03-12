package org.jcz.wiki.model;

import java.io.Serializable;

public class BaseModel implements Serializable {
    private Integer isDeleted;

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
