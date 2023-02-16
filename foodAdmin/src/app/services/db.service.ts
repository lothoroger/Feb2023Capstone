import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { BehaviorSubject } from 'rxjs';
import { BaseUrls } from 'src/assets/BaseUrls';
import { Cuisines } from '../model/cuisines';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class DbService {
  user: BehaviorSubject<User[]> = new BehaviorSubject<User[]>([]);
  userRetrievedBool: boolean = false;


  customers: BehaviorSubject<User[]> = new BehaviorSubject<User[]>([]);
  custRetrievedBool: boolean = false;
  
  cuisines: BehaviorSubject<Cuisines[]> = new BehaviorSubject<Cuisines[]>([]);
  cuisinesRetrievedBool: boolean = false;


  constructor(private http: HttpClient, private router: Router, private toast: ToastrService) { }

  getUser() {
    this.http.get(BaseUrls.getLoginUrl(BaseUrls.USER_GROUPURL))
      .subscribe({
        next: ({ code, findUser, message }: any) => {
          this.user.next(findUser);
          this.userRetrievedBool = true;
        },
        error: (error) => {
          console.log(error);
        }
      })

  }


  getCustomers() {
    this.http.get(BaseUrls.getUrl(BaseUrls.USER_GROUPURL))
      .subscribe({
        next: async ({ code, user, message }: any) => {
          this.customers.next(Object.assign([], user));
          this.custRetrievedBool = true;
                 
        },
        error: (error) => {
          console.log(error);
        }
      })

  }

  getCuisines() {
    this.http.get(BaseUrls.getUrl(BaseUrls.CUISINES_GROUPURL))
      .subscribe({
        next: async ({ code, cuisines, message }: any) => {
          this.cuisines.next(Object.assign([], cuisines));
          console.log("Cusines ", cuisines)
          console.log("Cusines m ", message)
          this.cuisinesRetrievedBool = true;
                 
        },
        error: (error) => {
          console.log(error);
        }
      })

  }



  addUser(data: any) {
    console.log("Data on dbservice addUser ", data);
    this.http.post(BaseUrls.addUser(BaseUrls.USER_GROUPURL), data)
      .subscribe({
        next: ({ code, data, message }: any) => {
          this.user.next(data);
          this.userRetrievedBool = true;
         
        },
        error: (error) => {
          console.log(error);
        }
      })

  }

  /*loginUser(value: { email: string; password: string} ) {
  
    console.log("db service Loginuser ", value);
    const formData = new FormData();
    formData.append("email", value.email.trim() || "");
    formData.append("password", value.password.trim() || "");

    this.http.post(BaseUrls.getLoginUrl(BaseUrls.USER_GROUPURL), formData )
      .subscribe({
        next: ({ code, data, message }: any) => {
          console.log("Subscribe on Dbscercie Loginuser ", formData);
          localStorage.setItem("authCode", code);
          localStorage.setItem("user ", JSON.stringify(data[0]));
          this.toast.success(message, "Login Successfull");
          this.router.navigate(['/administrator'], { replaceUrl: true })
         

        },
        error: (error) => {
          console.log(error);
        }
      })
*/
  }



