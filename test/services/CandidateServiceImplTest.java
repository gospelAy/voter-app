package services;

import data.models.Party;
import dtos.request.CandidateRequest;
import dtos.response.CandidateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidateServiceImplTest {
    CandidateService candidateService;
    CandidateResponse candidateResponse;
    @BeforeEach
    public void startWith() {
        candidateService = new CandidateServiceImpl();
        candidateResponse = new CandidateResponse();

        CandidateRequest candidateRequest = new CandidateRequest();
        candidateRequest.setGender("male");
        candidateRequest.setAge(34);
        candidateRequest.setName("Ben Billion");
        candidateRequest.setParty(Party.PDP);
        candidateResponse = candidateService.createCandidate(candidateRequest);
    }
    @Test
    public void testThatObjectExist(){
        assertNotNull(candidateService);
    }
    @Test
    public void testThatCandidateCanRegister(){
        assertEquals(1, candidateService.getCandidateList());
    }
    @Test
    public void testThatAnotherVoterCanBeRegistered_CountWillBe2(){
        CandidateRequest candidateRequest2 = new CandidateRequest();
        candidateRequest2.setGender("female");
        candidateRequest2.setAge(55);
        candidateRequest2.setName("gospel");
        candidateRequest2.setParty(Party.LP);
        candidateService.createCandidate(candidateRequest2);
        assertEquals(2, candidateService.getCandidateList());

    }
}