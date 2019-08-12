import {Component, OnInit} from '@angular/core';
import {MovieService} from '../movie.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  movies: any = [];

  searchResults: any = [];

  constructor(private movieService: MovieService) {
  }

  ngOnInit() {
    this.getMovies();
  }

  getMovies() {
    this.movies = [];
    this.movieService.getMovies().subscribe((data: {}) => {
      this.movies = data;
    });
  }

  searchRequest(e) {
    const search = e.target.value;
    this.searchResults = this.movieService.search(search).subscribe((data: {}) => {
      this.searchResults = data;
    });
  }

}
