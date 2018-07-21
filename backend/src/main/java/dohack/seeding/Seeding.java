package dohack.seeding;

import dohack.challenge.model.Challenge;
import dohack.challenge.repo.ChallengeRepository;
import dohack.challenge.service.ChallengeService;
import dohack.like.model.UserLikesChallenge;
import dohack.like.repo.UserLikesChallengeRepository;
import dohack.like.service.UserLikesChallengeService;
import dohack.user.model.User;
import dohack.user.repo.UserRepository;
import dohack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class Seeding {
   @Autowired
   public UserService userService;
   @Autowired
   public ChallengeService challengeService;
   @Autowired
   public UserLikesChallengeService userLikesChallengeService;
   @Autowired
   public UserRepository userRepository;
   @Autowired
   public ChallengeRepository challengeRepository;
   @Autowired
   public UserLikesChallengeRepository userLikesChallengeRepository;
   
   public Seeding() {
   
   }
   
   public void seedData(){
      // Create users
      User david = new User("david", "david", "david david david");
      User john = new User("john", "john", "john john john");
      User marie = new User("marie", "marie", "marie marie marie");
      User sarah = new User("sarah", "sarah", "sarah sarah sarah");
      User tom = new User("tom", "tom", "tom tom tom");
   
      // Add to list
      ArrayList<User> users = new ArrayList<>();
      users.add(david);
      users.add(john);
      users.add(marie);
      users.add(sarah);
      users.add(tom);
   
   
      // Create Challenges
      Challenge A = new Challenge("Push up", "AAAAA", new Date(), new Date(), 76, 9, false, new Date(), new Date(), david);
      Challenge B = new Challenge("Mana", "BBBBB", new Date(), new Date(), 12, 12, true, new Date(), new Date(), john);
      Challenge C = new Challenge("Blacklist", "CCCCC", new Date(), new Date(), 98, 98, true, new Date(), new Date(), david);
      Challenge D = new Challenge("Computer", "DDDDD", new Date(), new Date(), 23, 10, false, new Date(), new Date(), tom);
      Challenge E = new Challenge("Crazy", "EEEEE", new Date(), new Date(), 65, 34, false, new Date(), new Date(), sarah);
      Challenge F = new Challenge("Shit", "FFFFF", new Date(), new Date(), 98, 100, true, new Date(), new Date(), tom);
      Challenge G = new Challenge("Boom", "GGGGG", new Date(), new Date(), 45, 14, false, new Date(), new Date(), tom);
   
      // Add to list
      ArrayList<Challenge> challenges = new ArrayList<>();
      challenges.add(A);
      challenges.add(B);
      challenges.add(C);
      challenges.add(D);
      challenges.add(E);
      challenges.add(F);
      challenges.add(G);
   
   
      // Create likes
      UserLikesChallenge a = new UserLikesChallenge(john, G);
      UserLikesChallenge b = new UserLikesChallenge(marie, A);
      UserLikesChallenge c = new UserLikesChallenge(marie, E);
      UserLikesChallenge d = new UserLikesChallenge(john, A);
      UserLikesChallenge e = new UserLikesChallenge(sarah, D);
      UserLikesChallenge f = new UserLikesChallenge(tom, C);
      UserLikesChallenge g = new UserLikesChallenge(david, C);
      UserLikesChallenge h = new UserLikesChallenge(marie, B);
      UserLikesChallenge i = new UserLikesChallenge(david, D);
   
      // Add to list
      ArrayList<UserLikesChallenge> userLikesChallenges = new ArrayList<>();
      userLikesChallenges.add(a);
      userLikesChallenges.add(b);
      userLikesChallenges.add(c);
      userLikesChallenges.add(d);
      userLikesChallenges.add(e);
      userLikesChallenges.add(f);
      userLikesChallenges.add(g);
      userLikesChallenges.add(h);
      userLikesChallenges.add(i);
   
   
   
   
      // Save objects
      this.userRepository.saveAll(users);
      this.challengeRepository.saveAll(challenges);
      this.userLikesChallengeRepository.saveAll(userLikesChallenges);
   }
   

   
}
