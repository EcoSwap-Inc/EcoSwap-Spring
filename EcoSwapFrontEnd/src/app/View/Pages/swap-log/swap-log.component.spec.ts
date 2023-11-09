import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SwapLogComponent } from './swap-log.component';

describe('SwapLogComponent', () => {
  let component: SwapLogComponent;
  let fixture: ComponentFixture<SwapLogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SwapLogComponent]
    });
    fixture = TestBed.createComponent(SwapLogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
