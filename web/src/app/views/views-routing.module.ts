import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientList } from './client-list/client-list';

const routes: Routes = [
    {
        path: 'clients',
        component: ClientList
    }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ViewsRoutingModule { }
