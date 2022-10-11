import { Component } from '@angular/core';

import { UploadService } from 'src/app/services/upload.service';
import { LoadingService } from 'src/app/services/utils/loading.service';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent {
  
  files: File[] = [];
  $loading = this.loadingService.$loading;

  constructor(private uploadService: UploadService, private loadingService: LoadingService) {}

  onFileSelected(event: any) {
    this.files = event.target.files;
  }

  sendFiles() {
  Array.from(this.files).forEach(file => 
    this.uploadService.upload(file).subscribe({
      complete() {
        console.log('complete');
      },
      error() {
        console.log('error');
      }
    }));
  }
}
