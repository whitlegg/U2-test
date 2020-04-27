package cn.domain;

import java.util.Date;

public class User {
    private Integer userid;
    private String usernum;
    private String username;
    private String useraddr;
    private Date createdate;
    private Integer cardsid;
    private String cardname;

    public User() {
    }

    public User(Integer userid, String usernum, String username, String useraddr, Date createdate, Integer cardsid, String cardname) {
        this.userid = userid;
        this.usernum = usernum;
        this.username = username;
        this.useraddr = useraddr;
        this.createdate = createdate;
        this.cardsid = cardsid;
        this.cardname = cardname;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseraddr() {
        return useraddr;
    }

    public void setUseraddr(String useraddr) {
        this.useraddr = useraddr;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getCardsid() {
        return cardsid;
    }

    public void setCardsid(Integer cardsid) {
        this.cardsid = cardsid;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", usernum='" + usernum + '\'' +
                ", username='" + username + '\'' +
                ", useraddr='" + useraddr + '\'' +
                ", createdate=" + createdate +
                ", cardsid=" + cardsid +
                ", cardname='" + cardname + '\'' +
                '}';
    }
}
