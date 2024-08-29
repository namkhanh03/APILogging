import { Component } from '@angular/core';
import { Log, Page } from '../log';
import { LogService } from '../log.service';
import { isEmpty } from 'rxjs';

@Component({
  selector: 'app-loglist',
  templateUrl: './loglist.component.html',
  styleUrl: './loglist.component.css'
})
export class LoglistComponent {
  logs: Log[] | undefined;
  method!: string
  currentPage = 0;
  pageSize = 10;
  totalPages!: number;
  constructor(private logService: LogService){}

  ngOnInit(): void{
    this.getLogs();
    this.searchLogs();
  }

  private getLogs(){
    this.logService.getLogList(this.currentPage, this.pageSize).subscribe((data : Page<Log>) => {
      this.logs = data.content;
      this.totalPages = data.totalPages;
    })
  }

  searchLogs(){
    this.logService.searchLogList(this.currentPage, this.pageSize, this.method).subscribe((data : Page<Log>) => {
      if(data.content.length != 0){
        this.logs = data.content;
        this.totalPages = data.totalPages;
      } else {
        this.getLogs()
      }
    })
  }

  changePage(page: number): void {
    if (page >= 0 && page < this.totalPages) {
      this.currentPage = page;
      this.searchLogs();
    }
  }

  
}
