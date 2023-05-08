package data.repositories;

import data.models.Candidate;
import data.models.Party;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidateRepoImpTest {
    CandidateRepository candidateRepository;
    Candidate candidate;
    Candidate candidate1;
    @BeforeEach
    public void startWith(){
        candidateRepository = new CandidateRepoImp();
        candidate = new Candidate();
        candidate.setName("Blessing");
        candidate.setGender("Female");
        candidate.setAge(30);
        candidate.setParty(Party.PDP);
        candidateRepository.save(candidate);

        candidate.setName("Blessing");
        candidate.setGender("Female");
        candidate.setAge(20);
        candidate.setParty(Party.PDP);
        candidateRepository.save(candidate);

        candidate1 = new Candidate();
        candidate1.setName("Glory");
        candidate1.setGender("Female");
        candidate1.setParty(Party.LP);
        candidate1.setAge(40);
        candidateRepository.save(candidate1);
    }
    @Test
    public void testThatObjectExist(){
        assertNotNull(candidate);
        assertNotNull(candidateRepository);
    }
    @Test
    public void testThatCandidateCanBeCreated(){
        assertEquals(1, candidate.getCandidateId());
    }
    @Test
    public void testThatCandidateThatHasBeenCreated_CanNotBeCreatedIfEdit(){
        assertEquals(1, candidate.getCandidateId());
    }
    @Test
    public void testThatCountIncreaseBy1IfAnotherCandidateIsCreated(){
        assertEquals(2, candidateRepository.count());
    }
    @Test
    public void testThatCandidateCanBeFindById(){
       Candidate candidate1 = candidateRepository.findById(2);
        assertEquals("Female", candidate1.getGender());
    }
    @Test
    public void testThatCandidateCanBeDeleteById(){
        Candidate candidate = candidateRepository.findById(1);
        assertEquals("Blessing", candidate.getName());
        assertEquals(2, candidateRepository.getCandidateList());
        candidateRepository.deleteById(1);
        assertEquals(1, candidateRepository.getCandidateList());
    }
    @Test
    public void testThatCandidateCanBeFoundByParty(){
        candidate1 = candidateRepository.findByParty(Party.PDP);
        assertEquals("Female", candidate1.getGender());
    }
    @Test
    public void testThatCandidateCanBeDeletedByName(){
        Candidate candidate = candidateRepository.findById(1);
        assertEquals("Blessing", candidate.getName());
        assertEquals(2, candidateRepository.getCandidateList());
        candidateRepository.deleteById(1);
        assertEquals(1, candidateRepository.getCandidateList());
    }
}

