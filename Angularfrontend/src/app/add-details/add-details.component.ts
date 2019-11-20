import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { VendorService } from '../vendor.service';
import { VendorPerson } from '../vendorperson';

@Component({
  selector: 'app-add-details',
  templateUrl: './add-details.component.html',
  styleUrls: ['./add-details.component.scss']
})
export class AddDetailsComponent implements OnInit {

  vendors: VendorPerson[];
  vendor = new VendorPerson();
  

  constructor(private router:Router,private _vendorService:VendorService) { }

  ngOnInit() {
  }
  addVendor(): void{
    this._vendorService.addVendor(this.vendor)
      .subscribe((response)=>{
        console.log(response);
        this.router.navigate(['/viewVendors']);
       
      }, (error)=>{
        console.log(error);
      });
  }
}
