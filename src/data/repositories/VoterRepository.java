package data.repositories;

import data.models.Voter;

public interface VoterRepository {
    Voter save(Voter voter);

    int count();

    Voter findById(int id);

    int getVoterList();

    Voter deleteById(int id);

    Voter findByUsername(String username);

}
