package com.epam.jwd.core_final.factory;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import org.junit.Test;

public class CrewMemberFactoryTest {

    @Test
    public void create() {
        EntityFactory factory = new CrewMemberFactory();
        CrewMember d= (CrewMember) factory.create("1,Ann,2");
        d.toString();
    }
}