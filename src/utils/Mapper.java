package utils;

import data.models.Candidate;
import data.models.Voter;
import dtos.request.CandidateRequest;
import dtos.request.CastVoterRequest;
import dtos.request.LoginRequest;
import dtos.request.RegisterRequest;
import dtos.response.CandidateResponse;
import dtos.response.CastVoterResponse;
import dtos.response.LoginResponse;
import dtos.response.RegisterResponse;

public class Mapper {
    public static Voter map(RegisterRequest registerRequest){
        Voter voter = new Voter();
        voter.setGender(registerRequest.getGender());
        voter.setFirstName(registerRequest.getFirstName());
        voter.setLastName(registerRequest.getLastName());
        voter.setState(registerRequest.getState());
        voter.setAge(registerRequest.getAge());
        voter.setUserName(registerRequest.getUserName());
        return voter;
    }
    public static void map(Voter voter, RegisterResponse response){
        response.setAge(voter.getAge());
        response.setFirstName(voter.getFirstName());
        response.setGender(voter.getGender());
        response.setState(voter.getState());
        response.setLastName(voter.getLastName());
        response.setUserName(voter.getUserName());
        response.setId(voter.getId());
    }
    public static Candidate map(CandidateRequest candidateRequest){
        Candidate candidate = new Candidate();
        candidate.setAge(candidateRequest.getAge());
        candidate.setName(candidateRequest.getName());
        candidate.setGender(candidateRequest.getGender());
        candidate.setParty(candidateRequest.getParty());
        return candidate;
    }
    public static void map(Candidate foundCandidate, CandidateResponse response){
        response.setAge(foundCandidate.getAge());
        response.setGender(foundCandidate.getGender());
        response.setName(foundCandidate.getName());
        response.setCandidateId(foundCandidate.getCandidateId());
        response.setParty(foundCandidate.getParty());
    }

    public static void map(LoginRequest loginRequest, LoginResponse loginResponse){
        loginResponse.setUserName(loginRequest.getUserName());
        loginResponse.setWelcomeMessage(loginRequest.getUserName() + " welcome back");
        loginRequest.setPassword(loginRequest.getPassword());
    }

    public static void map(CastVoterRequest castVoterRequest, CastVoterResponse castVoterResponse){
        castVoterResponse.setUserName(castVoterRequest.getUserName());
        castVoterResponse.setVotedSuccessfully(castVoterRequest.getUserName() + "you have successfully voted");
    }
}
