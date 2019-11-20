import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {  NgxPaginationModule } from 'ngx-pagination';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { AddDetailsComponent } from './add-details/add-details.component';
import { ViewDetailsComponent } from './view-details/view-details.component';
import { VendorService } from './vendor.service';
import { EditvendorComponent } from './editvendor/editvendor.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AddDetailsComponent,
    ViewDetailsComponent,
    EditvendorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxPaginationModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [VendorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
