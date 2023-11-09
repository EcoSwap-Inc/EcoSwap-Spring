// menu.service.ts
import { Injectable } from '@angular/core';

@Injectable()
export class MenuService {
  private isMiniMenuOpen = false;

  toggleMiniMenu() {
    this.isMiniMenuOpen = !this.isMiniMenuOpen;
  }

  MiniMenuOpen() {
    return this.isMiniMenuOpen;
  }
}