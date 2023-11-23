import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogCardsComponent } from './log-cards.component';

describe('LogCardsComponent', () => {
  let component: LogCardsComponent;
  let fixture: ComponentFixture<LogCardsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LogCardsComponent]
    });
    fixture = TestBed.createComponent(LogCardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
