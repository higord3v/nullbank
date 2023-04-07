import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerListComponent } from './pages/customer/customer-list/customer-list.component';
import { CustomerCreateUpdateComponent } from './pages/customer/customer-create-update/customer-create-update.component';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [
  { path: 'clientes', component: CustomerListComponent},
  { path: 'clientes/:cpf', component: CustomerCreateUpdateComponent},
  { path: '', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
