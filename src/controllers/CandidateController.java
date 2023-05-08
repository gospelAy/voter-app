package controllers;

import data.models.Candidate;
import data.models.Party;
import dtos.request.CandidateRequest;
import dtos.response.CandidateResponse;
import services.CandidateService;
import services.CandidateServiceImpl;

public class CandidateController {
    private CandidateService candidateService = new CandidateServiceImpl();

    public CandidateResponse createCandidate(CandidateRequest candidateRequest){
        return candidateService.createCandidate(candidateRequest);
    }
    public Object findCandidateById(int id){
        try {
            return candidateService.findCandidateById(id);
        }catch (IllegalArgumentException ex){
            return ex.getMessage();
        }
    }
    public Candidate findCandidateByParty(Party party){
        return candidateService.findByParty(party);
    }
}
