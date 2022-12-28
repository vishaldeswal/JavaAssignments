import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }
  public setUserName(userName: string){
    localStorage.setItem("userName", userName); 
   }

   public getUserName() :string{
      return localStorage.getItem("userName");
   }

   public setUserFirstName(userFirstName: string){
    localStorage.setItem("userFirstName", userFirstName); 
   }

   public getFirstUserName() :string{
      return localStorage.getItem("userFirstName");
   }

   public setUserLastName(userLastName: string){
    localStorage.setItem("userLastName", userLastName); 
   }

   public getLastUserName() :string{
      return localStorage.getItem("userLastName");
   }

   public setUserPassword(userPassword: string){
    localStorage.setItem("userPassword", userPassword); 
   }

   public getUserPassword() :string{
      return localStorage.getItem("userPassword");
   }


  public setRoles(roles:[]){
    localStorage.setItem("roles", JSON.stringify(roles));
  }

  public getRoles() :[]{
    return JSON.parse(localStorage.getItem("roles"));
  }

  public setToken(jwtToken:string){
    localStorage.setItem("jwtToken", jwtToken);
  }

  public getToken() :string{
    return localStorage.getItem("jwtToken");
  }

  public clear(){
    localStorage.clear();
  }

  public isLoggedIn(){
    return this.getRoles() && this.getToken();
  }

  public isAdminOrVendor() :boolean {
    const roles: any[] =this.getRoles();
    const role:string =roles[0].roleName;

    if(role==='Admin' || role==='Vendor'){
      return true;
    }
    else{
      return false;
    }
  }

  public isUser() :boolean{
    const roles: any[] =this.getRoles();
    return roles[0].roleName==='User';
  }
}
