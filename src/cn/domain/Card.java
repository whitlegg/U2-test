package cn.domain;

public class Card {
    private Integer cardid;
    private String cardname;

    public Card() {
    }

    public Card(Integer cardid, String cardname) {
        this.cardid = cardid;
        this.cardname = cardname;
    }

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardid=" + cardid +
                ", cardname='" + cardname + '\'' +
                '}';
    }
}
