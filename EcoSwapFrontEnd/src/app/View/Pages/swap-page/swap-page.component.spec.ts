import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SwapPageComponent } from './swap-page.component';

describe('SwapPageComponent', () => {
  let component: SwapPageComponent;
  let fixture: ComponentFixture<SwapPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SwapPageComponent]
    });
    fixture = TestBed.createComponent(SwapPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
