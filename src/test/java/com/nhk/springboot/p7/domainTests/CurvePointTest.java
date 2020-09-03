package com.nhk.springboot.p7.domainTests;

import com.nhk.springboot.p7.domain.CurvePoint;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurvePointTest {

    private Integer id = 1;
    private Timestamp asOfDate = new Timestamp(1L);
    private Double term = 1.0d;
    private Double value = 1.0d;
    private Timestamp creationDate = new Timestamp(1L);

    @Test
    public void parameterisedConstructor() {

        //Act
        CurvePoint newCurvePoint = new CurvePoint(term, value);

        //Assert
        assertEquals(term, newCurvePoint.getTerm());
        assertEquals(value, newCurvePoint.getValue());
    }

    @Test
    public void setId() {

        //Arrange
        CurvePoint newCurvePoint = new CurvePoint();

        //Act
        newCurvePoint.setId(id);

        //Assert
        assertEquals(id, newCurvePoint.getId());
    }

    @Test
    public void setAsOfDate() {

        //Arrange
        CurvePoint newCurvePoint = new CurvePoint();

        //Act
        newCurvePoint.setAsOfDate(asOfDate);

        //Assert
        assertEquals(asOfDate, newCurvePoint.getAsOfDate());
    }

    @Test
    public void setTerm() {

        //Arrange
        CurvePoint newCurvePoint = new CurvePoint();

        //Act
        newCurvePoint.setTerm(term);

        //Assert
        assertEquals(term, newCurvePoint.getTerm());
    }

    @Test
    public void setValue() {

        //Arrange
        CurvePoint newCurvePoint = new CurvePoint();

        //Act
        newCurvePoint.setValue(value);

        //Assert
        assertEquals(value, newCurvePoint.getValue());
    }

    @Test
    public void setCreationDate() {

        //Arrange
        CurvePoint newCurvePoint = new CurvePoint();

        //Act
        newCurvePoint.setCreationDate(creationDate);

        //Assert
        assertEquals(creationDate, newCurvePoint.getCreationDate());
    }
}
