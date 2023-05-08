package data.repositories;

import data.models.Candidate;
import data.models.Party;

public interface CandidateRepository  {
    Candidate save(Candidate candidate);

    int count();

    Candidate findById(int id);

    int getCandidateList();

    void deleteById(int id);

    Candidate findByParty(Party party);

}
