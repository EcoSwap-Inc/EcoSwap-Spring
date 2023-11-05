import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MainCatalogueComponent } from './main-catalogue.component';

describe('MainCatalogueComponent', () => {
  let component: MainCatalogueComponent;
  let fixture: ComponentFixture<MainCatalogueComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MainCatalogueComponent]
    });
    fixture = TestBed.createComponent(MainCatalogueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
