package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.AbstractBaseEntity;
import com.epam.jwd.core_final.domain.BaseEntity;

/**
 * Should be a builder for {@link BaseEntity} fields
 */
public abstract class Criteria<T extends BaseEntity> {//BaseEntityFields?
        AbstractBaseEntity abstractBaseEntity= new AbstractBaseEntity() {
            @Override
            public void setId(long id) {
                super.setId(id);
            }

            @Override
            public void setName(String name) {
                super.setName(name);
            }
        };


}
