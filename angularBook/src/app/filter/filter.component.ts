import { Component, OnInit } from '@angular/core';
import { Book } from '../model/book';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from '../services/book.service';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {

  filter: string;
  books: Book[];
  book: Book;

  constructor(private service: BookService, private router: Router, private route: ActivatedRoute) {
    this.route.paramMap.subscribe(param => {
      if (param.has("filter")) {
        this.filter = param.get("filter")
        this.service.getBooksByFilter(this.filter).subscribe(result => { this.books = result });
      }
      console.log(this.filter);
    })

  }

  getBooksByFilter() {
    this.service.getBooksByFilter(this.filter).subscribe(result => { this.books = result });
  }



  ngOnInit() {
    this.getBooksByFilter();
  }

} 