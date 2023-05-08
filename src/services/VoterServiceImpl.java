package services;

import data.models.Candidate;
import data.models.Party;
import data.models.Voter;
import data.repositories.CandidateRepoImp;
import data.repositories.CandidateRepository;
import data.repositories.VoterRepoImp;
import data.repositories.VoterRepository;
import dtos.request.CastVoterRequest;
import dtos.request.LoginRequest;
import dtos.request.RegisterRequest;
import dtos.response.CastVoterResponse;
import dtos.response.LoginResponse;
import dtos.response.RegisterResponse;
import utils.Mapper;

import java.util.Objects;

public class VoterServiceImpl implements VoterService {

    VoterRepository voterRepository = new VoterRepoImp();
    CandidateRepository candidateRepository = new CandidateRepoImp();
    CandidateService candidateService = new CandidateServiceImpl();
    Voter registerVoter;

    @Override
    public RegisterResponse voterRegistration(RegisterRequest registerRequest) {
        if (registerRequest.getAge() < 18)
            throw new IllegalArgumentException(" sorry you have to be 18 years and above" +
                    "before you can voter");
        registerVoter = Mapper.map(registerRequest);
        RegisterResponse response = new RegisterResponse();
        Voter voter = voterRepository.save(registerVoter);
        Mapper.map(voter, response);
        return response;
    }


    @Override
    public int getVoterList() {
        return voterRepository.getVoterList();
    }

    @Override
    public String login(LoginRequest request) {
        LoginResponse loginResponse = new LoginResponse();
        validateLoginPassword(request.getPassword());
        if (Objects.equals(voterRepository.findByUsername(request.getUserName()).getUserName(), request.getUserName())) {
            Mapper.map(request, loginResponse);
            return loginResponse.getWelcomeMessage();
        }
       throw new IllegalArgumentException("This userName is incorrect please check and try again");
    }

    @Override
    public Voter findById(int id) {
        return voterRepository.findById(id);
    }

    @Override
    public  CastVoterResponse castVote(CastVoterRequest request) {
        CastVoterResponse castVoterResponse = new CastVoterResponse();
        Mapper.map(request, castVoterResponse);
        Voter findVoter = voterRepository.findById(request.getId());
        Candidate findCandidate = candidateService.findByParty(request.getParty());
       if (findVoter.isVoted()){
           throw new IllegalArgumentException("VOTER ALREADY VOTED");
       } else if (findCandidate == null) {
           throw new IllegalArgumentException("PARTY/CANDIDATE DOES NOT EXIST ");
       }else{
           findCandidate.setNumberOfVoter(findCandidate.getNumberOfVoter() + 1);
           findVoter.setVoted(true);
       }
        return  castVoterResponse;
    }

    private void validateLoginPassword(String password) {
//        if (!password.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$")){
//            throw  new IllegalArgumentException("invalid ->> ( password )");
//        }
    }
}

