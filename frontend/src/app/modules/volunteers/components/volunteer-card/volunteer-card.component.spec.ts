import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VolunteerCard } from './volunteer-card.component';

describe('VolunteerCardComponent', () => {
  let component: VolunteerCard;
  let fixture: ComponentFixture<VolunteerCard>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VolunteerCard ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VolunteerCard);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
