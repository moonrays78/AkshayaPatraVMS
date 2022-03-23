import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { ApplicationConfigService } from "../application-config/application-config.service";
import * as FileSaver from 'file-saver';

@Injectable({
  providedIn: 'root'
})
export class CsvExportService {

  constructor(private http: HttpClient, private applicationConfigService: ApplicationConfigService) {}

  csvOfCurrentlyRegisteredVolunteers$(eventId: number) {
    this.http.get(this.applicationConfigService.getEndpointFor('/api/events/exportCSV' + `?eventID=${eventId}`), { responseType: 'blob' })
      .subscribe((resp: any) => {
        FileSaver.saveAs(resp, `Registered Volunteers.csv`)
      });
  }


}
