import { Component, OnInit } from '@angular/core';
import { VendorPerson } from '../vendorperson';
import { VendorService } from '../vendor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-details',
  templateUrl: './view-details.component.html',
  styleUrls: ['./view-details.component.scss']
})
export class ViewDetailsComponent implements OnInit {

  vendors: VendorPerson[];
  vendor = new VendorPerson();
  search: string;
  

  constructor(private _vendorService:VendorService, private router:Router) { }


  ngOnInit() {

    this.getAllVendors();
  }

  getAllVendors(): void {
    this._vendorService.getAllVendors()
      .subscribe((vendorData) => {
        this.vendors = vendorData;
        console.log(vendorData);
      }, (error) => {
        console.log(error);
      });

  }

  view()
  {
    this.router.navigate(['/viewVendors']);
  }
  add()
  {
    this.router.navigate(['/addVendor'])
  }
  // edit(vendorId:number)
  addvendor(): void{
    this.router.navigate(['addvendor']);
  }
  edit(id:number)
  {
    this.router.navigate(['/editRecord/'+id]);
  }

  logout(id:number)
  {
    this.router.navigate(['']);
  }
  searchVendor(search:string):void{
    console.log(search);
if(search!=null)
{
  console.log(search);
  this._vendorService.searchVendor(search).subscribe((vendordata)=>{
    this.search=undefined;
    this.vendors=vendordata,
    console.log(vendordata);
  },(error)=>{console.log(error);}
  );
}
  else{

    this.getAllVendors();
  }
}

disable(venderId:number):void{
  this._vendorService.disableVender(venderId)
  .subscribe((data)=>{
    this.getAllVendors();
    console.log(data)
  },
  (error)=>{
    console.log(error)
  })
  }


  }