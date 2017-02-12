
import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import {Book} from "./book";

@Injectable()
export class BookService {

  constructor(private http:Http) {
  }

  public findAllBooks(): Observable<Book[]> {
    let options: RequestOptions = new RequestOptions();
    let headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    options.headers = headers;
    options.withCredentials = true;
    return this.http.get('http://localhost:8080/books', options).map(resp => resp.json());
  }

  public createBook(book:Book): Observable<Book> {
    let options: RequestOptions = new RequestOptions();
    let headers: Headers = new Headers();
    headers.append('Content-Type', 'application/json');
    options.headers = headers;
    options.withCredentials = true;
    return this.http.post('http://localhost:8080/books', book, options).map(resp => resp.json());
  }

}
