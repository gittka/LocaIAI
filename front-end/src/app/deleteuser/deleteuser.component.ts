import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-deleteuser',
  templateUrl: './deleteuser.component.html',
  styleUrl: './deleteuser.component.css'
})
export class DeleteuserComponent {
  constructor(public dialogRef: MatDialogRef<DeleteuserComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  onDelete(): void {
    // delete the user
    this.dialogRef.close(true);
  }

  onCancel(): void {
    this.dialogRef.close(false);
  }

}
