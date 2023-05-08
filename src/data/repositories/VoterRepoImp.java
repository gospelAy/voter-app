package data.repositories;

import data.models.Voter;

import java.util.ArrayList;
import java.util.List;

public class VoterRepoImp implements VoterRepository {
     static List<Voter> voterslist = new ArrayList<>();
    private int count = 0;

    @Override
    public Voter save(Voter voter) {
        boolean voterHasNotBeenSaved = voter.getId() == 0;
        if (voterHasNotBeenSaved) saveNew(voter);
        return voter;
    }

    private void saveNew(Voter voter) {
        voter.setId(generateVoterId());
        voterslist.add(voter);
        count++;
    }
    private int generateVoterId() {
        return  count +1;
    }


    @Override
    public int count() {
        return count;
    }

    @Override
    public Voter findById(int id) {
        for (Voter voter : voterslist) {
            if (id == voter.getId()) {
                return voter;
            }
        }
        return null;
    }

    @Override
    public int getVoterList() {
        return voterslist.size();
    }

    @Override
    public Voter deleteById(int id) {
        for (Voter voter : voterslist) {
            if (id == voter.getId()) {
                voterslist.remove(id);
            }
        }
        return null;
    }

    @Override
    public Voter findByUsername(String username) {
        for (Voter voter: voterslist) {
            if (voter.getUserName().equals(username))
                return voter;
        }
        return  null;
    }
}
