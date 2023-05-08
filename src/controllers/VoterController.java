package controllers;

import data.models.Voter;
import dtos.request.CastVoterRequest;
import dtos.request.LoginRequest;
import dtos.request.RegisterRequest;
import dtos.response.CastVoterResponse;
import services.VoterService;
import services.VoterServiceImpl;

public class VoterController {

    private VoterService voterService = new VoterServiceImpl();
    public Object voterRegistration(RegisterRequest registerRequest){
        try {
            return voterService.voterRegistration(registerRequest);
        }catch (IllegalArgumentException ex){
            return  ex.getMessage();
        }
    }
    public Voter findVoterById(int id){
        return voterService.findById(id);
    }
    public CastVoterResponse castVote(CastVoterRequest request) {
        return castVote(request);
    }
    public String login(LoginRequest loginRequest){
        return voterService.login(loginRequest);
    }
}
