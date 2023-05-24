import { StatusName } from './statistics';
import { Profile } from './profile';
import { Initiative } from './initiative';

export interface Wish {
  id: number;
  status: StatusName;
  createdDate?: Date;
  volunteerProfile?: Profile;
  initiative?: Initiative;
}
