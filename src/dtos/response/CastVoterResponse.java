package dtos.response;

public class CastVoterResponse{
    private String userName;
    private String votedSuccessfully;

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getVotedSuccessfully(){
        return votedSuccessfully;
    }
    public void setVotedSuccessfully(String votedSuccessfully){
        this.votedSuccessfully = votedSuccessfully;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CastVoterResponse{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", votedSuccessfully='").append(votedSuccessfully).append('\'');
        sb.append('}');
        return sb.toString();
    }
}