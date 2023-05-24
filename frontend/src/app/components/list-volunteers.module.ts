import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { VolunteersComponent } from './volunteers/volunteers.component';
import { ListComponent } from './list/list.component';
import { HeaderComponent } from './header/header.component';
import { TitleComponent } from './title/title.component';

const VOLUNTEERS_ROUTES: Routes = [
  { path: '', redirectTo: 'volunteers', pathMatch: 'full'},
  { path: 'volunteers', children: [
    { path: '', component: VolunteersComponent },
  ]}
]


@NgModule({
  declarations: [
    VolunteersComponent,ListComponent, HeaderComponent, TitleComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(VOLUNTEERS_ROUTES),
    FontAwesomeModule,
  ]
})
export class ListVolunteersModule { }
