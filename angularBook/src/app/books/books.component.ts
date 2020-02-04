import { BookService } from './../services/book.service';
import { BOOKS } from './../../server/mock-book';
import { Component, OnInit } from '@angular/core';
import { Book } from '../model/book';
import { Router } from '@angular/router';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  filter="";
  books: Book[];
  book: Book;
  selectBook: Book;

  constructor(private service: BookService, private router: Router) { }

  getBook(book: Book): void {
    this.selectBook = book;
  }

  cancella(book: Book, i) { 
  if(confirm('Elimina ' + book.titolo + '?')){ 
    this.delete(book, i); }
  }

  delete(book: Book, i) { 
    this.service.delete(book.id)
      .subscribe(  next => {this.books.splice(i,1) }
      )
    }
       
  getBooks() {
    this.service.getBooks()
      .subscribe(books => this.books = books);
  }

  ngOnInit() {
    this.getBooks();
  } 
}