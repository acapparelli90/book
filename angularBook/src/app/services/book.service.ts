import { HttpClient, HttpParams } from '@angular/common/http'
import { BOOKS } from './../../server/mock-book';
import { Injectable } from '@angular/core';
import { Book } from '../model/book';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';


@Injectable()
export class BookService {

  constructor(private http: HttpClient) {
  }

  private URL = ' http://localhost:3000/book';
  book: Book[]; 

  getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.URL);
  }

  getBooksByFilter(filter:string): Observable<Book[]> { 
    return this.http.get<Book[]>(this.URL + '/' + filter);
  } 

  add(book: Book): Observable<Book> {
    return this.http.post<Book>(this.URL, book);

  }

  edit(book: Book): Observable<Book> {
    return this.http.patch<Book>(this.URL + '/' + book.id, book);
  }

  getBook(id: any): Observable<Book> {
    return this.http.get<Book>(this.URL + '/' + id);
  }
  
  delete(id: number): Observable<any> {
    return this.http.delete<any>(this.URL + '/' + id);
  }

}
