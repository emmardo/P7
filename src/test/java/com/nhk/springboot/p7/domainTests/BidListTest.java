package com.nhk.springboot.p7.domainTests;

import com.nhk.springboot.p7.domain.BidList;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BidListTest {

    private Integer bidListId = 1;
    private String account = "";
    private String type = "";
    private Double bidQuantity = 1.0d;
    private Double askQuantity = 1.0d;
    private Double bid = 1.0d;
    private Double ask = 1.0d;
    private String benchmark = "";
    private Timestamp bidListDate = new Timestamp(1L);
    private String commentary = "";
    private String security = "";
    private String status = "";
    private String trader = "";
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
        BidList newBidList = new BidList(account, type, security, bidQuantity);

        //Assert
        assertEquals(account, newBidList.getAccount());
        assertEquals(type, newBidList.getType());
        assertEquals(security, newBidList.getSecurity());
        assertEquals(bidQuantity, newBidList.getBidQuantity());
    }

    @Test
    public void setBidListId() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setBidListId(bidListId);

        //Assert
        assertEquals(bidListId, newBidList.getBidListId());
    }

    @Test
    public void setAccount() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setAccount(account);

        //Assert
        assertEquals(account, newBidList.getAccount());
    }

    @Test
    public void setType() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setType(type);

        //Assert
        assertEquals(type, newBidList.getType());
    }

    @Test
    public void setBidQuantity() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setBidQuantity(bidQuantity);

        //Assert
        assertEquals(bidQuantity, newBidList.getBidQuantity());
    }

    @Test
    public void setAskQuantity() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setAskQuantity(askQuantity);

        //Assert
        assertEquals(askQuantity, newBidList.getAskQuantity());
    }

    @Test
    public void setBid() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setBid(bid);

        //Assert
        assertEquals(bid, newBidList.getBid());
    }

    @Test
    public void setAsk() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setAsk(ask);

        //Assert
        assertEquals(ask, newBidList.getAsk());
    }

    @Test
    public void setBenchmark() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setBenchmark(benchmark);

        //Assert
        assertEquals(benchmark, newBidList.getBenchmark());
    }

    @Test
    public void setBidListDate() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setBidListDate(bidListDate);

        //Assert
        assertEquals(bidListDate, newBidList.getBidListDate());
    }

    @Test
    public void setCommentary() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setCommentary(commentary);

        //Assert
        assertEquals(commentary, newBidList.getCommentary());
    }

    @Test
    public void setSecurity() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setSecurity(security);

        //Assert
        assertEquals(security, newBidList.getSecurity());
    }

    @Test
    public void setStatus() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setStatus(status);

        //Assert
        assertEquals(status, newBidList.getStatus());
    }

    @Test
    public void setTrader() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setTrader(trader);

        //Assert
        assertEquals(trader, newBidList.getTrader());
    }

    @Test
    public void setBook() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setBook(book);

        //Assert
        assertEquals(book, newBidList.getBook());
    }

    @Test
    public void setCreationName() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setCreationName(creationName);

        //Assert
        assertEquals(creationName, newBidList.getCreationName());
    }

    @Test
    public void setCreationDate() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setCreationDate(creationDate);

        //Assert
        assertEquals(creationDate, newBidList.getCreationDate());
    }

    @Test
    public void setRevisionName() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setRevisionName(revisionName);

        //Assert
        assertEquals(revisionName, newBidList.getRevisionName());
    }

    @Test
    public void setRevisionDate() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setRevisionDate(revisionDate);

        //Assert
        assertEquals(revisionDate, newBidList.getRevisionDate());
    }

    @Test
    public void setDealName() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setDealName(dealName);

        //Assert
        assertEquals(dealName, newBidList.getDealName());
    }

    @Test
    public void setDealType() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setDealType(dealType);

        //Assert
        assertEquals(dealType, newBidList.getDealType());
    }

    @Test
    public void setSourceListId() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setSourceListId(sourceListId);

        //Assert
        assertEquals(sourceListId, newBidList.getSourceListId());
    }

    @Test
    public void setSide() {

        //Arrange
        BidList newBidList = new BidList();

        //Act
        newBidList.setSide(side);

        //Assert
        assertEquals(side, newBidList.getSide());
    }
}
