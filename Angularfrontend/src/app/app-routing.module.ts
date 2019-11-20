import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ViewDetailsComponent } from './view-details/view-details.component';
import { AddDetailsComponent } from './add-details/add-details.component';
import { EditvendorComponent } from './editvendor/editvendor.component';


const routes: Routes = [
  {path:'',component:LoginComponent},
   {path:'viewVendors',component:ViewDetailsComponent},
   {path:'addVendor',component:AddDetailsComponent},
   {path:'editRecord/:id',component: EditvendorComponent},
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
