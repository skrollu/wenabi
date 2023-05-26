import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { VolunteersComponent } from '../../views/volunteers/volunteers.component';
import { ListComponent } from './components/list/list.component';
import { HeaderComponent } from '../../layout/header/header.component'
import { TitleComponent } from './components/title/title.component';
import { VolunteerCard } from './components/volunteer-card/volunteer-card.component';
import { StatusComponent } from 'src/app/shared/status/status.component';

const VOLUNTEERS_ROUTES: Routes = [
  { path: '', redirectTo: 'volunteers', pathMatch: 'full'},
  { path: 'volunteers', children: [
    { path: '', component: VolunteersComponent },
  ]}
]


@NgModule({
  declarations: [
    VolunteersComponent, ListComponent, HeaderComponent, TitleComponent, VolunteerCard, StatusComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(VOLUNTEERS_ROUTES),
    FontAwesomeModule,
  ]
})
export class ListVolunteersModule { }
