package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.AbstractBaseEntity;
import com.epam.jwd.core_final.domain.BaseEntity;

/**
 * Should be a builder for {@link BaseEntity} fields
 */
public abstract class Criteria<T extends BaseEntity> {//BaseEntityFields?
    private long id;
    private String name;

    public static class Builder{
        private Criteria newCriteria;

        public Builder(){
            newCriteria=new Criteria() {
                @Override
                public int hashCode() {
                    return super.hashCode();
                }
            };
        }

        public Builder withID(long id){
            newCriteria.id=id;
            return this;
        }

        public Builder withName(String name){
            newCriteria.name=name;
            return this;
        }
    }


}
