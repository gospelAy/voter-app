package services;

import data.models.Candidate;
import data.models.Party;
import data.models.Voter;
import data.repositories.CandidateRepoImp;
import data.repositories.CandidateRepository;
import dtos.request.CastVoterRequest;
import dtos.request.LoginRequest;
import dtos.request.RegisterRequest;
import dtos.response.CastVoterResponse;
import dtos.response.LoginResponse;
import dtos.response.RegisterResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoterServiceImplTest {

    Candidate candidate;
    CastVoterRequest castVoterRequest;
    LoginRequest loginRequest;
    LoginRequest loginRequest2;
    VoterService voterService;
    RegisterRequest registerRequest;
    RegisterRequest registerRequest1;

    RegisterRequest registerRequest2;

    RegisterRequest registerRequest4;
    RegisterResponse response;

    LoginResponse loginResponse;
    LoginResponse loginResponse2;

    CastVoterResponse castVoterResponse;

    @BeforeEach
    public void startWith() {
        candidate = new Candidate();
        response = new RegisterResponse();
        voterService = new VoterServiceImpl();
        registerRequest = new RegisterRequest();

        registerRequest.setAge(39);
        registerRequest.setFirstName("Gospel");
        registerRequest.setGender("Male");
        registerRequest.setLastName("Blessing");
        registerRequest.setState("Lagos state");
        registerRequest.setVotePassword("123bu23");
        registerRequest.setUserName("Sticks Taylor");
        response = voterService.voterRegistration(registerRequest);

        registerRequest1 = new RegisterRequest();
        registerRequest1.setAge(39);
        registerRequest1.setFirstName("Doris");
        registerRequest1.setGender("Male");
        registerRequest1.setLastName("Chris");
        registerRequest1.setState("Port");
        registerRequest1.setVotePassword("Bd345");
        registerRequest1.setUserName("Sticks Drums");
        voterService.voterRegistration(registerRequest1);

        registerRequest2 = new RegisterRequest();
        registerRequest2.setUserName("GP Doskey");
        registerRequest2.setState("Abuja");
        registerRequest2.setLastName("King face");
        registerRequest2.setGender("male");
        registerRequest2.setFirstName("Spencer");
        registerRequest2.setVotePassword("23ed453");
        registerRequest2.setAge(50);
        response = voterService.voterRegistration(registerRequest2);
        loginRequest = new LoginRequest();
        loginRequest.setPassword("23ed453");
        loginRequest.setUserName("GP Doskey");

        registerRequest4 = new RegisterRequest();
        registerRequest4.setUserName("Joy girl");
        registerRequest4.setState("Kaduna");
        registerRequest4.setLastName("King face");
        registerRequest4.setGender("Female");
        registerRequest4.setFirstName("Flex");
        registerRequest4.setVotePassword("23453431");
        registerRequest4.setAge(34);
        loginResponse2 = new LoginResponse();
        loginRequest2 = new LoginRequest();
        loginRequest2.setUserName("Joy girl");
        loginRequest2.setPassword("23453431");

    }

    @Test
    public void testThatObjectExist() {
        assertNotNull(voterService);
    }

    @Test
    public void testThatVoterCanRegisterToVote() {
        assertEquals(3, voterService.getVoterList());
        System.out.println(voterService.getVoterList());
    }
    @Test
    public void testThatVoterHasToLoginBeforeVoting() {
        loginResponse = new LoginResponse();
        response = voterService.voterRegistration(registerRequest2);
        assertEquals("GP Doskey welcome back", voterService.login(loginRequest));
    }
    @Test
    public void testThatVoterCanVote(){
        response = voterService.voterRegistration(registerRequest4);
        assertEquals(4, voterService.getVoterList());
        assertEquals("Joy girl welcome back", voterService.login(loginRequest2));
        castVoterRequest = new CastVoterRequest();
        castVoterRequest.setUserName("Joy girl");
        castVoterRequest.setParty(Party.LP);
        castVoterRequest.setId(4);
        CastVoterResponse increaseVote = voterService.castVote(castVoterRequest);
        assertEquals(1, increaseVote);
    }
}