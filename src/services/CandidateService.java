package services;

import data.models.Candidate;
import data.models.Party;
import dtos.request.CandidateRequest;
import dtos.response.CandidateResponse;

public interface CandidateService {
    CandidateResponse createCandidate(CandidateRequest candidateRequest);
    Candidate findCandidateById(int id);
    int getCandidateList();

    Candidate findByParty(Party party);
}
