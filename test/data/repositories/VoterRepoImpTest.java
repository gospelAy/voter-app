package data.repositories;

import data.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoterRepoImpTest {
    Voter voter;
    VoterRepository voterRepository;
    @BeforeEach
    public void startWith(){
        voter = new Voter();
       voterRepository = new VoterRepoImp();
        voter.setLastName("ikechukwu");
        voter.setFirstName("gospel");
        voter.setGender("male");
        voter.setUserName("gospel smith");
        voter.setAge(30);
        voter.setState("Lagos state");
        voter.setVotersPassword("23431kjd");
        voterRepository.save(voter);

        voter.setLastName("blessing");
        voter.setFirstName("gospel blend");
        voter.setGender("male");
        voter.setUserName("gospel smith");
        voter.setAge(30);
        voter.setState("Lagos state");
        voter.setVotersPassword("23431kjd");
        voterRepository.save(voter);

        Voter voter1 = new Voter();
        voter1.setLastName("chibuzor");
        voter1.setFirstName("glory");
        voter1.setGender("female");
        voter1.setUserName("gloryFemale");
        voter1.setAge(40);
        voter1.setState("Abia");
        voter1.setVotersPassword("23431787");
        voterRepository.save(voter1);
    }
    @Test
    public void testThatObjectExist(){
        assertNotNull(voter);
        assertNotNull(voterRepository);
    }
    @Test
    public void testThatCandidateCanBeCreated(){
    assertEquals(1, voter.getId());
    }
    @Test
    public void testThatCandidateThatHasBeenCreated_CanNotBeCreatedIfEdit(){
        assertEquals(1, voter.getId());
    }
    @Test
    public void testThatCountIncreaseBy1IfAnotherCandidateIsCreated(){
        assertEquals(2, voterRepository.count());
    }
    @Test
    public void testThatCandidateCanBeFindById(){
        Voter voter1 = voterRepository.findById(2);
        assertEquals("23431787", voter1.getVotersPassword());
    }
    @Test
    public void testThatCandidateCanBeDeleteById(){
        Voter voter = voterRepository.findById(1);
        assertEquals("male", voter.getGender());
        assertEquals(2, voterRepository.getVoterList());
        voterRepository.deleteById(1);
        assertEquals(1, voterRepository.getVoterList());
    }
}