package data.models;

public enum Party {
    PDP(0, "ATIKU"),
    APC(0,"BOLABA"),
    LP(0,"PETER OBI");

    int increaseVote = 0;

    Party(int increaseVote, String candidateForParty){
        this.increaseVote = increaseVote;
    }

    public int getIncreaseVote() {
        return increaseVote;
    }

    public void setIncreaseVote(int increaseVote) {
        this.increaseVote = increaseVote;
    }
}
