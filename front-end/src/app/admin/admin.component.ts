import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {AdminService} from "../services/admin.service";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent implements OnInit {
  form: FormGroup
  classes: string[] = [];

  protected select: string = 'utilisateur';

  constructor(private fb: FormBuilder,
              private snackBar: MatSnackBar,
              private adminService: AdminService) {
    this.form = this.fb.group({
      className: ['', Validators.required],
      rowCount: ['', [Validators.required, Validators.min(1)]]
    });
  }

  ngOnInit(): void {
    this.adminService.getClasses().subscribe(classes => this.classes = classes);
  }

  onSubmit(): void {
    if (this.form.valid) {
      const {className, rowCount} = this.form.value;
      //this.adminService.generateData(this.form.get('className')?.value, this.form.get('rowCount')?.value).subscribe();
      this.adminService.generateData(className, rowCount).subscribe({
        next: () => {
          console.log('Data generated successfully');
          this.snackBar.open('Données générées avec succès', 'Fermer', {duration: 3000});
        },
        error: (error) => {
          console.error('Error generating data:', error);
          this.snackBar.open(`Erreur: ${error.message}`, 'Fermer', {duration: 3000});
        }
      });
    } else {
      console.warn('Form is invalid');
    }

  }
}
