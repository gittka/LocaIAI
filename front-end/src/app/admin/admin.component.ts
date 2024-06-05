import { Component } from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {AdminService} from "../services/admin.service";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
  protected select: string = 'utilisateur';

  constructor(private fb: FormBuilder,
  private snackBar: MatSnackBar,
  private adminService: AdminService) { }

}
