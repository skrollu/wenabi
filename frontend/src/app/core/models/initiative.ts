import { Profile } from './profile';

export interface Initiative {
  id: number;
  title: string;
  streetName: string;
  city: string;
  postalCode: string;
  country: string;
  coordinatorProfile: Profile;
}
