package services;

import data.models.Candidate;
import data.models.Party;
import data.repositories.CandidateRepoImp;
import data.repositories.CandidateRepository;
import data.repositories.VoterRepoImp;
import data.repositories.VoterRepository;
import dtos.request.CandidateRequest;
import dtos.response.CandidateResponse;
import utils.Mapper;

public class CandidateServiceImpl implements CandidateService {

    CandidateRepository candidateRepository = new CandidateRepoImp();
    Candidate registerCandidate;

    @Override
    public CandidateResponse createCandidate(CandidateRequest candidateRequest) {
        registerCandidate = Mapper.map(candidateRequest);
        CandidateResponse candidateResponse = new CandidateResponse();
        Candidate candidate = candidateRepository.save(registerCandidate);
        Mapper.map(candidate, candidateResponse);
        return candidateResponse;
    }

    @Override
    public Candidate findCandidateById(int id) {
        Candidate findCandidate = candidateRepository.findById(id);
        if ( findCandidate == null){
            throw  new IllegalArgumentException("Voter does not exist");
        }
        CandidateResponse response = new CandidateResponse();
        Mapper.map(findCandidate, response);
        return findCandidate;
    }

    @Override
    public int getCandidateList() {
        return candidateRepository.getCandidateList();
    }

    @Override
    public Candidate findByParty(Party party) {
        return candidateRepository.findByParty(party);
    }
}