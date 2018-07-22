import {User} from "../login/user";

export class Challenge {

  id: number;
  name: String;
  description: String;
  start: Date;
  endDate: Date;
  currentValue: number;
  goal: number;
  isFinished: boolean;
  createdAt: Date;
  updatedAt: Date;
  creator: User;
}

export interface ChallengeProgress {
  value: string;
}

export interface LikeByChallenge {
  likeCount: number;
  currentUserLikedChallenge: boolean;
}
