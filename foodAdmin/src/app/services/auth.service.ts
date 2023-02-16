import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { BehaviorSubject } from 'rxjs';
import { BaseUrls } from 'src/assets/BaseUrls';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  User = new BehaviorSubject<any>(null);
  
  userRetrievedBool: boolean = false;
  customers: BehaviorSubject<User[]> = new BehaviorSubject<User[]>([]);
  custRetrievedBool: boolean = true;
  IsAdmin = false;
  constructor(
    // private authorize: AuthService,
    private toast: ToastrService,
    private http: HttpClient,
    private routed: ActivatedRoute,
    private router: Router

  ) { }

/*
  public get UserSubjectValue() {
    if (this.IsAdmin) {
      console.log("auth service UserSubjectValue ", this.User)
      return this.IsAdmin;
    } else {
      console.log("auth on UserSubjectvalue is not ture ", this.User)
      console.log("auth on UserSubjectvalue is not ture a ", this.IsAdmin)
      return null
    }
  }


  SignInUser(loginaccount: any) {
    console.log("login user", loginaccount.Username);
    if (loginaccount.Username == "admin@lanl.gov") {
      this.User.next(loginaccount);
    }
  }

  SignOutUser() {
    this.User.next(null);
  }


  role: any;
*/
  ngOnInit(): void {
  /*  this.routed.queryParams.subscribe((params: any) => {
      this.User.value.role = Object.values(params).toString();
      console.log(" value of role is ",this.User.value.role );
      if (this.User.value.role == "Customer") {
        this.IsAdmin = false;
      } else {
        this.IsAdmin = true;
      }
      console.log(" on NGinit autservice ", this.UserSubjectValue?.valueOf.toString);

     
    });
  */ }

  UserRole() {
  this.routed.queryParams.subscribe((params: any) => {
    this.User.value.role = Object.values(params).toString();
    console.log(" value of role is ",this.User.value.role );
    if (this.User.value.role == "Customer") {
      this.IsAdmin = false;
    } else {
      this.IsAdmin = true;
    }
   
  });
  }
  /*loginSubmit = () => {
    //this.router.navigate(['/register'], { queryParams: { data: this.role } });
    console.log("login data ", this.loginForm.value);
    let loginaccount = {
      Username: "admin@lanl.gov",
      Password: "admin123"
    }
    console.log("Login form ", loginaccount);
    this.authorize.SignInUser(loginaccount);  } 

  loginUser(data: any ) {
    
    window.alert(JSON.stringify(data));
    console.log("auth service Loginuser ", data);
    const formData = new FormData();
    formData.append("email", data.email.trim() || "");
    formData.append("password", data.password.trim() || "");
   

    this.http.post(BaseUrls.getLoginUrl(BaseUrls.USER_GROUPURL), formData)
      .subscribe({
        next:  async({ code, formData, message }: any) => {
          localStorage.setItem("authCode: ", formData);
          //this.toast.success(message, "Login Successfull");
          console.log("loginUser auth Is amdin ", this.User.value);
          if (this.UserSubjectValue) {
            console.log("baseurl login line 111 True for UserSubjectvalue");
          this.router.navigate(['/payment'], { replaceUrl: true })
          }
          else {
            console.log("baseurl login line 111 false for UserSubjectvalue");
            this.router.navigate(['/customers'], { replaceUrl: true })
          }
        

        },
        error: (error) => {
          console.log(error);
        }
      })
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['login'], { replaceUrl: true });
  }



*/


}
