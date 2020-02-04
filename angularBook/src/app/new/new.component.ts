import { NgForm } from '@angular/forms';
import { Book } from './../model/book';
import { Component, OnInit } from '@angular/core'; 
import { BookService } from '../services/book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.css']
})
export class NewComponent implements OnInit {
  book: Book;

  constructor(private service: BookService, private router: Router) {
    this.book = new Book();
   }

  readUrl(event: any) {
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader(); 
      reader.onload = (event: any) => {
        this.book.img = event.target.result;
      };
      reader.readAsDataURL(event.target.files[0]);
    }
  }

  add(book): void {
    this.service.add(this.book) 
    .subscribe(book => {this.book = book
    this.router.navigate(['']);
    })
  }

  goBack() {
    this.router.navigate(['']);
  } 

  ngOnInit() {
  }

}
