import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  PATH_OF_API = "http://localhost:4001";

  requestHeader = new HttpHeaders(
    { "No-Auth": "True" }
  );
  constructor(private httpClient: HttpClient,
    private userAuthService: UserAuthService) { }

   public registerUser(registerData){
    return this.httpClient.post(this.PATH_OF_API+"/registerNewUser", registerData);
   } 

   public registerVendor(registerData){
    return this.httpClient.post(this.PATH_OF_API+"/registerNewVendor", registerData);
   }

  public login(loginData: any) {
    return this.httpClient.post(this.PATH_OF_API + "/authenticate", loginData, { headers: this.requestHeader })
  }
  public forUser() {
    return this.httpClient.get(this.PATH_OF_API + '/forUser', { responseType: 'text' });
  }

  public forAdmin() {
    return this.httpClient.get(this.PATH_OF_API + '/forAdmin', { responseType: 'text' });
  }

  public forVendor() {
    return this.httpClient.get(this.PATH_OF_API + '/forVendor', { responseType: 'text' });
  }

  public roleMatch(allowedRoles): boolean {
    let isMatch = false;
    const userRoles: any = this.userAuthService.getRoles();

    if (userRoles != null && userRoles) {
      for (let i = 0; i < userRoles.length; i++) {
        for (let j = 0; j < allowedRoles.length; j++) {

          if (userRoles[i].roleName === allowedRoles[j]) {
            isMatch = true;

          }

        }
      }
    }
    return isMatch;

  }
}
