
import {Injectable} from "@angular/core";
import {UserFormData} from "./user.form.data";
import {Http, RequestOptions, Headers, Response} from "@angular/http";
import {Observable} from "rxjs";
import {User} from "./user";

@Injectable()
export class LoginService {

  constructor(private http: Http) {
  }

  login(userdata: UserFormData): Observable<User> {
    let options: RequestOptions = new RequestOptions();
    let headers: Headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa(userdata.email + ':' + userdata.password));
    headers.append('X-Requested-With', 'XMLHttpRequest');
    headers.append('Content-Type', 'application/json');
    options.headers = headers;
    options.withCredentials = true;

    return this
      .http
      .get('http://localhost:8080/currentuser', options)
      .map(res => { res.json() })
      .catch((error:Response) => this.handleError(error));
  }

  getCurrentUser(): Observable<User> {
    let options: RequestOptions = new RequestOptions();
    let headers: Headers = new Headers();
    headers.append('Content-Type', 'application/json');
    options.headers = headers;

    return this
      .http
      .get('http://localhost:8080/currentuser', options).map(res => res.json());
  }

  private handleError(error:Response): Observable<any> {
    console.warn(error.statusText);
    return Observable.throw(error.statusText);
  }
}
