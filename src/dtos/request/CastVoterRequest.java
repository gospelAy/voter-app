package dtos.request;

import data.models.Candidate;
import data.models.Party;

public class CastVoterRequest {
    private int id;
    private Party party;
    private String userName;


    Candidate candidate = new Candidate();
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CastVoterRequest{");
        sb.append("id=").append(id);
        sb.append(", party=").append(party);
        sb.append(", userName='").append(userName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
