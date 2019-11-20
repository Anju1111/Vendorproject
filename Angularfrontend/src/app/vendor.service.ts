import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { VendorPerson } from './vendorperson';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VendorService {

  constructor(private _httpService:HttpClient) { }
  getAllVendors(): Observable<VendorPerson[]>{
    return this._httpService.get<VendorPerson[]>(environment.APIUrl +'vendor/vendordetails');
  }
  getVendorById(id:number): Observable<VendorPerson>{
    return this._httpService.get<VendorPerson>(environment.APIUrl +'vendors/'+id);
  }

  searchVendor(search:string): Observable<VendorPerson[]>{
    return this._httpService.get<VendorPerson[]>(environment.APIUrl +'vendor/'+search);
  }

  disableVender(id:number): Observable<VendorPerson>{

    let body = JSON.stringify(id);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

    return this._httpService.put<VendorPerson>(environment.APIUrl +'disablevendor/'+id,body,options); 

  }
  updateRecord(product:VendorPerson)
  {
    let body = JSON.stringify(product);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

    return this._httpService.post(environment.APIUrl +'vendor/insert',body,options);  
  }
  addVendor(vendor:VendorPerson)
  {
    let body = JSON.stringify(vendor);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers } 

    console.log(vendor.vendorId);
    if(vendor.vendorId )
    {
      return this._httpService.post(environment.APIUrl +'/api/vendor/insert',body,options);
      
   }
    else
    {
      return this._httpService.put(environment.APIUrl +'/api/vendor/insert',body,options);
    }
  }
}
