package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.services.IContestService;

public class CreateContestCommand implements ICommand{

    private final IContestService contestService;

    public CreateContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IContestService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_CONTEST","CRIODO2_CONTEST","LOW Monica","40"]
    // or
    // ["CREATE_CONTEST","CRIODO1_CONTEST","HIGH","Ross"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        String contestName = tokens.get(1);
        Level level = Level.valueOf(tokens.get(2));
        String creatorName = tokens.get(3);
        Contest contest;
        try {
            if (tokens.size() == 5)
                contest = contestService.create(contestName, level, creatorName, Integer.parseInt(tokens.get(4)));
            else
                contest = contestService.create(contestName, level, creatorName, null);
            System.out.println(contest);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
