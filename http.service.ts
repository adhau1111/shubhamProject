import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  baseUrl:string='http://localhost:8080/api/'
  constructor(private http:HttpClient) { }
  GetAllEmpRecord(){
return(this.http.get(`${this.baseUrl}GetAllEmpPerticularApi`));

  }
  getRecordById(id:any){

    return(this.http.get(`${this.baseUrl}getEmpDataById/${id}`));

  }
  getAllCountry(){

   return (this.http.get(`${this.baseUrl}getAllCdata`));
  }

  PostRecord(obj:any){

    return(this.http.post(`${this.baseUrl}addEmpData`,obj,{
      responseType:'text'
    }));

  }
  updateRecord(obj:any){
    return(this.http.put(`${this.baseUrl}UpdateApi`,obj,{
responseType:'text'

    }));

  }
  deleteData(id:any){
return(this.http.delete(`${this.baseUrl}deleteEmpApi/${id}`,{
responseType:'text'

}));


}

}
