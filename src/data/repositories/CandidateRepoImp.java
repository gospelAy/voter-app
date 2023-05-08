package data.repositories;

import data.models.Candidate;
import data.models.Party;

import java.util.ArrayList;
import java.util.List;

public class CandidateRepoImp implements CandidateRepository{
    static List<Candidate> candidateList = new ArrayList<>();
    private int count;

    @Override
    public Candidate save(Candidate candidate) {
        boolean candidateHasNotBeenSaved = candidate.getCandidateId() == 0;
        if (candidateHasNotBeenSaved) saveNew(candidate);
        return candidate;
    }
    public void saveNew(Candidate candidate) {
    candidate.setCandidateId(generateCandidateId());
    candidateList.add(candidate);
    count++;
    }
    public int generateCandidateId() {
        return count + 1;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public Candidate findById(int id) {
        for (Candidate candidate: candidateList) {
            if (candidate.getCandidateId() == id){
                return candidate;
            }
        }
        return null;
    }

    @Override
    public int getCandidateList() {
        return candidateList.size();
    }

    @Override
    public void deleteById(int id) {
        for (Candidate candidate: candidateList) {
            if (id == candidate.getCandidateId()){
                candidateList.remove(id);
            }
        }
    }

    @Override
    public Candidate findByParty(Party party) {
        for (Candidate candidate:candidateList) {
            if (candidate.getParty().equals(party)){
                return candidate;
            }
        }
        return null;
    }
}
