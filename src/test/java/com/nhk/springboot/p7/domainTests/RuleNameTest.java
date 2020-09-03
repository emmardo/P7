package com.nhk.springboot.p7.domainTests;

import com.nhk.springboot.p7.domain.RuleName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RuleNameTest {

    private Integer id = 1;
    private String name = "";
    private String description = "";
    private String json = "";
    private String template = "";
    private String sqlStr = "";
    private String sqlPart = "";

    @Test
    public void parameterisedConstructor() {

        //Act
        RuleName newRuleName = new RuleName(name, description, json, template, sqlStr, sqlPart);

        //Arrange
        assertEquals(name, newRuleName.getName());
        assertEquals(description, newRuleName.getDescription());
        assertEquals(json, newRuleName.getJson());
        assertEquals(template, newRuleName.getTemplate());
        assertEquals(sqlStr, newRuleName.getSqlStr());
        assertEquals(sqlPart, newRuleName.getSqlPart());
    }

    @Test
    public void setId() {

        //Arrange
        RuleName newRuleName = new RuleName();

        //Act
        newRuleName.setId(id);

        //Assert
        assertEquals(id, newRuleName.getId());
    }

    @Test
    public void setName() {

        //Arrange
        RuleName newRuleName = new RuleName();

        //Act
        newRuleName.setName(name);

        //Assert
        assertEquals(name, newRuleName.getName());
    }

    @Test
    public void setDescription() {

        //Arrange
        RuleName newRuleName = new RuleName();

        //Act
        newRuleName.setDescription(description);

        //Assert
        assertEquals(description, newRuleName.getDescription());
    }

    @Test
    public void setJson() {

        //Arrange
        RuleName newRuleName = new RuleName();

        //Act
        newRuleName.setJson(json);

        //Assert
        assertEquals(json, newRuleName.getJson());
    }

    @Test
    public void setTemplate() {

        //Arrange
        RuleName newRuleName = new RuleName();

        //Act
        newRuleName.setTemplate(template);

        //Assert
        assertEquals(template, newRuleName.getTemplate());
    }

    @Test
    public void setSqlStr() {

        //Arrange
        RuleName newRuleName = new RuleName();

        //Act
        newRuleName.setSqlStr(sqlStr);

        //Assert
        assertEquals(sqlStr, newRuleName.getSqlStr());
    }

    @Test
    public void setSqlPart() {

        //Arrange
        RuleName newRuleName = new RuleName();

        //Act
        newRuleName.setSqlPart(sqlPart);

        //Assert
        assertEquals(sqlPart, newRuleName.getSqlPart());
    }
}
