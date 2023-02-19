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


 

  getCuisines() {
    this.http.get(BaseUrls.getUrl(BaseUrls.CUISINES_GROUPURL))
      .subscribe({
        next: async ({ code, data, message }: any) => {
          this.cuisines.next(Object.assign([], data));
          console.log("DB Cusines ", data)
          console.log("DB Cusines message ", message)
          this.cuisinesRetrievedBool = true;
                 
        },
        error: (error) => {
          console.log(error);
        }
      })
    }


    getCustomers() {
      this.http.get(BaseUrls.getUrl(BaseUrls.USER_GROUPURL))
        .subscribe({
          next: async ({ code, data, message }: any) => {
            this.user.next(data);
            console.log("Users  customers ", data)
            console.log("Users message ", message)
            this.userRetrievedBool = true;
                   
          },
          error: (error) => {
            console.log(error);
          }
        })
        
        
    }



/*
      deleteCuisines() {
        this.http.get(BaseUrls.getUrl(BaseUrls.CUISINES_GROUPURL))
          .subscribe({
            next: async ({ code, data, message }: any) => {
              this.cuisines.next(Object.assign([], data));
              console.log("Cusines ", data)
              console.log("Cusines m ", message)
              this.cuisinesRetrievedBool = true;
                     
            },
            error: (error) => {
              console.log(error);
            }
          })



  }

*/

  addUser( newcust: User) {
    console.log("Data on dbservice addUser ", newcust);
    this.http.post(BaseUrls.addUrl(BaseUrls.USER_GROUPURL), newcust)
      .subscribe({
        next: ({ code, data, message }: any) => {
          this.user.next(data);
          this.userRetrievedBool = true;
          
        },
        error: (error) => {
          console.log(error);
        }
      })
      if (newcust.role = "Customer") {
        this.router.navigateByUrl('/orders');
        } else {
          this.router.navigateByUrl('/customers');
        }
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



