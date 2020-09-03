package com.nhk.springboot.p7.domainTests;

import com.nhk.springboot.p7.domain.Rating;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RatingTest {

    private Integer id = 1;
    private String moodysRating = "";
    private String sandPRating = "";
    private String fitchRating = "";
    private Integer orderNumber = 1;

    @Test
    public void parameterisedConstructor() {

        //Act
        Rating newRating = new Rating(moodysRating, sandPRating, fitchRating, orderNumber);

        //Assert
        assertEquals(moodysRating, newRating.getMoodysRating());
        assertEquals(sandPRating, newRating.getSandPRating());
        assertEquals(fitchRating, newRating.getFitchRating());
        assertEquals(orderNumber, newRating.getOrderNumber());
    }

    @Test
    public void setId() {

        //Arrange
        Rating newRating = new Rating();

        //Act
        newRating.setId(id);

        //Assert
        assertEquals(id, newRating.getId());
    }

    @Test
    public void setMoodysRating() {

        //Arrange
        Rating newRating = new Rating();

        //Act
        newRating.setMoodysRating(moodysRating);

        //Assert
        assertEquals(moodysRating, newRating.getMoodysRating());
    }

    @Test
    public void setSandPRating() {

        //Arrange
        Rating newRating = new Rating();

        //Act
        newRating.setSandPRating(sandPRating);

        //Assert
        assertEquals(sandPRating, newRating.getSandPRating());
    }

    @Test
    public void setFitchRating() {

        //Arrange
        Rating newRating = new Rating();

        //Act
        newRating.setFitchRating(fitchRating);

        //Assert
        assertEquals(fitchRating, newRating.getFitchRating());
    }

    @Test
    public void setOrderNumber() {

        //Arrange
        Rating newRating = new Rating();

        //Act
        newRating.setOrderNumber(orderNumber);

        //Assert
        assertEquals(orderNumber, newRating.getOrderNumber());
    }
}
