import { Component } from '@angular/core';
import { Log } from '../log';
import { LogService } from '../log.service';

@Component({
  selector: 'app-loglist',
  templateUrl: './loglist.component.html',
  styleUrl: './loglist.component.css'
})
export class LoglistComponent {
  logs: Log[] | undefined;
  constructor(private logService: LogService){}

  ngOnInit(): void{
    this.getLogs();
  }

  private getLogs(){
    this.logService.getLogList().subscribe(data => {
      this.logs = data;
    })
  }
}
