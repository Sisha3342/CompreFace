import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DragNDropModule } from '../drag-n-drop/drag-n-drop.module';
import { FaceRecognitionComponent } from './face-recognition.component';
import { FaceRecognitionService } from '../../core/face-recognition/face-recognition.service';
import { RecognitionResultComponent } from './recognition-result/recognition-result.component';
import { SpinnerModule } from '../spinner/spinner.module';

@NgModule({
  declarations: [FaceRecognitionComponent, RecognitionResultComponent],
  imports: [
    CommonModule,
    DragNDropModule,
    SpinnerModule
  ],
  providers: [ FaceRecognitionService ],
  exports: [FaceRecognitionComponent]
})
export class FaceRecognitionModule { }
