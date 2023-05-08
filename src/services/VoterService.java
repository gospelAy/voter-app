package services;

import data.models.Voter;
import dtos.request.CastVoterRequest;
import dtos.request.LoginRequest;
import dtos.request.RegisterRequest;
import dtos.response.CastVoterResponse;
import dtos.response.RegisterResponse;

public interface VoterService {
    RegisterResponse voterRegistration(RegisterRequest registerRequest);

    int getVoterList();

    String login(LoginRequest request);

    Voter findById(int id);

    CastVoterResponse castVote(CastVoterRequest request);

}
