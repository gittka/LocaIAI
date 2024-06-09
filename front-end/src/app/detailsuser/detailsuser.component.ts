import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-detailsuser',
  templateUrl: './detailsuser.component.html',
  styleUrl: './detailsuser.component.css'
})
export class DetailsuserComponent {
  constructor(public dialogRef: MatDialogRef<DetailsuserComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  onClosed(): void {
    this.dialogRef.close();
  }
}
