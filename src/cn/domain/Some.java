package cn.domain;

public class Some {
    private String scardId;
    private String suserName;

    public Some() {
    }

    public Some(String scardId, String suserName) {
        this.scardId = scardId;
        this.suserName = suserName;
    }

    public String getScardId() {
        return scardId;
    }

    public void setScardId(String scardId) {
        this.scardId = scardId;
    }

    public String getSuserName() {
        return suserName;
    }

    public void setSuserName(String suserName) {
        this.suserName = suserName;
    }

    @Override
    public String toString() {
        return "Some{" +
                "scardId='" + scardId + '\'' +
                ", suserName='" + suserName + '\'' +
                '}';
    }
}
