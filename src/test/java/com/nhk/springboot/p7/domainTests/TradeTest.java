package com.nhk.springboot.p7.domainTests;

import com.nhk.springboot.p7.domain.Trade;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TradeTest {

    private Integer tradeId = 1;
    private String account = "";
    private String type = "";
    private Double buyQuantity = 1.0d;
    private Double sellQuantity = 1.0d;
    private Double buyPrice = 1.0d;
    private Double sellPrice = 1.0d;
    private Timestamp tradeDate = new Timestamp(1L);
    private String security = "";
    private String status = "";
    private String trader = "";
    private String benchmark = "";
    private String book = "";
    private String creationName = "";
    private Timestamp creationDate = new Timestamp(1L);
    private String revisionName = "";
    private Timestamp revisionDate = new Timestamp(1L);
    private String dealName = "";
    private String dealType = "";
    private String sourceListId = "";
    private String side = "";

    @Test
    public void parameterisedConstructor() {

        //Act
        Trade newTrade = new Trade(account, type, security);

        //Assert
        assertEquals(account, newTrade.getAccount());
        assertEquals(type, newTrade.getType());
        assertEquals(security, newTrade.getSecurity());
    }

    @Test
    public void setTradeId() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setTradeId(tradeId);

        //Assert
        assertEquals(tradeId, newTrade.getTradeId());
    }

    @Test
    public void setAccount() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setAccount(account);

        //Assert
        assertEquals(account, newTrade.getAccount());
    }

    @Test
    public void setType() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setType(type);

        //Assert
        assertEquals(type, newTrade.getType());
    }

    @Test
    public void setBuyQuantity() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setBuyQuantity(buyQuantity);

        //Assert
        assertEquals(buyQuantity, newTrade.getBuyQuantity());
    }

    @Test
    public void setSellQuantity() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setSellQuantity(sellQuantity);

        //Assert
        assertEquals(sellQuantity, newTrade.getSellQuantity());
    }

    @Test
    public void setBuyPrice() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setBuyPrice(buyPrice);

        //Assert
        assertEquals(buyPrice, newTrade.getBuyPrice());
    }

    @Test
    public void setSellPrice() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setSellPrice(sellPrice);

        //Assert
        assertEquals(sellPrice, newTrade.getSellPrice());
    }

    @Test
    public void setTradeDate() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setTradeDate(tradeDate);

        //Assert
        assertEquals(tradeDate, newTrade.getTradeDate());
    }

    @Test
    public void setSecurity() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setSecurity(security);

        //Assert
        assertEquals(security, newTrade.getSecurity());
    }

    @Test
    public void setStatus() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setStatus(status);

        //Assert
        assertEquals(status, newTrade.getStatus());
    }

    @Test
    public void setTrader() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setTrader(trader);

        //Assert
        assertEquals(trader, newTrade.getTrader());
    }

    @Test
    public void setBenchmark() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setBenchmark(benchmark);

        //Assert
        assertEquals(benchmark, newTrade.getBenchmark());
    }

    @Test
    public void setBook() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setBook(book);

        //Assert
        assertEquals(book, newTrade.getBook());
    }

    @Test
    public void setCreationName() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setCreationName(creationName);

        //Assert
        assertEquals(creationName, newTrade.getCreationName());
    }

    @Test
    public void setCreationDate() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setCreationDate(creationDate);

        //Assert
        assertEquals(creationDate, newTrade.getCreationDate());
    }

    @Test
    public void setRevisionName() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setRevisionName(revisionName);

        //Assert
        assertEquals(revisionName, newTrade.getRevisionName());
    }

    @Test
    public void setRevisionDate() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setRevisionDate(revisionDate);

        //Assert
        assertEquals(revisionDate, newTrade.getRevisionDate());
    }

    @Test
    public void setDealName() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setDealName(dealName);

        //Assert
        assertEquals(dealName, newTrade.getDealName());
    }

    @Test
    public void setDealType() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setDealType(dealType);

        //Assert
        assertEquals(dealType, newTrade.getDealType());
    }

    @Test
    public void setSourceListId() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setSourceListId(sourceListId);

        //Assert
        assertEquals(sourceListId, newTrade.getSourceListId());
    }

    @Test
    public void setSide() {

        //Arrange
        Trade newTrade = new Trade();

        //Act
        newTrade.setSide(side);

        //Assert
        assertEquals(side, newTrade.getSide());
    }
}
