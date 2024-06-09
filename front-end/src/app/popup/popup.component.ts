import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrl: './popup.component.css'
})
export class PopupComponent {
  @Input() annonce: any;
  @Output() close = new EventEmitter<void>();

  closePopup(): void {
    this.close.emit();
  }

}
